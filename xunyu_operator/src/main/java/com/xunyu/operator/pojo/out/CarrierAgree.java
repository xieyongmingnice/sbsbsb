package com.xunyu.operator.pojo.out;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 运营商协议实体类
 * @date 2018/6/12 16:27
 */
public class CarrierAgree  implements Serializable {
    private static final long serialVersionUID = 780775022057525102L;
    /**
     * 主键
     */
    private Integer carrierAgreeId;

    /**
     *   运营商ID
     */
    private Integer carrierId;

    /**
     *   协议名称
     */
    private String agreeName;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     *   创建时间
     */
    private Date createTime;



    /**
     * This method returns the value of the database column tbl_carrier_agree.carrier_agree_id
     *
     * @return the value of tbl_carrier_agree.carrier_agree_id
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public Integer getCarrierAgreeId() {
        return carrierAgreeId;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public CarrierAgree withCarrierAgreeId(Integer carrierAgreeId) {
        this.setCarrierAgreeId(carrierAgreeId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_agree.carrier_agree_id
     *
     * @param carrierAgreeId the value for tbl_carrier_agree.carrier_agree_id
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public void setCarrierAgreeId(Integer carrierAgreeId) {
        this.carrierAgreeId = carrierAgreeId;
    }

    /**
     * This method returns the value of the database column tbl_carrier_agree.carrier_id
     *
     * @return the value of tbl_carrier_agree.carrier_id
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public Integer getCarrierId() {
        return carrierId;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public CarrierAgree withCarrierId(Integer carrierId) {
        this.setCarrierId(carrierId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_agree.carrier_id
     *
     * @param carrierId the value for tbl_carrier_agree.carrier_id
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    /**
     * This method returns the value of the database column tbl_carrier_agree.agree_name
     *
     * @return the value of tbl_carrier_agree.agree_name
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public String getAgreeName() {
        return agreeName;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public CarrierAgree withAgreeName(String agreeName) {
        this.setAgreeName(agreeName);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_agree.agree_name
     *
     * @param agreeName the value for tbl_carrier_agree.agree_name
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public void setAgreeName(String agreeName) {
        this.agreeName = agreeName;
    }

    /**
     * This method returns the value of the database column tbl_carrier_agree.isabled
     *
     * @return the value of tbl_carrier_agree.isabled
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public CarrierAgree withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_agree.isabled
     *
     * @param isabled the value for tbl_carrier_agree.isabled
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_carrier_agree.create_time
     *
     * @return the value of tbl_carrier_agree.create_time
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public CarrierAgree withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_carrier_agree.create_time
     *
     * @param createTime the value for tbl_carrier_agree.create_time
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carrierAgreeId=").append(carrierAgreeId);
        sb.append(", carrierId=").append(carrierId);
        sb.append(", agreeName=").append(agreeName);
        sb.append(", isabled=").append(isabled);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
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
        CarrierAgree other = (CarrierAgree) that;
        return (this.getCarrierAgreeId() == null ? other.getCarrierAgreeId() == null : this.getCarrierAgreeId().equals(other.getCarrierAgreeId()))
            && (this.getCarrierId() == null ? other.getCarrierId() == null : this.getCarrierId().equals(other.getCarrierId()))
            && (this.getAgreeName() == null ? other.getAgreeName() == null : this.getAgreeName().equals(other.getAgreeName()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:40 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarrierAgreeId() == null) ? 0 : getCarrierAgreeId().hashCode());
        result = prime * result + ((getCarrierId() == null) ? 0 : getCarrierId().hashCode());
        result = prime * result + ((getAgreeName() == null) ? 0 : getAgreeName().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}