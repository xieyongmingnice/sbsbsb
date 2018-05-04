package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 系统白名单 实体类
 * @date 2018/5/3 18:23
 */
public class SysWhitelist implements Serializable {

    private static final long serialVersionUID = 5153528238724192184L;
    /**
     *   主键
     */
    private Integer sysWhitelistId;

    /**
     *   手机号码
     */
    private String phoneNumber;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     * This method returns the value of the database column tbl_sys_whitelist.sys_whitelist_id
     *
     * @return the value of tbl_sys_whitelist.sys_whitelist_id
     */
    public Integer getSysWhitelistId() {
        return sysWhitelistId;
    }

    /**
     */
    public SysWhitelist withSysWhitelistId(Integer sysWhitelistId) {
        this.setSysWhitelistId(sysWhitelistId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist.sys_whitelist_id
     *
     * @param sysWhitelistId the value for tbl_sys_whitelist.sys_whitelist_id
     */
    public void setSysWhitelistId(Integer sysWhitelistId) {
        this.sysWhitelistId = sysWhitelistId;
    }

    /**
     * This method returns the value of the database column tbl_sys_whitelist.phone_number
     *
     * @return the value of tbl_sys_whitelist.phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     */
    public SysWhitelist withPhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist.phone_number
     *
     * @param phoneNumber the value for tbl_sys_whitelist.phone_number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the value of the database column tbl_sys_whitelist.join_time
     *
     * @return the value of tbl_sys_whitelist.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public SysWhitelist withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist.join_time
     *
     * @param joinTime the value for tbl_sys_whitelist.join_time
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method returns the value of the database column tbl_sys_whitelist.isabled
     *
     * @return the value of tbl_sys_whitelist.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public SysWhitelist withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist.isabled
     *
     * @param isabled the value for tbl_sys_whitelist.isabled
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
        sb.append(", sysWhitelistId=").append(sysWhitelistId);
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
        SysWhitelist other = (SysWhitelist) that;
        return (this.getSysWhitelistId() == null ? other.getSysWhitelistId() == null : this.getSysWhitelistId().equals(other.getSysWhitelistId()))
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
        result = prime * result + ((getSysWhitelistId() == null) ? 0 : getSysWhitelistId().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        return result;
    }
}