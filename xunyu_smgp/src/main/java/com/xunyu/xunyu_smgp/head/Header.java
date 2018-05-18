package com.xunyu.xunyu_smgp.head;

import java.io.Serializable;

/**
 * @author
 * @description
 * @date 2018/5/18 13:59
 */
public interface Header extends Serializable{

    /**
     *
     * @param length 消息头长度
     */
    void setHeaderLength(long length);

    /**
     *
     * @return 消息头长度
     */
    long getHeaderLength();

    /**
     *
     * @param length 数据包长度
     */
    void setPacketLength(long length);

    /**
     *
     * @return 数据包长度
     */
    long getPacketLength();

    /**
     *
     * @param length 消息体长度
     */
    void setBodyLength(long length);

    /**
     *
     * @return 消息体长度
     */
    long getBodyLength();
    /**
     *
     * @param requestId 请求标识
     */
    void setRequestId(long requestId);
    /**
     *
     * @return 请求标识
     */
    long getRequestId();
    /**
     *
     * @param sequenceId 流水号
     */
    void setSequenceId(long sequenceId);
    /**
     *
     * @return 流水号
     */
    long getSequenceId();
}
