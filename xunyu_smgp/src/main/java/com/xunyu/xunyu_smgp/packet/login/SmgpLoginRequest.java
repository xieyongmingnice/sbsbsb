package com.xunyu.xunyu_smgp.packet.login;

import com.xunyu.xunyu_smgp.packet.PacketStructure;
import com.xunyu.xunyu_smgp.packet.SmgpDataType;

public enum SmgpLoginRequest implements PacketStructure {

    CLIENT_ID(SmgpDataType.OCTET_STRING,true,8),

    AUTHENTICATOR_CLIENT(SmgpDataType.OCTET_STRING,true,16),

    LOGIN_MODE(SmgpDataType.INTEGER,true,1),

    TIME_STAMP(SmgpDataType.INTEGER,true,4),

    CLIENT_VERSION(SmgpDataType.INTEGER,true,1)
    ;
    private SmgpDataType dataType;

    private boolean isFixedLength;

    private int length;

    private static final int bodyLength = CLIENT_ID.length + AUTHENTICATOR_CLIENT.length + LOGIN_MODE.length + TIME_STAMP.length + CLIENT_VERSION.length;

    SmgpLoginRequest(SmgpDataType dataType,boolean isFixedLength,int length){
        this.dataType = dataType;
        this.isFixedLength = isFixedLength;
        this.length = length;
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
        return isFixPacketLength();
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
