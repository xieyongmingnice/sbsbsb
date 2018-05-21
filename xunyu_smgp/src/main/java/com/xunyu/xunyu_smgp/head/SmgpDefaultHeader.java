package com.xunyu.xunyu_smgp.head;

/**
 * @author xym
 * @description 默认消息头实体
 * @date 2018/5/18 14:07
 */
public class SmgpDefaultHeader implements Header {


    private static final long serialVersionUID = -7462861654045437749L;

    private long headerLength;

    private long packetLength;

    private long bodyLength;

    private long requestId;

    private long sequenceId;

    @Override
    public void setHeaderLength(long length) {
        this.headerLength = length;
    }

    @Override
    public long getHeaderLength() {
        return headerLength;
    }

    @Override
    public void setPacketLength(long length) {
        this.packetLength = length;
    }

    @Override
    public long getPacketLength() {
        return packetLength;
    }

    @Override
    public void setBodyLength(long length) {
        this.bodyLength = length;
    }

    @Override
    public long getBodyLength() {
        return bodyLength;
    }

    @Override
    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    @Override
    public long getRequestId() {
        return requestId;
    }

    @Override
    public void setSequenceId(long sequenceId) {
        this.sequenceId = sequenceId & 0xffffffffL;
    }

    @Override
    public long getSequenceId() {
        return sequenceId;
    }

    @Override
    public String toString() {
        return "SmgpDefaultHeader{" +
                "requestId=" + requestId +
                ", sequenceId=" + sequenceId +
                '}';
    }
}
