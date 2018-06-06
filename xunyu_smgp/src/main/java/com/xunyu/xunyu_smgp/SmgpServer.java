package com.xunyu.xunyu_smgp;

import com.xunyu.xunyu_smgp.handler.SmgpServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xym
 * @description 服务端
 * @date 2018/4/20 14:18
 */
public class SmgpServer {

    private static final Logger logger = LoggerFactory.getLogger(SmgpServer.class);

    public static void main(String[] args) {
        int port = 8990;
        open(port);
    }

    private static void open(int port){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new SmgpServerInitializer());
            /**
             * 绑定端口、同步等待
             */
            ChannelFuture future = b.bind(port).sync();
            logger.info("启动监听，等待连接：{}，监听端口号：{}",future.isSuccess(),port);
            /**
             * 等待服务监听端口关闭
             */
            future.channel().closeFuture().sync();
        }catch (Exception e){
            logger.error("出现异常："+e.getMessage()+"\r\n原因："+e.getCause());
        }finally {
            /**
             * 关闭
             */
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
