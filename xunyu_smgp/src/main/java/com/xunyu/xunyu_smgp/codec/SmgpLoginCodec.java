package com.xunyu.xunyu_smgp.codec;

import com.xunyu.xunyu_smgp.message.Message;
import com.xunyu.xunyu_smgp.message.SmgpLoginRequestMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @author 
 * @description 
 * @date 2018/5/21 16:46
 */
public class SmgpLoginCodec extends MessageToMessageCodec<Message,SmgpLoginRequestMessage>{
    @Override
    protected void encode(ChannelHandlerContext ctx, SmgpLoginRequestMessage msg, List<Object> out) throws Exception {

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {

    }
}
