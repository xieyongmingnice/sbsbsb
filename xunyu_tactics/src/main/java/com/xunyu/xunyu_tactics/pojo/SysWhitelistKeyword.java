package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description  系统白名单关键字 实体类
 * @date 2018/5/8 15:11
 */
public class SysWhitelistKeyword implements Serializable {
    private static final long serialVersionUID = 140519015756485205L;
    /**
     *   主键
     */
    private Integer sysWhitelistKeywordId;

    /**
     *   系统白名单关键字
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
     * This method returns the value of the database column tbl_sys_whitelist_keyword.sys_whitelist_keyword_id
     *
     * @return the value of tbl_sys_whitelist_keyword.sys_whitelist_keyword_id
     */
    public Integer getSysWhitelistKeywordId() {
        return sysWhitelistKeywordId;
    }

    /**
     */
    public SysWhitelistKeyword withSysWhitelistKeywordId(Integer sysWhitelistKeywordId) {
        this.setSysWhitelistKeywordId(sysWhitelistKeywordId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist_keyword.sys_whitelist_keyword_id
     *
     * @param sysWhitelistKeywordId the value for tbl_sys_whitelist_keyword.sys_whitelist_keyword_id
     */
    public void setSysWhitelistKeywordId(Integer sysWhitelistKeywordId) {
        this.sysWhitelistKeywordId = sysWhitelistKeywordId;
    }

    /**
     * This method returns the value of the database column tbl_sys_whitelist_keyword.keyword
     *
     * @return the value of tbl_sys_whitelist_keyword.keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     */
    public SysWhitelistKeyword withKeyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist_keyword.keyword
     *
     * @param keyword the value for tbl_sys_whitelist_keyword.keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * This method returns the value of the database column tbl_sys_whitelist_keyword.isabled
     *
     * @return the value of tbl_sys_whitelist_keyword.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public SysWhitelistKeyword withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist_keyword.isabled
     *
     * @param isabled the value for tbl_sys_whitelist_keyword.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_sys_whitelist_keyword.join_time
     *
     * @return the value of tbl_sys_whitelist_keyword.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public SysWhitelistKeyword withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_whitelist_keyword.join_time
     *
     * @param joinTime the value for tbl_sys_whitelist_keyword.join_time
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
        sb.append(", sysWhitelistKeywordId=").append(sysWhitelistKeywordId);
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
        SysWhitelistKeyword other = (SysWhitelistKeyword) that;
        return (this.getSysWhitelistKeywordId() == null ? other.getSysWhitelistKeywordId() == null : this.getSysWhitelistKeywordId().equals(other.getSysWhitelistKeywordId()))
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
        result = prime * result + ((getSysWhitelistKeywordId() == null) ? 0 : getSysWhitelistKeywordId().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        return result;
    }
}