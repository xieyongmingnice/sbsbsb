package com.xunyu.operator.vo.out;

import java.io.Serializable;

public class OperAccessCoreConfigVO implements Serializable{
    private static final long serialVersionUID = -5624137097579809611L;
    /**
     * 主键
     */
    private Long configId;
    /**
     * 自定义通道名称
     */
    private String channelName;
    /**
     * 协议类型  1、移动、2联通、3电信
     */
    private int agreeType;
    /**
     * 接入码
     */
    private String accessCode;
    /**
     * 扩展位数
     */
    private int extendNum;

    /**
     * 是否启用
     */
    private Integer isable ;

    /**
     * 自定义字符串
     */
    private String nameStr;


    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }



    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public int getAgreeType() {
        return agreeType;
    }

    public void setAgreeType(int agreeType) {
        this.agreeType = agreeType;
    }

    public int getExtendNum() {
        return extendNum;
    }

    public void setExtendNum(int extendNum) {
        this.extendNum = extendNum;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public Integer getIsable() {
        return isable;
    }

    public void setIsable(Integer isable) {
        this.isable = isable;
    }
}
