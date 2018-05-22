package com.xunyu.xunyu_smgp.message;

import com.xunyu.xunyu_smgp.head.Header;
import com.xunyu.xunyu_smgp.head.SmgpDefaultHeader;
import com.xunyu.xunyu_smgp.packet.PacketType;
import com.xunyu.xunyu_smgp.util.CachedMillisecondClock;
import com.xunyu.xunyu_smgp.util.DefaultSequenceNumberUtil;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @description 默认消息体
 * @date 2018/5/18 17:17
 */
public class SmgpDefaultMessage implements Message,Cloneable{

    private PacketType packetType;

    private long timestamp = CachedMillisecondClock.INS.now();

    /**
     * 消息的生命周期，单位秒, 0表示永不过期
     */
    private long lifeTime = 0;

    private AtomicInteger requests = new AtomicInteger();

    private Header header;

    private byte[] buffer;

    private Serializable attachment;

    public SmgpDefaultMessage() {
    };

    public SmgpDefaultMessage(PacketType packetType, Header header) {
        setPacketType(packetType);
        if (header == null) {
            header = new SmgpDefaultHeader();

            header.setSequenceId(DefaultSequenceNumberUtil.getSequenceNo());
        }
        header.setRequestId(packetType.getRequestId());
        setHeader(header);
    };

    public SmgpDefaultMessage(PacketType packetType) {
        this(packetType, DefaultSequenceNumberUtil.getSequenceNo());
    }

    public SmgpDefaultMessage(PacketType packetType, long sequenceId) {
        setPacketType(packetType);
        Header header = new SmgpDefaultHeader();
        header.setSequenceId(sequenceId);
        header.setRequestId(packetType.getRequestId());
        setHeader(header);
    }


    @Override
    public void setPacketType(PacketType packetType) {
        this.packetType = packetType;
    }
    @Override
    public PacketType getPacketType() {
        return packetType;
    }
    @Override
    public void setTimestamp(long milliseconds) {
        this.timestamp = milliseconds;
    }
    @Override
    public long getTimestamp() {
        return timestamp;
    }
    @Override
    public boolean isTerminationLife() {
        return lifeTime !=0 && (( timestamp + lifeTime*1000 ) - CachedMillisecondClock.INS.now() < 0L);
    }
    @Override
    public void setLifeTime(long lifeTime) {
        this.lifeTime = lifeTime;
    }

    @Override
    public long getLifeTime() {
        return lifeTime;
    }

    @Override
    public int incrementAndGetRequests() {
        return requests.incrementAndGet();
    }

    @Override
    public void resetRequests() {
        requests = new AtomicInteger();
    }

    @Override
    public void setHeader(Header header) {
        this.header = header;
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public void setBodyBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    @Override
    public byte[] getBodyBuffer() {
        return buffer;
    }

    @Override
    public Serializable getAttachment() {
        return attachment;
    }

    @Override
    public void setAttachment(Serializable attachment) {
        this.attachment = attachment;
    }

    @Override
    protected SmgpDefaultMessage clone() throws CloneNotSupportedException {
        SmgpDefaultMessage msg =  (SmgpDefaultMessage) super.clone();

        SmgpDefaultHeader newHeader = new SmgpDefaultHeader();
        newHeader.setSequenceId(header.getSequenceId());
        newHeader.setRequestId(packetType.getRequestId());
        msg.setHeader(newHeader);

        msg.resetRequests();
        msg.setTimestamp(CachedMillisecondClock.INS.now());
        return msg;
    }
}
