package com.xunyu.xunyu_smgp.packet;

import io.netty.handler.codec.MessageToMessageCodec;

public enum SmgpPacketType implements PacketType {

    /**
     * 客户端登录
     */
    LOGIN(0x00000001,null,null),

    /**
     * 客户端登录应答
     */
    LOGIN_RESPONSE(0x80000001,null,null)
    //TODO 待补充
    ;

    private long requestId;

    private Class<? extends PacketStructure> packetStructure;

    private Class<? extends MessageToMessageCodec> codec;


    SmgpPacketType(long requestId, Class<? extends PacketStructure> packetStructure, Class<? extends MessageToMessageCodec> codec) {
        this.requestId = requestId;
        this.packetStructure = packetStructure;
        this.codec = codec;
    }

    public long getRequestId() {
        return requestId;
    }

    public PacketStructure[] getPacketStructures() {
        return packetStructure.getEnumConstants();
    }

    public long getAllCommandId() {
        long defaultId = 0x0;
        long allCommandId = 0x0;
        for(SmgpPacketType packetType : SmgpPacketType.values()) {
            allCommandId |= packetType.requestId;
        }
        return allCommandId ^ defaultId;
    }

    public MessageToMessageCodec getCodec() {
        try {
            return codec.newInstance();
        } catch (InstantiationException e) {
            return null;
        }
        catch(  IllegalAccessException e){
            return null;
        }
    }
}
