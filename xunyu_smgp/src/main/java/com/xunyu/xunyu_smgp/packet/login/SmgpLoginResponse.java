package com.xunyu.xunyu_smgp.packet.login;

import com.xunyu.xunyu_smgp.packet.PacketStructure;
import com.xunyu.xunyu_smgp.packet.SmgpDataType;

public enum SmgpLoginResponse implements PacketStructure {

    STATUS(SmgpDataType.INTEGER,true,4),

    AUTHENTICATOR_SERVER(SmgpDataType.OCTET_STRING,true,16),

    SERVER_VERSION(SmgpDataType.INTEGER,true,1)
    ;

    private SmgpDataType dataType;

    private boolean isFixedLength;

    private int length;

    private static final int bodyLength = STATUS.length + AUTHENTICATOR_SERVER.length + SERVER_VERSION.length;

    SmgpLoginResponse(SmgpDataType dataType,boolean isFixedLength,int length){

    }

    @Override
    public SmgpDataType getDataType() {
        return dataType;
    }

    @Override
    public boolean isFixFiledLength() {
        return isFixedLength;
    }

    @Override
    public boolean isFixPacketLength() {
        return true;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getBodyLength() {
        return bodyLength;
    }
}
