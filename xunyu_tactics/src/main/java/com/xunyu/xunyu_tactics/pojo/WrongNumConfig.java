package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * @author xym
 * @description 错号空号配置 实体类
 * @date 2018/5/9 15:46
 */
public class WrongNumConfig implements Serializable {
    private static final long serialVersionUID = -5052336841870708430L;
    /**
     *   主键
     */
    private Integer wrongNumConfigId;

    /**
     *   手机号码
     */
    private String phoneNumber;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private Date joinTime;


    /**
     * This method returns the value of the database column tbl_wrong_num_config.wrong_num_config_id
     *
     * @return the value of tbl_wrong_num_config.wrong_num_config_id
     */
    public Integer getWrongNumConfigId() {
        return wrongNumConfigId;
    }

    /**
     */
    public WrongNumConfig withWrongNumConfigId(Integer wrongNumConfigId) {
        this.setWrongNumConfigId(wrongNumConfigId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_wrong_num_config.wrong_num_config_id
     *
     * @param wrongNumConfigId the value for tbl_wrong_num_config.wrong_num_config_id
     */
    public void setWrongNumConfigId(Integer wrongNumConfigId) {
        this.wrongNumConfigId = wrongNumConfigId;
    }

    /**
     * This method returns the value of the database column tbl_wrong_num_config.phone_number
     *
     * @return the value of tbl_wrong_num_config.phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     */
    public WrongNumConfig withPhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_wrong_num_config.phone_number
     *
     * @param phoneNumber the value for tbl_wrong_num_config.phone_number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the value of the database column tbl_wrong_num_config.isabled
     *
     * @return the value of tbl_wrong_num_config.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public WrongNumConfig withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_wrong_num_config.isabled
     *
     * @param isabled the value for tbl_wrong_num_config.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_wrong_num_config.join_time
     *
     * @return the value of tbl_wrong_num_config.join_time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     */
    public WrongNumConfig withJoinTime(Date joinTime) {
        this.setJoinTime(joinTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_wrong_num_config.join_time
     *
     * @param joinTime the value for tbl_wrong_num_config.join_time
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
        sb.append(", wrongNumConfigId=").append(wrongNumConfigId);
        sb.append(", phoneNumber=").append(phoneNumber);
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
        WrongNumConfig other = (WrongNumConfig) that;
        return (this.getWrongNumConfigId() == null ? other.getWrongNumConfigId() == null : this.getWrongNumConfigId().equals(other.getWrongNumConfigId()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getJoinTime() == null ? other.getJoinTime() == null : this.getJoinTime().equals(other.getJoinTime()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWrongNumConfigId() == null) ? 0 : getWrongNumConfigId().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getJoinTime() == null) ? 0 : getJoinTime().hashCode());
        return result;
    }
}