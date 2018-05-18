package com.xunyu.xunyu_smgp.packet;

/**
 * @author
 * @description 包结构
 * @date 2018/5/18 14:42
 */
public interface PacketStructure {
    /**
     *
     * @return 获得数据类型
     */
    SmgpDataType getDataType();

    /**
     *
     * @return 文件长度是否固定
     */
    boolean isFixFiledLength();

    /**
     *
     * @return 数据包长度是否固定
     */
    boolean isFixPacketLength();

    /**
     *
     * @return 获得数据包长度
     */
    int getLength();

    /**
     *
     * @return 获得消息体长度
     */
    int getBodyLength();
}
