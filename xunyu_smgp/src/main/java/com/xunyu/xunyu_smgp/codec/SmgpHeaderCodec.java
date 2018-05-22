package com.xunyu.xunyu_smgp.codec;


import com.xunyu.xunyu_smgp.constant.GlobalConstance;
import com.xunyu.xunyu_smgp.head.Header;
import com.xunyu.xunyu_smgp.head.SmgpDefaultHeader;
import com.xunyu.xunyu_smgp.head.SmgpMessageHeader;
import com.xunyu.xunyu_smgp.message.Message;
import com.xunyu.xunyu_smgp.message.SmgpDefaultMessage;
import com.xunyu.xunyu_smgp.packet.PacketType;
import com.xunyu.xunyu_smgp.packet.SmgpPacketType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xym
 * @description cmpp消息头编解码器
 * @date 2018/4/19 9:55
 */
public class SmgpHeaderCodec extends MessageToMessageCodec<ByteBuf, Message> {
	private final Logger logger = LoggerFactory.getLogger(SmgpHeaderCodec.class);

	private ConcurrentHashMap<Long, MessageToMessageCodec> codecMap = new ConcurrentHashMap<>();

	private SmgpHeaderCodec(){
		for (PacketType packetType : SmgpPacketType.values()) {
			codecMap.put(packetType.getRequestId(), packetType.getCodec());
		}
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf bytebuf, List<Object> list) throws Exception {
		//此时已处理过粘包和断包了，bytebuf里是完整的一帧
		Header header = new SmgpDefaultHeader();
		header.setPacketLength(bytebuf.readUnsignedInt());
		long requestId = bytebuf.readUnsignedInt();
		header.setRequestId(requestId);
		header.setSequenceId(bytebuf.readUnsignedInt());
		header.setHeaderLength(SmgpMessageHeader.REQUEST_ID.getHeaderLength());
		header.setBodyLength(header.getPacketLength() - header.getHeaderLength());

		Message message = new SmgpDefaultMessage();
		if (header.getBodyLength() > 0) {
			message.setBodyBuffer(new byte[(int)header.getBodyLength()]);
			
			assert(header.getBodyLength() == bytebuf.readableBytes());
			
			bytebuf.readBytes(message.getBodyBuffer());
		} else {
			message.setBodyBuffer(GlobalConstance.EMPTY_BYTES);
		}
		message.setHeader(header);
		ctx.channel().pipeline().addLast(codecMap.get(requestId));
		list.add(message);
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, List<Object> list) throws Exception {

		int headerLength = SmgpMessageHeader.REQUEST_ID.getHeaderLength();
		int packetLength = message.getBodyBuffer().length + headerLength;

		// buf由netty写channel的时候释放
		ByteBuf buf = ctx.alloc().buffer(packetLength);
		buf.writeInt(packetLength);
		buf.writeInt((int) message.getHeader().getRequestId());
		buf.writeInt((int) message.getHeader().getSequenceId());
		if (packetLength > headerLength) {
			buf.writeBytes(message.getBodyBuffer());
		}
		list.add(buf);

	}

}
