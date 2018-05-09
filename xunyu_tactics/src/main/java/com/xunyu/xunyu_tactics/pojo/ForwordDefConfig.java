package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

public class ForwordDefConfig extends  implements Serializable {
    /**
     *   主键
     *
     */
    private Integer forwordDefConfigId;

    /**
     *   网关名称
     *
     */
    private String gatewayName;

    /**
     *   网关接入号
     *
     */
    private String accessNumber;

    /**
     *   网关状态 1：有效，0：无效
     *
     */
    private Integer gatewayStatus;

    /**
     *   网关代码
     *
     */
    private String gatewayCode;

    /**
     *   转发代码
     *
     */
    private String forwordCode;

    /**
     *   1：转发，0：不转发，默认为1
     *
     */
    private Integer whetherForword;

    /**
     *   1：计费，0：不计费，默认为1
     *
     */
    private Integer whetherCharging;

    /**
     *   修改时间
     *
     */
    private Date updateTime;

    /**
     *   创建时间
     *
     */
    private Date createTime;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column tbl_forword_def_config.forword_def_config_id
     *
     * @return the value of tbl_forword_def_config.forword_def_config_id
     */
    public Integer getForwordDefConfigId() {
        return forwordDefConfigId;
    }

    /**
     */
    public ForwordDefConfig withForwordDefConfigId(Integer forwordDefConfigId) {
        this.setForwordDefConfigId(forwordDefConfigId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.forword_def_config_id
     *
     * @param forwordDefConfigId the value for tbl_forword_def_config.forword_def_config_id
     */
    public void setForwordDefConfigId(Integer forwordDefConfigId) {
        this.forwordDefConfigId = forwordDefConfigId;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.gateway_name
     *
     * @return the value of tbl_forword_def_config.gateway_name
     */
    public String getGatewayName() {
        return gatewayName;
    }

    /**
     */
    public ForwordDefConfig withGatewayName(String gatewayName) {
        this.setGatewayName(gatewayName);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.gateway_name
     *
     * @param gatewayName the value for tbl_forword_def_config.gateway_name
     */
    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.access_number
     *
     * @return the value of tbl_forword_def_config.access_number
     */
    public String getAccessNumber() {
        return accessNumber;
    }

    /**
     */
    public ForwordDefConfig withAccessNumber(String accessNumber) {
        this.setAccessNumber(accessNumber);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.access_number
     *
     * @param accessNumber the value for tbl_forword_def_config.access_number
     */
    public void setAccessNumber(String accessNumber) {
        this.accessNumber = accessNumber;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.gateway_status
     *
     * @return the value of tbl_forword_def_config.gateway_status
     */
    public Integer getGatewayStatus() {
        return gatewayStatus;
    }

    /**
     */
    public ForwordDefConfig withGatewayStatus(Integer gatewayStatus) {
        this.setGatewayStatus(gatewayStatus);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.gateway_status
     *
     * @param gatewayStatus the value for tbl_forword_def_config.gateway_status
     */
    public void setGatewayStatus(Integer gatewayStatus) {
        this.gatewayStatus = gatewayStatus;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.gateway_code
     *
     * @return the value of tbl_forword_def_config.gateway_code
     */
    public String getGatewayCode() {
        return gatewayCode;
    }

    /**
     */
    public ForwordDefConfig withGatewayCode(String gatewayCode) {
        this.setGatewayCode(gatewayCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.gateway_code
     *
     * @param gatewayCode the value for tbl_forword_def_config.gateway_code
     */
    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.forword_code
     *
     * @return the value of tbl_forword_def_config.forword_code
     */
    public String getForwordCode() {
        return forwordCode;
    }

    /**
     */
    public ForwordDefConfig withForwordCode(String forwordCode) {
        this.setForwordCode(forwordCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.forword_code
     *
     * @param forwordCode the value for tbl_forword_def_config.forword_code
     */
    public void setForwordCode(String forwordCode) {
        this.forwordCode = forwordCode;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.whether_forword
     *
     * @return the value of tbl_forword_def_config.whether_forword
     */
    public Integer getWhetherForword() {
        return whetherForword;
    }

    /**
     */
    public ForwordDefConfig withWhetherForword(Integer whetherForword) {
        this.setWhetherForword(whetherForword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.whether_forword
     *
     * @param whetherForword the value for tbl_forword_def_config.whether_forword
     */
    public void setWhetherForword(Integer whetherForword) {
        this.whetherForword = whetherForword;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.whether_charging
     *
     * @return the value of tbl_forword_def_config.whether_charging
     */
    public Integer getWhetherCharging() {
        return whetherCharging;
    }

    /**
     */
    public ForwordDefConfig withWhetherCharging(Integer whetherCharging) {
        this.setWhetherCharging(whetherCharging);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.whether_charging
     *
     * @param whetherCharging the value for tbl_forword_def_config.whether_charging
     */
    public void setWhetherCharging(Integer whetherCharging) {
        this.whetherCharging = whetherCharging;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.update_time
     *
     * @return the value of tbl_forword_def_config.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     */
    public ForwordDefConfig withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.update_time
     *
     * @param updateTime the value for tbl_forword_def_config.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column tbl_forword_def_config.create_time
     *
     * @return the value of tbl_forword_def_config.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     */
    public ForwordDefConfig withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_forword_def_config.create_time
     *
     * @param createTime the value for tbl_forword_def_config.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", forwordDefConfigId=").append(forwordDefConfigId);
        sb.append(", gatewayName=").append(gatewayName);
        sb.append(", accessNumber=").append(accessNumber);
        sb.append(", gatewayStatus=").append(gatewayStatus);
        sb.append(", gatewayCode=").append(gatewayCode);
        sb.append(", forwordCode=").append(forwordCode);
        sb.append(", whetherForword=").append(whetherForword);
        sb.append(", whetherCharging=").append(whetherCharging);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
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
        ForwordDefConfig other = (ForwordDefConfig) that;
        return (this.getForwordDefConfigId() == null ? other.getForwordDefConfigId() == null : this.getForwordDefConfigId().equals(other.getForwordDefConfigId()))
            && (this.getGatewayName() == null ? other.getGatewayName() == null : this.getGatewayName().equals(other.getGatewayName()))
            && (this.getAccessNumber() == null ? other.getAccessNumber() == null : this.getAccessNumber().equals(other.getAccessNumber()))
            && (this.getGatewayStatus() == null ? other.getGatewayStatus() == null : this.getGatewayStatus().equals(other.getGatewayStatus()))
            && (this.getGatewayCode() == null ? other.getGatewayCode() == null : this.getGatewayCode().equals(other.getGatewayCode()))
            && (this.getForwordCode() == null ? other.getForwordCode() == null : this.getForwordCode().equals(other.getForwordCode()))
            && (this.getWhetherForword() == null ? other.getWhetherForword() == null : this.getWhetherForword().equals(other.getWhetherForword()))
            && (this.getWhetherCharging() == null ? other.getWhetherCharging() == null : this.getWhetherCharging().equals(other.getWhetherCharging()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getForwordDefConfigId() == null) ? 0 : getForwordDefConfigId().hashCode());
        result = prime * result + ((getGatewayName() == null) ? 0 : getGatewayName().hashCode());
        result = prime * result + ((getAccessNumber() == null) ? 0 : getAccessNumber().hashCode());
        result = prime * result + ((getGatewayStatus() == null) ? 0 : getGatewayStatus().hashCode());
        result = prime * result + ((getGatewayCode() == null) ? 0 : getGatewayCode().hashCode());
        result = prime * result + ((getForwordCode() == null) ? 0 : getForwordCode().hashCode());
        result = prime * result + ((getWhetherForword() == null) ? 0 : getWhetherForword().hashCode());
        result = prime * result + ((getWhetherCharging() == null) ? 0 : getWhetherCharging().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}