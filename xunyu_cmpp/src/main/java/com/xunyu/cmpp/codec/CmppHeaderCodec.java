package com.xunyu.cmpp.codec;


import com.xunyu.cmpp.constant.GlobalConstance;
import com.xunyu.cmpp.packet.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author xym
 * @description cmpp消息头编解码器
 * @date 2018/4/19 9:55
 */
public class CmppHeaderCodec extends MessageToMessageCodec<ByteBuf, Message> {
	private final Logger logger = LoggerFactory.getLogger(CmppHeaderCodec.class);

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf bytebuf, List<Object> list) throws Exception {
		//此时已处理过粘包和断包了，bytebuf里是完整的一帧
		Header header = new DefaultHeader();
		header.setPacketLength(bytebuf.readUnsignedInt());
		header.setCommandId(bytebuf.readUnsignedInt());
		header.setSequenceId(bytebuf.readUnsignedInt());
		header.setHeadLength(CmppMessageHeader.COMMAND_ID.getHeaderLength());
		header.setBodyLength(header.getPacketLength() - header.getHeadLength());

		Message message = new DefaultMessage();
		if (header.getBodyLength() > 0) {
			message.setBodyBuffer(new byte[(int)header.getBodyLength()]);
			
			assert(header.getBodyLength() == bytebuf.readableBytes());
			
			bytebuf.readBytes(message.getBodyBuffer());
		} else {
			message.setBodyBuffer(GlobalConstance.EMPTY_BYTES);
		}
		message.setHeader(header);
		list.add(message);
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, List<Object> list) throws Exception {

		int headerLength = CmppMessageHeader.COMMAND_ID.getHeaderLength();
		int packetLength = message.getBodyBuffer().length + headerLength;

		// buf由netty写channel的时候释放
		ByteBuf buf = ctx.alloc().buffer(packetLength);
		buf.writeInt(packetLength);
		buf.writeInt((int) message.getHeader().getCommandId());
		buf.writeInt((int) message.getHeader().getSequenceId());
		if (packetLength > headerLength) {
			buf.writeBytes(message.getBodyBuffer());
		}
		list.add(buf);

	}

}
