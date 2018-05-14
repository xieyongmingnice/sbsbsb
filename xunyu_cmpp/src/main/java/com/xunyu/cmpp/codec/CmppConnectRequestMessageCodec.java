package com.xunyu.cmpp.codec;

import com.xunyu.cmpp.constant.GlobalConstance;
import com.xunyu.cmpp.message.CmppConnectRequestMessage;
import com.xunyu.cmpp.packet.CmppPacketType;
import com.xunyu.cmpp.packet.Message;
import com.xunyu.cmpp.packet.connect.CmppConnectRequest;
import com.xunyu.cmpp.utils.CMPPCommonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

/**
 * @author xym
 * @description 请求连接消息 编解码器
 * @date 2018/4/18 15:48
 */
public class CmppConnectRequestMessageCodec extends MessageToMessageCodec<Message,CmppConnectRequestMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CmppConnectRequestMessage msg, List<Object> list) throws Exception {
        ByteBuf bodyBuffer =  Unpooled.buffer(CmppConnectRequest.AUTHENTICATOR_SOURCE.getBodyLength());

        bodyBuffer.writeBytes(CMPPCommonUtil.ensureLength(msg.getSourceAddr().getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET),
                CmppConnectRequest.SOURCE_ADDR.getLength(), 0));
        bodyBuffer.writeBytes(CMPPCommonUtil.ensureLength(msg.getAuthenticatorSource(),CmppConnectRequest.AUTHENTICATOR_SOURCE.getLength(),0));
        bodyBuffer.writeByte(msg.getVersion());
        bodyBuffer.writeInt((int) msg.getTimestamp());

        msg.setBodyBuffer(bodyBuffer.array());
        msg.getHeader().setBodyLength(msg.getBodyBuffer().length);
        ReferenceCountUtil.release(bodyBuffer);
        list.add(msg);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Message msg, List<Object> list) throws Exception {
        long commandId = ((Long) msg.getHeader().getCommandId()).longValue();
        if (CmppPacketType.CMPP_CONNECT_REQUEST.getCommandId() != commandId)
        {
            //不解析，交给下一个codec
            list.add(msg);
            return;
        }
        CmppConnectRequestMessage requestMessage = new CmppConnectRequestMessage(msg.getHeader());

        ByteBuf bodyBuffer = Unpooled.wrappedBuffer(msg.getBodyBuffer());
        requestMessage.setSourceAddr(bodyBuffer.readBytes(CmppConnectRequest.SOURCE_ADDR.getLength()).toString(GlobalConstance.DEFAULT_TRANSPORT_CHARSET).trim());

        /**
         * 不可以用array()方法将ByteBuf转成byte[]
         */
        int length = CmppConnectRequest.AUTHENTICATOR_SOURCE.getLength();
        byte[] authenticatorSource = new byte[length];
        for (int i = 0 ; i < length ; i++){
            authenticatorSource[i] = bodyBuffer.getByte(bodyBuffer.readerIndex());
            bodyBuffer.readByte();
        }
        requestMessage.setAuthenticatorSource(authenticatorSource);

        requestMessage.setVersion(bodyBuffer.readUnsignedByte());
        requestMessage.setTimestamp(bodyBuffer.readUnsignedInt());

        ReferenceCountUtil.release(bodyBuffer);
        list.add(requestMessage);
    }
}
