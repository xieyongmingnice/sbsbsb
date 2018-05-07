package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 普通白名单 实体类
 * @date 2018/5/7 13:41
 */
public class NormalWhitelist implements Serializable {

    private static final long serialVersionUID = 7098634837363529576L;

    /**
     *   主键
     *
     */
    private Integer normalWhitelistId;

    /**
     *   手机号
     *
     */
    private String phoneNumber;

    /**
     *   加入时间
     *
     */
    private Date joinTime;

    /**
     *   1：可用，0：不可用
     *
     */
    private Integer isabled;

    /**
     * This method returns the value of the database column tbl_normal_whitelist.normal_whitelist_id
     *
     * @return the value of tbl_normal_whitelist.normal_whitelist_id
     */
    public Integer getNormalWhitelistId() {
        return normalWhitelistId;
    }

    /**
     */
    public NormalWhitelist withNormalWhitelistId(Integer normalWhitelistId) {
        this.setNormalWhitelistId(normalWhitelistId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_whitelist.normal_whitelist_id
     *
     * @param normalWhitelistId the value for tbl_normal_whitelist.normal_whitelist_id
     */
    public void setNormalWhitelistId(Integer normalWhitelistId) {
        this.normalWhitelistId = normalWhitelistId;
    }

    /**
     * This method returns the value of the database column tbl_normal_whitelist.phone_number
     *
     * @return the value of tbl_normal_whitelist.phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     */
    public NormalWhitelist withPhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_whitelist.phone_number
     *
     * @param phoneNumber the value for tbl_normal_whitelist.phone_number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the value of the database column tbl_normal_whitelist.join_time
     *
     * @return the value of tbl_normal_whitelist.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public NormalWhitelist withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_whitelist.join_time
     *
     * @param joinTime the value for tbl_normal_whitelist.join_time
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method returns the value of the database column tbl_normal_whitelist.isabled
     *
     * @return the value of tbl_normal_whitelist.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public NormalWhitelist withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_whitelist.isabled
     *
     * @param isabled the value for tbl_normal_whitelist.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", normalWhitelistId=").append(normalWhitelistId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", joinTime=").append(joinTime);
        sb.append(", isabled=").append(isabled);
        sb.append("]");
        return sb.toString();
    }

    /**
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NormalWhitelist other = (NormalWhitelist) that;
        return (this.getNormalWhitelistId() == null ? other.getNormalWhitelistId() == null : this.getNormalWhitelistId().equals(other.getNormalWhitelistId()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNormalWhitelistId() == null) ? 0 : getNormalWhitelistId().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        return result;
    }
}