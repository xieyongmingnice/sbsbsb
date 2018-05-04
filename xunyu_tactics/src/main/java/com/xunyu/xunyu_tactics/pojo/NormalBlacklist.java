package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 普通黑名单 实体类
 * @date 2018/5/4 16:44
 */
public class NormalBlacklist implements Serializable {
    private static final long serialVersionUID = 8588882474776879083L;
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
     * This method returns the value of the database column tbl_normal_blacklist.normal_blacklist_id
     *
     * @return the value of tbl_normal_blacklist.normal_blacklist_id
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public Integer getNormalBlacklistId() {
        return normalBlacklistId;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public NormalBlacklist withNormalBlacklistId(Integer normalBlacklistId) {
        this.setNormalBlacklistId(normalBlacklistId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_blacklist.normal_blacklist_id
     *
     * @param normalBlacklistId the value for tbl_normal_blacklist.normal_blacklist_id
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public void setNormalBlacklistId(Integer normalBlacklistId) {
        this.normalBlacklistId = normalBlacklistId;
    }

    /**
     * This method returns the value of the database column tbl_normal_blacklist.phone_number
     *
     * @return the value of tbl_normal_blacklist.phone_number
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public NormalBlacklist withPhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_blacklist.phone_number
     *
     * @param phoneNumber the value for tbl_normal_blacklist.phone_number
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the value of the database column tbl_normal_blacklist.blacklist_source
     *
     * @return the value of tbl_normal_blacklist.blacklist_source
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public Integer getBlacklistSource() {
        return blacklistSource;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public NormalBlacklist withBlacklistSource(Integer blacklistSource) {
        this.setBlacklistSource(blacklistSource);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_blacklist.blacklist_source
     *
     * @param blacklistSource the value for tbl_normal_blacklist.blacklist_source
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public void setBlacklistSource(Integer blacklistSource) {
        this.blacklistSource = blacklistSource;
    }

    /**
     * This method returns the value of the database column tbl_normal_blacklist.remarks
     *
     * @return the value of tbl_normal_blacklist.remarks
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public NormalBlacklist withRemarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_blacklist.remarks
     *
     * @param remarks the value for tbl_normal_blacklist.remarks
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method returns the value of the database column tbl_normal_blacklist.isabled
     *
     * @return the value of tbl_normal_blacklist.isabled
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public NormalBlacklist withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_blacklist.isabled
     *
     * @param isabled the value for tbl_normal_blacklist.isabled
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_normal_blacklist.join_time
     *
     * @return the value of tbl_normal_blacklist.join_time
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public NormalBlacklist withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_normal_blacklist.join_time
     *
     * @param joinTime the value for tbl_normal_blacklist.join_time
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", normalBlacklistId=").append(normalBlacklistId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", blacklistSource=").append(blacklistSource);
        sb.append(", remarks=").append(remarks);
        sb.append(", isabled=").append(isabled);
        sb.append(", joinTime=").append(joinTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
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
        NormalBlacklist other = (NormalBlacklist) that;
        return (this.getNormalBlacklistId() == null ? other.getNormalBlacklistId() == null : this.getNormalBlacklistId().equals(other.getNormalBlacklistId()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getBlacklistSource() == null ? other.getBlacklistSource() == null : this.getBlacklistSource().equals(other.getBlacklistSource()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()));
    }

    /**
     *
     * @mbg.generated Fri May 04 16:41:15 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNormalBlacklistId() == null) ? 0 : getNormalBlacklistId().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getBlacklistSource() == null) ? 0 : getBlacklistSource().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        return result;
    }
}