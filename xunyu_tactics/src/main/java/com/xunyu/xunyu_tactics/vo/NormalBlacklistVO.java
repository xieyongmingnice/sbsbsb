package com.xunyu.xunyu_tactics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 黑名单vo类
 * @date 2018/5/4 16:58
 */
public class NormalBlacklistVO implements Serializable{
    private static final long serialVersionUID = -5069636474804785897L;

    /**
     *   主键
     */
    private Integer normalBlacklistId;

    /**
     *   手机号码
     */
    private String phoneNumber;

    /**
     *   黑名单来源 1:回复加黑，2:手动加黑，3:其他搜集
     */
    private Integer blacklistSource;

    /**
     *   备注
     */
    private String remarks;

    /**
     *   可用状态标签
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   黑名单来源 （字符）
     */
    private String blacklistSourceStr;

    public Integer getNormalBlacklistId() {
        return normalBlacklistId;
    }

    public void setNormalBlacklistId(Integer normalBlacklistId) {
        this.normalBlacklistId = normalBlacklistId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBlacklistSource() {
        return blacklistSource;
    }

    public void setBlacklistSource(Integer blacklistSource) {
        this.blacklistSource = blacklistSource;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getBlacklistSourceStr() {
        return blacklistSourceStr;
    }

    public void setBlacklistSourceStr(String blacklistSourceStr) {
        this.blacklistSourceStr = blacklistSourceStr;
    }
}
