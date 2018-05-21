package com.xunyu.xunyu_smgp.packet;

import com.xunyu.xunyu_smgp.codec.SmgpLoginCodec;
import com.xunyu.xunyu_smgp.codec.SmgpLoginResponseCodec;
import com.xunyu.xunyu_smgp.packet.login.SmgpLoginRequest;
import com.xunyu.xunyu_smgp.packet.login.SmgpLoginResponse;
import io.netty.handler.codec.MessageToMessageCodec;

public enum SmgpPacketType implements PacketType {

    /**
     * 客户端登录
     */
    LOGIN(0x00000001, SmgpLoginRequest.class, SmgpLoginCodec.class),

    /**
     * 客户端登录应答
     */
    LOGIN_RESPONSE(0x80000001, SmgpLoginResponse.class, SmgpLoginResponseCodec.class)
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

    @Override
    public long getRequestId() {
        return requestId;
    }

    @Override
    public PacketStructure[] getPacketStructures() {
        return packetStructure.getEnumConstants();
    }

    @Override
    public long getAllCommandId() {
        long defaultId = 0x0;
        long allCommandId = 0x0;
        for(SmgpPacketType packetType : SmgpPacketType.values()) {
            allCommandId |= packetType.requestId;
        }
        return allCommandId ^ defaultId;
    }

    @Override
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
