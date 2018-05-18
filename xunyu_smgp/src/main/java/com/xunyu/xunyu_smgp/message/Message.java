package com.xunyu.xunyu_smgp.message;

import com.xunyu.xunyu_smgp.head.Header;
import com.xunyu.xunyu_smgp.packet.PacketType;

import java.io.Serializable;

public interface Message extends Serializable{

    void setPacketType(PacketType packetType);

    PacketType getPacketType();

    void setTimestamp(long milliseconds);

    long getTimestamp();

    boolean isTerminationLife();

    void setLifeTime(long lifeTime);

    long getLifeTime();

    int incrementAndGetRequests();

    void resetRequests();

    void setHeader(Header head);

    Header getHeader();

    void setBodyBuffer(byte[] buffer);

    byte[] getBodyBuffer();

    Serializable getAttachment();

    void setAttachment(Serializable attachment);
}
