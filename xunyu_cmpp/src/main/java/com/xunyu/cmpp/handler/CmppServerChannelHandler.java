package com.xunyu.cmpp.handler;

import com.google.common.primitives.Bytes;
import com.xunyu.cmpp.constant.GlobalConstance;
import com.xunyu.cmpp.constant.SessionState;
import com.xunyu.cmpp.message.CmppConnectRequestMessage;
import com.xunyu.cmpp.packet.CmppPacketType;
import com.xunyu.cmpp.packet.Message;
import com.xunyu.cmpp.packet.PacketType;
import com.xunyu.cmpp.utils.CachedMillisecondClock;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToMessageCodec;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xym
 * @description 服务端handler
 * @date 2018/4/18 14:40
 */
@ChannelHandler.Sharable
public class CmppServerChannelHandler extends ChannelHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(CmppServerChannelHandler.class);

    private ConcurrentHashMap<Long, MessageToMessageCodec> codecMap = new ConcurrentHashMap<Long, MessageToMessageCodec>();

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
        if (state == SessionState.DisConnect){
//            CmppConnectRequestMessage req = new CmppConnectRequestMessage();
//            req.setSourceAddr(cliententity.getUserName());
//            String timestamp = DateFormatUtils.format(CachedMillisecondClock.INS.now(), "MMddHHmmss");
//            req.setTimestamp(Long.parseLong(timestamp));
//            byte[] userBytes = cliententity.getUserName().getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
//            byte[] passwdBytes = cliententity.getPassword().getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
//            byte[] timestampBytes = timestamp.getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
//            req.setAuthenticatorSource(DigestUtils.md5(Bytes.concat(userBytes, new byte[9], passwdBytes, timestampBytes)));
//
//            ctx.channel().writeAndFlush(req);
//            logger.info("session Start :Send CmppConnectRequestMessage seq :{}", req.getHeader().getSequenceId());
        }
        logger.info("有客户端连接+{}",ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        long commandId = ((Message)msg).getHeader().getCommandId();
        MessageToMessageCodec codec = codecMap.get(commandId);
        codec.channelRead(ctx,msg);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        long commandId = ((Message)msg).getHeader().getCommandId();
        MessageToMessageCodec codec = codecMap.get(commandId);
        codec.write(ctx, msg, promise);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("有异常出现，原因：{}",cause.getMessage());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("有客户端失去连接...");
    }
}
