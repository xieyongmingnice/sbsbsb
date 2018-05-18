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

    public void setHeaderLength(long length) {
        this.headerLength = length;
    }

    public long getHeaderLength() {
        return headerLength;
    }

    public void setPacketLength(long length) {
        this.packetLength = length;
    }

    public long getPacketLength() {
        return packetLength;
    }

    public void setBodyLength(long length) {
        this.bodyLength = length;
    }

    public long getBodyLength() {
        return bodyLength;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setSequenceId(long sequenceId) {
        this.sequenceId = sequenceId & 0xffffffffL;
    }

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
