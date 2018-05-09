package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 回复加黑关键字 实体类
 * @date 2018/5/9 10:35
 */
public class BlacklistKeyword implements Serializable {

    private static final long serialVersionUID = 8866622163811774845L;

    /**
     *   主键
     */
    private Integer blacklistKeywordId;

    /**
     *   加黑关键字
     */
    private String keyword;

    /**
     *   可用状态标志 1:可用，0:不可用，默认为1
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     * This method returns the value of the database column tbl_blacklist_keyword.blacklist_keyword_id
     *
     * @return the value of tbl_blacklist_keyword.blacklist_keyword_id
     */
    public Integer getBlacklistKeywordId() {
        return blacklistKeywordId;
    }

    /**
     */
    public BlacklistKeyword withBlacklistKeywordId(Integer blacklistKeywordId) {
        this.setBlacklistKeywordId(blacklistKeywordId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_blacklist_keyword.blacklist_keyword_id
     *
     * @param blacklistKeywordId the value for tbl_blacklist_keyword.blacklist_keyword_id
     */
    public void setBlacklistKeywordId(Integer blacklistKeywordId) {
        this.blacklistKeywordId = blacklistKeywordId;
    }

    /**
     * This method returns the value of the database column tbl_blacklist_keyword.keyword
     *
     * @return the value of tbl_blacklist_keyword.keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     */
    public BlacklistKeyword withKeyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_blacklist_keyword.keyword
     *
     * @param keyword the value for tbl_blacklist_keyword.keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * This method returns the value of the database column tbl_blacklist_keyword.isabled
     *
     * @return the value of tbl_blacklist_keyword.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public BlacklistKeyword withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_blacklist_keyword.isabled
     *
     * @param isabled the value for tbl_blacklist_keyword.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_blacklist_keyword.join_time
     *
     * @return the value of tbl_blacklist_keyword.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public BlacklistKeyword withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_blacklist_keyword.join_time
     *
     * @param joinTime the value for tbl_blacklist_keyword.join_time
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
        sb.append(", blacklistKeywordId=").append(blacklistKeywordId);
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
        BlacklistKeyword other = (BlacklistKeyword) that;
        return (this.getBlacklistKeywordId() == null ? other.getBlacklistKeywordId() == null : this.getBlacklistKeywordId().equals(other.getBlacklistKeywordId()))
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
        result = prime * result + ((getBlacklistKeywordId() == null) ? 0 : getBlacklistKeywordId().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        return result;
    }
}