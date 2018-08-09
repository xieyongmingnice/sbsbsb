package com.xunyu.cmpp.handler;

import com.google.common.primitives.Bytes;
import com.xunyu.cmpp.constant.GlobalConstance;
import com.xunyu.cmpp.constant.SessionState;
import com.xunyu.cmpp.message.CmppConnectRequestMessage;
import com.xunyu.cmpp.message.CmppConnectResponseMessage;
import com.xunyu.cmpp.packet.CmppPacketType;
import com.xunyu.cmpp.packet.PacketType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.MessageToMessageCodec;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xym
 * @description 服务端handler
 * @date 2018/4/18 14:40
 */
public class CmppServerChannelHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(CmppServerChannelHandler.class);

    private ConcurrentHashMap<Long, MessageToMessageCodec> codecMap = new ConcurrentHashMap<>();

    String username = "901782";

    String password = "ICP";

    /**
     * 连接状态
     **/
    private SessionState state = SessionState.DisConnect;

    private CmppServerChannelHandler(){
        for (PacketType packetType : CmppPacketType.values()) {
            codecMap.put(packetType.getCommandId(), packetType.getCodec());
        }
    }

    private static class CmppServerChannelHandlerHolder{
        private final static CmppServerChannelHandler instance = new CmppServerChannelHandler();
    }

    public static CmppServerChannelHandler getInstance(){
        return CmppServerChannelHandlerHolder.instance;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 第一次接收到的信息应该是客户端传来的连接请求
         */
        logger.info("有客户端连接+{}",ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("read read read ");
        if (state == SessionState.DisConnect) {
            if (msg instanceof CmppConnectRequestMessage) {
                CmppConnectRequestMessage message = (CmppConnectRequestMessage) msg;
                byte[] userBytes = username.getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
                byte[] passwdBytes = password.getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);

                byte[] timestampBytes = String.format("%010d", message.getTimestamp()).getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
                byte[] authBytes = DigestUtils.md5(Bytes.concat(userBytes, new byte[9], passwdBytes, timestampBytes));

                if (Arrays.equals(authBytes, message.getAuthenticatorSource())) {
                    logger.info("connect success");
                    state = SessionState.Connect;
                    ctx.channel().attr(GlobalConstance.ATTRIBUTE_KEY).set(SessionState.Connect);
                    //发送response消息给客户端
                    CmppConnectResponseMessage responseMessage = new CmppConnectResponseMessage( message.getHeader().getSequenceId());
                    responseMessage.setStatus(0);
                    responseMessage.setVersion((short) 0X30);
                    ctx.channel().writeAndFlush("qqqqqq");
                } else {
                    logger.error("connect failed");
                }

            } else {
                logger.error("channel Not Connnected, Request must be CmppConnectResponseMessage,but is {}", msg.getClass().getName());
                ctx.close();
                return;
            }
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("read complete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("有异常出现，原因：{}",cause.getMessage());
        cause.printStackTrace();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("有客户端失去连接...");
    }
}
