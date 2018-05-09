package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 回复去黑关键字 实体类
 * @date 2018/5/9 14:41
 */
public class RmBlacklistKeyword implements Serializable {

    private static final long serialVersionUID = -2687231890069021896L;

    /**
     *   主键
     */
    private Integer rmBlacklistKeywordId;

    /**
     *   去黑关键字
     */
    private String keyword;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   可用状态标签，1：可用，0：不可用，默认为1
     */
    private Integer isabled;


    /**
     * This method returns the value of the database column tbl_rm_blacklist_keyword.rm_blacklist_keyword_id
     *
     * @return the value of tbl_rm_blacklist_keyword.rm_blacklist_keyword_id
     */
    public Integer getRmBlacklistKeywordId() {
        return rmBlacklistKeywordId;
    }

    /**
     */
    public RmBlacklistKeyword withRmBlacklistKeywordId(Integer rmBlacklistKeywordId) {
        this.setRmBlacklistKeywordId(rmBlacklistKeywordId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_rm_blacklist_keyword.rm_blacklist_keyword_id
     *
     * @param rmBlacklistKeywordId the value for tbl_rm_blacklist_keyword.rm_blacklist_keyword_id
     */
    public void setRmBlacklistKeywordId(Integer rmBlacklistKeywordId) {
        this.rmBlacklistKeywordId = rmBlacklistKeywordId;
    }

    /**
     * This method returns the value of the database column tbl_rm_blacklist_keyword.keyword
     *
     * @return the value of tbl_rm_blacklist_keyword.keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     */
    public RmBlacklistKeyword withKeyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_rm_blacklist_keyword.keyword
     *
     * @param keyword the value for tbl_rm_blacklist_keyword.keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * This method returns the value of the database column tbl_rm_blacklist_keyword.join_time
     *
     * @return the value of tbl_rm_blacklist_keyword.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public RmBlacklistKeyword withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_rm_blacklist_keyword.join_time
     *
     * @param joinTime the value for tbl_rm_blacklist_keyword.join_time
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method returns the value of the database column tbl_rm_blacklist_keyword.isabled
     *
     * @return the value of tbl_rm_blacklist_keyword.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public RmBlacklistKeyword withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_rm_blacklist_keyword.isabled
     *
     * @param isabled the value for tbl_rm_blacklist_keyword.isabled
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
        sb.append(", rmBlacklistKeywordId=").append(rmBlacklistKeywordId);
        sb.append(", keyword=").append(keyword);
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
        RmBlacklistKeyword other = (RmBlacklistKeyword) that;
        return (this.getRmBlacklistKeywordId() == null ? other.getRmBlacklistKeywordId() == null : this.getRmBlacklistKeywordId().equals(other.getRmBlacklistKeywordId()))
            && (this.getKeyword() == null ? other.getKeyword() == null : this.getKeyword().equals(other.getKeyword()))
            && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRmBlacklistKeywordId() == null) ? 0 : getRmBlacklistKeywordId().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        return result;
    }
}