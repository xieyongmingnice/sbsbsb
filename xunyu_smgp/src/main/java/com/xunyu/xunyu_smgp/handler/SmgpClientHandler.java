package com.xunyu.xunyu_smgp.handler;

import com.google.common.primitives.Bytes;
import com.xunyu.xunyu_smgp.constant.GlobalConstance;
import com.xunyu.xunyu_smgp.message.SmgpLoginRequestMessage;
import com.xunyu.xunyu_smgp.util.CachedMillisecondClock;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xym
 * @description 客户端handler
 * @date 2018/5/21 14:58
 */
public class SmgpClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SmgpClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 客户端先请求连接服务器
         */
        String clientId = "888888";
        String sharedSecret = "ICP";
        //TODO 提供请求连接信息
        SmgpLoginRequestMessage msg = new SmgpLoginRequestMessage();
        String timestamp = DateFormatUtils.format(CachedMillisecondClock.INS.now(), "MMddHHmmss");
        byte[] userBytes = clientId.getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
        byte[] sharedSecretBytes = sharedSecret.getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
        byte[] timestampBytes = timestamp.getBytes(GlobalConstance.DEFAULT_TRANSPORT_CHARSET);
        msg.setAuthenticatorClient(String.valueOf(DigestUtils.md5(Bytes.concat(userBytes, new byte[7], sharedSecretBytes, timestampBytes))));
        msg.setClientId(clientId);
        msg.setTimestamp(Long.parseLong(timestamp));
        msg.setClientVersion(0X30);
        ctx.writeAndFlush(msg);

        logger.info("send SmgpLoginRequestMessage");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
