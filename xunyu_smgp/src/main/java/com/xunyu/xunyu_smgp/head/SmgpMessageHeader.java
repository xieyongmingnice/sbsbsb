package com.xunyu.xunyu_smgp.head;

import com.xunyu.xunyu_smgp.packet.SmgpDataType;

/**
 * @author xym
 * @description 消息头格式
 * @date 2018/5/18 14:07
 */
public enum SmgpMessageHeader {

    /**
     * 数据包长度
     */
    PACKET_LENGTH(SmgpDataType.INTEGER,4),

    /**
     * 请求标识
     */
    REQUEST_ID(SmgpDataType.INTEGER,4),

    /**
     * 消息流水号
     */
    SEQUENCE_ID(SmgpDataType.INTEGER,4)
    ;

    SmgpMessageHeader(SmgpDataType dataType,int length){
        this.dataType = dataType;
        this.length = length;
    }

    /**
     * 数据类型
     */
    private SmgpDataType dataType;

    /**
     * 字段长度
     */
    private int length;


    public SmgpDataType getDataType() {
        return dataType;
    }

    public int getLength() {
        return length;
    }

    public int getHeaderLength(){
        return 12;
    }
}
