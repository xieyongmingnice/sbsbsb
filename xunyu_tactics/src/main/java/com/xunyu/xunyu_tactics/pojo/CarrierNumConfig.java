package com.xunyu.xunyu_tactics.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description
 * @date 2018/6/26 9:53
 */
public class CarrierNumConfig implements Serializable {
    private static final long serialVersionUID = 2624382570392784341L;
    /**
     *   主键
     */
    private Integer carrierNumConfigId;

    /**
     *   运营商类型
     */
    private Integer carrierType;

    /**
     *   号段
     */
    private Integer numPrefix;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     * This method returns the value of the database column tbl_carrier_num_config.carrier_num_config_id
     *
     * @return the value of tbl_carrier_num_config.carrier_num_config_id
     */
    public Integer getCarrierNumConfigId() {
        return carrierNumConfigId;
    }

    /**
     */
    public CarrierNumConfig withCarrierNumConfigId(Integer carrierNumConfigId) {
        this.setCarrierNumConfigId(carrierNumConfigId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_num_config.carrier_num_config_id
     *
     * @param carrierNumConfigId the value for tbl_carrier_num_config.carrier_num_config_id
     */
    public void setCarrierNumConfigId(Integer carrierNumConfigId) {
        this.carrierNumConfigId = carrierNumConfigId;
    }

    public Integer getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(Integer carrierType) {
        this.carrierType = carrierType;
    }

    /**
     * This method returns the value of the database column tbl_carrier_num_config.num_prefix
     *
     * @return the value of tbl_carrier_num_config.num_prefix
     */
    public Integer getNumPrefix() {
        return numPrefix;
    }

    /**
     */
    public CarrierNumConfig withNumPrefix(Integer numPrefix) {
        this.setNumPrefix(numPrefix);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_num_config.num_prefix
     *
     * @param numPrefix the value for tbl_carrier_num_config.num_prefix
     */
    public void setNumPrefix(Integer numPrefix) {
        this.numPrefix = numPrefix;
    }

    /**
     * This method returns the value of the database column tbl_carrier_num_config.isabled
     *
     * @return the value of tbl_carrier_num_config.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public CarrierNumConfig withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_num_config.isabled
     *
     * @param isabled the value for tbl_carrier_num_config.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_carrier_num_config.create_time
     *
     * @return the value of tbl_carrier_num_config.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     */
    public CarrierNumConfig withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_num_config.create_time
     *
     * @param createTime the value for tbl_carrier_num_config.create_time
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
        sb.append(", carrierNumConfigId=").append(carrierNumConfigId);
        sb.append(", carrierType=").append(carrierType);
        sb.append(", numPrefix=").append(numPrefix);
        sb.append(", isabled=").append(isabled);
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
        CarrierNumConfig other = (CarrierNumConfig) that;
        return (this.getCarrierNumConfigId() == null ? other.getCarrierNumConfigId() == null : this.getCarrierNumConfigId().equals(other.getCarrierNumConfigId()))
            && (this.getCarrierType() == null ? other.getCarrierType() == null : this.getCarrierType().equals(other.getCarrierType()))
            && (this.getNumPrefix() == null ? other.getNumPrefix() == null : this.getNumPrefix().equals(other.getNumPrefix()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarrierNumConfigId() == null) ? 0 : getCarrierNumConfigId().hashCode());
        result = prime * result + ((getCarrierType() == null) ? 0 : getCarrierType().hashCode());
        result = prime * result + ((getNumPrefix() == null) ? 0 : getNumPrefix().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}