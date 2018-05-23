package com.xunyu.xunyu_smgp;

import com.xunyu.xunyu_smgp.codec.SmgpHeaderCodec;
import com.xunyu.xunyu_smgp.codec.SmgpLoginCodec;
import com.xunyu.xunyu_smgp.handler.SmgpClientConnectManager;
import com.xunyu.xunyu_smgp.handler.SmgpClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;

import java.util.concurrent.TimeUnit;

/**
 * @author xym
 * @description 客户端
 * @date 2018/4/20 14:18
 */
public class SmgpClient {
    public static void main(String[] args) {
        //TODO host port从配置中取
        String host = "localhost";
        int port = 8990;
        SmgpClient smgpClient = CilentInstanceGetter.instance;
        smgpClient.doConnect(host,port);
    }
    /**
     * 1、创建线程池
     * 2、创建通道、注册选择器
     * 3、配置bootstrap参数
     * 4、配置通道
     * 5、建立连接
     * 6、同步等待
     */
    private void doConnect(String host,int port){
        final HashedWheelTimer timer = new HashedWheelTimer();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true);
            final SmgpClientConnectManager manager = getManager(b,timer,port,host,true);
            b.handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline().addLast(manager.handlers());
                }
            });
            //发起异步链接操作
            ChannelFuture channelFuture = b.connect(host, port).sync();

            channelFuture.channel().closeFuture().sync();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    private SmgpClientConnectManager getManager(Bootstrap bootstrap, HashedWheelTimer timer, int port, String host, Boolean reconnect){
        SmgpClientConnectManager manager = new SmgpClientConnectManager(bootstrap,timer,port,host,reconnect) {
            @Override
            public ChannelHandler[] handlers() {
                return new ChannelHandler[]{
                        this,
                        new LengthFieldBasedFrameDecoder(4 * 1024 , 0, 4, -4, 0, true),
                        new IdleStateHandler(0, 0, 5, TimeUnit.SECONDS),
                        new SmgpLoginCodec(),
                        new SmgpHeaderCodec(),
                        new SmgpClientHandler()
                };
            }
        };
        return manager;
    }

    private SmgpClient(){

    }

    private static class CilentInstanceGetter{
        private static SmgpClient instance = new SmgpClient();
    }
}
