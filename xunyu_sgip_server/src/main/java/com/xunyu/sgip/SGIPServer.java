package com.xunyu.sgip;

import com.xunyu.sgip.config.code.DecodeAndEncoder;
import com.xunyu.sgip.config.factory.MarshallingCodeCFactory;
import com.xunyu.sgip.handler.SGIPServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式(服务端)
 */
public class SGIPServer {

    public void SGIPSer(int port) {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//处理接收请求
        EventLoopGroup workerGroup = new NioEventLoopGroup();   //默认是 CPU 核心数乘以2

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 保持连接数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去
                    .option(ChannelOption.TCP_NODELAY, true)
                    //保持长连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 处理新连接
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));//心跳
                            ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                            ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                            ch.pipeline().addLast(new DecodeAndEncoder());
                            ch.pipeline().addLast(new SGIPServerHandler());
                        }
                    });
            //绑定端口、同步等待
            ChannelFuture futrue = b.bind(port).sync();
            System.out.println("启动监听，等待链接。。。" + futrue.isSuccess() + "监听端口号：" + port);
            //等待服务监听端口关闭
            futrue.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * 做单例模式
     * 1、构造函数私有化
     * 2、构建私有内部类
     * 3、返回私有静态对象
     */
    public SGIPServer() {
    }

    private static class SetSGIPServerSingle {
        private static SGIPServer serverSingle = new SGIPServer();
    }

    public static SGIPServer getServerSingle() {
        return SetSGIPServerSingle.serverSingle;
    }
}
