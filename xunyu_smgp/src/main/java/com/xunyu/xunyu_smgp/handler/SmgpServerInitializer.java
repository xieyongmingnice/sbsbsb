package com.xunyu.xunyu_smgp.handler;

import com.xunyu.xunyu_smgp.codec.SmgpHeaderCodec;
import com.xunyu.xunyu_smgp.codec.SmgpLoginCodec;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author 
 * @description 
 * @date 2018/6/5 16:00
 */
public class SmgpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(4 * 1024 , 0, 4, -4, 0, true))
                .addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS))
                //消息头编解码器
                .addLast(new SmgpHeaderCodec())
                .addLast(new SmgpLoginCodec())
                .addLast(new SmgpServerHandler());

    }
}
