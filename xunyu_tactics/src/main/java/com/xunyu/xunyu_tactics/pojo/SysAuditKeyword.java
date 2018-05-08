package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @description
 * @date 2018/5/8 17:41
 */
public class SysAuditKeyword implements Serializable {

    private static final long serialVersionUID = 7243639552977372376L;


    /**
     *   主键
     */
    private Integer sysAuditKeywordId;

    /**
     *   系统审核关键字
     */
    private String keyword;

    /**
     *   1：可用，0：不可用
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private Date joinTime;



    /**
     * This method returns the value of the database column tbl_sys_audit_keyword.sys_audit_keyword_id
     *
     * @return the value of tbl_sys_audit_keyword.sys_audit_keyword_id
     */
    public Integer getSysAuditKeywordId() {
        return sysAuditKeywordId;
    }

    /**
     */
    public SysAuditKeyword withSysAuditKeywordId(Integer sysAuditKeywordId) {
        this.setSysAuditKeywordId(sysAuditKeywordId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_audit_keyword.sys_audit_keyword_id
     *
     * @param sysAuditKeywordId the value for tbl_sys_audit_keyword.sys_audit_keyword_id
     */
    public void setSysAuditKeywordId(Integer sysAuditKeywordId) {
        this.sysAuditKeywordId = sysAuditKeywordId;
    }

    /**
     * This method returns the value of the database column tbl_sys_audit_keyword.keyword
     *
     * @return the value of tbl_sys_audit_keyword.keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     */
    public SysAuditKeyword withKeyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_audit_keyword.keyword
     *
     * @param keyword the value for tbl_sys_audit_keyword.keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * This method returns the value of the database column tbl_sys_audit_keyword.isabled
     *
     * @return the value of tbl_sys_audit_keyword.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public SysAuditKeyword withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_audit_keyword.isabled
     *
     * @param isabled the value for tbl_sys_audit_keyword.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_sys_audit_keyword.join_time
     *
     * @return the value of tbl_sys_audit_keyword.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public SysAuditKeyword withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_audit_keyword.join_time
     *
     * @param joinTime the value for tbl_sys_audit_keyword.join_time
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysAuditKeywordId=").append(sysAuditKeywordId);
        sb.append(", keyword=").append(keyword);
        sb.append(", isabled=").append(isabled);
        sb.append(", joinTime=").append(joinTime);
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
        SysAuditKeyword other = (SysAuditKeyword) that;
        return (this.getSysAuditKeywordId() == null ? other.getSysAuditKeywordId() == null : this.getSysAuditKeywordId().equals(other.getSysAuditKeywordId()))
            && (this.getKeyword() == null ? other.getKeyword() == null : this.getKeyword().equals(other.getKeyword()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSysAuditKeywordId() == null) ? 0 : getSysAuditKeywordId().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        return result;
    }
}