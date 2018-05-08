package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 系统拦截关键词 实体类
 * @date 2018/5/7 17:45
 */
public class SysInterceptKeyword implements Serializable {
    /**
     *   主键
     */
    private Integer sysInterceptKeywordId;

    /**
     *   系统拦截关键字
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
     * This method returns the value of the database column tbl_sys_intercept_keyword.sys_intercept_keyword_id
     *
     * @return the value of tbl_sys_intercept_keyword.sys_intercept_keyword_id
     */
    public Integer getSysInterceptKeywordId() {
        return sysInterceptKeywordId;
    }

    /**
     */
    public SysInterceptKeyword withSysInterceptKeywordId(Integer sysInterceptKeywordId) {
        this.setSysInterceptKeywordId(sysInterceptKeywordId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_intercept_keyword.sys_intercept_keyword_id
     *
     * @param sysInterceptKeywordId the value for tbl_sys_intercept_keyword.sys_intercept_keyword_id
     */
    public void setSysInterceptKeywordId(Integer sysInterceptKeywordId) {
        this.sysInterceptKeywordId = sysInterceptKeywordId;
    }

    /**
     * This method returns the value of the database column tbl_sys_intercept_keyword.keyword
     *
     * @return the value of tbl_sys_intercept_keyword.keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     */
    public SysInterceptKeyword withKeyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_intercept_keyword.keyword
     *
     * @param keyword the value for tbl_sys_intercept_keyword.keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * This method returns the value of the database column tbl_sys_intercept_keyword.isabled
     *
     * @return the value of tbl_sys_intercept_keyword.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public SysInterceptKeyword withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_intercept_keyword.isabled
     *
     * @param isabled the value for tbl_sys_intercept_keyword.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_sys_intercept_keyword.join_time
     *
     * @return the value of tbl_sys_intercept_keyword.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public SysInterceptKeyword withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sys_intercept_keyword.join_time
     *
     * @param joinTime the value for tbl_sys_intercept_keyword.join_time
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
        sb.append(", sysInterceptKeywordId=").append(sysInterceptKeywordId);
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
        SysInterceptKeyword other = (SysInterceptKeyword) that;
        return (this.getSysInterceptKeywordId() == null ? other.getSysInterceptKeywordId() == null : this.getSysInterceptKeywordId().equals(other.getSysInterceptKeywordId()))
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
        result = prime * result + ((getSysInterceptKeywordId() == null) ? 0 : getSysInterceptKeywordId().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        return result;
    }
}