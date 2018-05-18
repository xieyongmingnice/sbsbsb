package com.xunyu.xunyu_smgp.packet;

import io.netty.handler.codec.MessageToMessageCodec;

public interface PacketType {

    long getRequestId();

    PacketStructure[] getPacketStructures();

    long getAllCommandId();

    MessageToMessageCodec getCodec();
}
