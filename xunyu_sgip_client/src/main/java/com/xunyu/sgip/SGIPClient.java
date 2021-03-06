package com.xunyu.sgip;

import com.xunyu.sgip.config.check.ConnectionWatchdog;
import com.xunyu.sgip.config.code.DecodeAndEncoder;
import com.xunyu.sgip.config.factory.MarshallingCodeCFactory;
import com.xunyu.sgip.handler.SGIPClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;

import java.util.concurrent.TimeUnit;


/**
 * 单例模式(客户端)
 *
 * @author 13520
 */
public class SGIPClient {

    public void sgipCli(String host, int port) {
        /**
         * 1、创建线程池
         * 2、创建通道、注册选择器
         * 3、配置bootstrap参数
         * 4、配置通道
         * 5、建立连接
         * 6、同步等待
         */
        final HashedWheelTimer timer = new HashedWheelTimer();
        EventLoopGroup group = new NioEventLoopGroup(1);//单线程模型,基于Reactor
        try {
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            //通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去
            b.option(ChannelOption.TCP_NODELAY, true);
            //保持长连接状态
            b.option(ChannelOption.SO_KEEPALIVE, true);
            final ConnectionWatchdog watchdog = getConnDog(b, timer, port, host, true);
            b.handler(new ChannelInitializer<Channel>() {

                @Override
                protected void initChannel(Channel ch) throws Exception {

                    ch.pipeline().addLast(watchdog.handlers());
                }
            });

            //发起异步链接操作
            ChannelFuture channelFuture = b.connect(host, port).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //group.shutdownGracefully();//关闭线程池

        }
    }

    //电子监听狗
    private ConnectionWatchdog getConnDog(Bootstrap b, HashedWheelTimer timer
            , int port, String host, boolean flag) {
        ConnectionWatchdog watchdog = new ConnectionWatchdog(b, timer, port, host, flag) {

            public ChannelHandler[] handlers() {
                return new ChannelHandler[]{
                        this,
                        new IdleStateHandler(0, 0, 5, TimeUnit.SECONDS),
                        MarshallingCodeCFactory.buildMarshallingEncoder(),
                        MarshallingCodeCFactory.buildMarshallingDecoder(),
                        new DecodeAndEncoder(),
                        new SGIPClientHandler()
                };
            }
        };
        return watchdog;
    }


    /**
     * 开启单例模式
     * 匿名内部类
     */
    private static class SGIPClientSingle {
        private static SGIPClient SINGLE = new SGIPClient();
    }

    /**
     * 构造函数私有化
     */
    private SGIPClient() {
    }

    /**
     * 获取客户端对象
     *
     * @return
     */
    public static SGIPClient getClientSingle() {
        return SGIPClientSingle.SINGLE;
    }
}
