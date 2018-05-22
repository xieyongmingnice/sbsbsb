package com.xunyu.xunyu_smgp.codec;

import com.xunyu.xunyu_smgp.constant.GlobalConstance;
import com.xunyu.xunyu_smgp.message.Message;
import com.xunyu.xunyu_smgp.message.SmgpLoginRequestMessage;
import com.xunyu.xunyu_smgp.packet.SmgpPacketType;
import com.xunyu.xunyu_smgp.packet.login.SmgpLoginRequest;
import com.xunyu.xunyu_smgp.util.CommonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

/**
 * @author 
 * @description 
 * @date 2018/5/21 16:46
 */
public class SmgpLoginCodec extends MessageToMessageCodec<Message,SmgpLoginRequestMessage>{

    @Override
    protected void encode(ChannelHandlerContext ctx, SmgpLoginRequestMessage msg, List<Object> list) throws Exception {
        ByteBuf bodyBuffer =  Unpooled.buffer(SmgpLoginRequest.AUTHENTICATOR_CLIENT.getBodyLength());

        bodyBuffer.writeBytes(CommonUtil.ensureLength(msg.getClientId().getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET),
                SmgpLoginRequest.CLIENT_ID.getLength(), 0));
        bodyBuffer.writeBytes(CommonUtil.ensureLength(msg.getAuthenticatorClient().getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET),SmgpLoginRequest.AUTHENTICATOR_CLIENT.getLength(),0));
        bodyBuffer.writeByte(msg.getClientVersion());
        bodyBuffer.writeInt((int) msg.getTimestamp());

        msg.setBodyBuffer(bodyBuffer.array());
        msg.getHeader().setBodyLength(msg.getBodyBuffer().length);
        ReferenceCountUtil.release(bodyBuffer);
        list.add(msg);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, Message msg, List<Object> list) throws Exception {
        long requestId = ((Long) msg.getHeader().getRequestId()).longValue();
        if (SmgpPacketType.LOGIN.getRequestId() != requestId)
        {
            //不解析，交给下一个codec
            list.add(msg);
            return;
        }
        SmgpLoginRequestMessage requestMessage = new SmgpLoginRequestMessage(msg.getHeader());

        ByteBuf bodyBuffer = Unpooled.wrappedBuffer(msg.getBodyBuffer());
        requestMessage.setAuthenticatorClient(bodyBuffer.readBytes(SmgpLoginRequest.CLIENT_ID.getLength()).toString(GlobalConstance.DEFAULT_TRANSPORT_CHARSET).trim());

        int length = SmgpLoginRequest.AUTHENTICATOR_CLIENT.getLength();
        byte[] authenticatorClient = new byte[length];
        for (int i = 0 ; i < length ; i++){
            authenticatorClient[i] = bodyBuffer.getByte(bodyBuffer.readerIndex());
            bodyBuffer.readByte();
        }
        requestMessage.setAuthenticatorClient(String.valueOf(authenticatorClient));

        requestMessage.setClientVersion((int)bodyBuffer.readUnsignedByte());
        requestMessage.setTimestamp(bodyBuffer.readUnsignedInt());

        ReferenceCountUtil.release(bodyBuffer);
        list.add(requestMessage);
    }
}
