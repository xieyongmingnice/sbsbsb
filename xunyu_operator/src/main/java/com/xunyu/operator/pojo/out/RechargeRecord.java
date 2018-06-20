package com.xunyu.operator.pojo.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xym
 * @description 充值记录实体类
 * @date 2018/6/19 10:16
 */
public class RechargeRecord implements Serializable {
    private static final long serialVersionUID = -7425956716039984326L;
    /**
     * 主键
     */
    private Integer rechargeRecordId;

    /**
     *   企业代码
     */
    private String enterpriseCode;

    /**
     *   企业接入号
     */
    private String spAccessCode;

    /**
     *   业务类型 1:短信 2:彩信 3:语音 4:流量
     */
    private Integer serviceType;

    /**
     *   操作类型 1：手动充值 2：手动扣除 3：手动返还 4：其他保留
     */
    private Integer operType;

    /**
     *   付款类型 1:未付款 2:已付款 3:无需付款 4:已退款 5:未退款 6:无需退款 7:其他情况
     */
    private Integer payType;

    /**
     *   充值短信费率
     */
    private BigDecimal rechargeMsgRate;

    /**
     *   充值短信条数
     */
    private Integer rechargeMsgNum;

    /**
     *   充值总金额
     */
    private BigDecimal rechargeMoney;

    /**
     *   当前剩余短信量
     */
    private Integer remainderMsgNum;

    /**
     *   充值备注说明
     */
    private String rechargeRemark;

    /**
     *   操作员id
     */
    private Integer operatorId;

    /**
     *   是否有效标签 1:有效 0：无效 默认1
     */
    private Integer isabled;

    /**
     *   创建时间
     */
    private Date createTime;
    /**
     * This method returns the value of the database column tbl_recharge_record.recharge_record_id
     *
     * @return the value of tbl_recharge_record.recharge_record_id
     */
    public Integer getRechargeRecordId() {
        return rechargeRecordId;
    }

    /**
     */
    public RechargeRecord withRechargeRecordId(Integer rechargeRecordId) {
        this.setRechargeRecordId(rechargeRecordId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.recharge_record_id
     *
     * @param rechargeRecordId the value for tbl_recharge_record.recharge_record_id
     */
    public void setRechargeRecordId(Integer rechargeRecordId) {
        this.rechargeRecordId = rechargeRecordId;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.enterprise_code
     *
     * @return the value of tbl_recharge_record.enterprise_code
     */
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    /**
     */
    public RechargeRecord withEnterpriseCode(String enterpriseCode) {
        this.setEnterpriseCode(enterpriseCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.enterprise_code
     *
     * @param enterpriseCode the value for tbl_recharge_record.enterprise_code
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.sp_access_code
     *
     * @return the value of tbl_recharge_record.sp_access_code
     */
    public String getSpAccessCode() {
        return spAccessCode;
    }

    /**
     */
    public RechargeRecord withSpAccessCode(String spAccessCode) {
        this.setSpAccessCode(spAccessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.sp_access_code
     *
     * @param spAccessCode the value for tbl_recharge_record.sp_access_code
     */
    public void setSpAccessCode(String spAccessCode) {
        this.spAccessCode = spAccessCode;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.service_type
     *
     * @return the value of tbl_recharge_record.service_type
     */
    public Integer getServiceType() {
        return serviceType;
    }

    /**
     */
    public RechargeRecord withServiceType(Integer serviceType) {
        this.setServiceType(serviceType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.service_type
     *
     * @param serviceType the value for tbl_recharge_record.service_type
     */
    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.oper_type
     *
     * @return the value of tbl_recharge_record.oper_type
     */
    public Integer getOperType() {
        return operType;
    }

    /**
     */
    public RechargeRecord withOperType(Integer operType) {
        this.setOperType(operType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.oper_type
     *
     * @param operType the value for tbl_recharge_record.oper_type
     */
    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.pay_type
     *
     * @return the value of tbl_recharge_record.pay_type
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     */
    public RechargeRecord withPayType(Integer payType) {
        this.setPayType(payType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.pay_type
     *
     * @param payType the value for tbl_recharge_record.pay_type
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.recharge_msg_rate
     *
     * @return the value of tbl_recharge_record.recharge_msg_rate
     */
    public BigDecimal getRechargeMsgRate() {
        return rechargeMsgRate;
    }

    /**
     */
    public RechargeRecord withRechargeMsgRate(BigDecimal rechargeMsgRate) {
        this.setRechargeMsgRate(rechargeMsgRate);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.recharge_msg_rate
     *
     * @param rechargeMsgRate the value for tbl_recharge_record.recharge_msg_rate
     */
    public void setRechargeMsgRate(BigDecimal rechargeMsgRate) {
        this.rechargeMsgRate = rechargeMsgRate;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.recharge_msg_num
     *
     * @return the value of tbl_recharge_record.recharge_msg_num
     */
    public Integer getRechargeMsgNum() {
        return rechargeMsgNum;
    }

    /**
     */
    public RechargeRecord withRechargeMsgNum(Integer rechargeMsgNum) {
        this.setRechargeMsgNum(rechargeMsgNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.recharge_msg_num
     *
     * @param rechargeMsgNum the value for tbl_recharge_record.recharge_msg_num
     */
    public void setRechargeMsgNum(Integer rechargeMsgNum) {
        this.rechargeMsgNum = rechargeMsgNum;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.recharge_money
     *
     * @return the value of tbl_recharge_record.recharge_money
     */
    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    /**
     */
    public RechargeRecord withRechargeMoney(BigDecimal rechargeMoney) {
        this.setRechargeMoney(rechargeMoney);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.recharge_money
     *
     * @param rechargeMoney the value for tbl_recharge_record.recharge_money
     */
    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.remainder_msg_num
     *
     * @return the value of tbl_recharge_record.remainder_msg_num
     */
    public Integer getRemainderMsgNum() {
        return remainderMsgNum;
    }

    /**
     */
    public RechargeRecord withRemainderMsgNum(Integer remainderMsgNum) {
        this.setRemainderMsgNum(remainderMsgNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.remainder_msg_num
     *
     * @param remainderMsgNum the value for tbl_recharge_record.remainder_msg_num
     */
    public void setRemainderMsgNum(Integer remainderMsgNum) {
        this.remainderMsgNum = remainderMsgNum;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.recharge_remark
     *
     * @return the value of tbl_recharge_record.recharge_remark
     */
    public String getRechargeRemark() {
        return rechargeRemark;
    }

    /**
     */
    public RechargeRecord withRechargeRemark(String rechargeRemark) {
        this.setRechargeRemark(rechargeRemark);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.recharge_remark
     *
     * @param rechargeRemark the value for tbl_recharge_record.recharge_remark
     */
    public void setRechargeRemark(String rechargeRemark) {
        this.rechargeRemark = rechargeRemark;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.operator_id
     *
     * @return the value of tbl_recharge_record.operator_id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     */
    public RechargeRecord withOperatorId(Integer operatorId) {
        this.setOperatorId(operatorId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.operator_id
     *
     * @param operatorId the value for tbl_recharge_record.operator_id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.isabled
     *
     * @return the value of tbl_recharge_record.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public RechargeRecord withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.isabled
     *
     * @param isabled the value for tbl_recharge_record.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_recharge_record.create_time
     *
     * @return the value of tbl_recharge_record.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     */
    public RechargeRecord withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_recharge_record.create_time
     *
     * @param createTime the value for tbl_recharge_record.create_time
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
        sb.append(", rechargeRecordId=").append(rechargeRecordId);
        sb.append(", enterpriseCode=").append(enterpriseCode);
        sb.append(", spAccessCode=").append(spAccessCode);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", operType=").append(operType);
        sb.append(", payType=").append(payType);
        sb.append(", rechargeMsgRate=").append(rechargeMsgRate);
        sb.append(", rechargeMsgNum=").append(rechargeMsgNum);
        sb.append(", rechargeMoney=").append(rechargeMoney);
        sb.append(", remainderMsgNum=").append(remainderMsgNum);
        sb.append(", rechargeRemark=").append(rechargeRemark);
        sb.append(", operatorId=").append(operatorId);
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
        RechargeRecord other = (RechargeRecord) that;
        return (this.getRechargeRecordId() == null ? other.getRechargeRecordId() == null : this.getRechargeRecordId().equals(other.getRechargeRecordId()))
            && (this.getEnterpriseCode() == null ? other.getEnterpriseCode() == null : this.getEnterpriseCode().equals(other.getEnterpriseCode()))
            && (this.getSpAccessCode() == null ? other.getSpAccessCode() == null : this.getSpAccessCode().equals(other.getSpAccessCode()))
            && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
            && (this.getOperType() == null ? other.getOperType() == null : this.getOperType().equals(other.getOperType()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getRechargeMsgRate() == null ? other.getRechargeMsgRate() == null : this.getRechargeMsgRate().equals(other.getRechargeMsgRate()))
            && (this.getRechargeMsgNum() == null ? other.getRechargeMsgNum() == null : this.getRechargeMsgNum().equals(other.getRechargeMsgNum()))
            && (this.getRechargeMoney() == null ? other.getRechargeMoney() == null : this.getRechargeMoney().equals(other.getRechargeMoney()))
            && (this.getRemainderMsgNum() == null ? other.getRemainderMsgNum() == null : this.getRemainderMsgNum().equals(other.getRemainderMsgNum()))
            && (this.getRechargeRemark() == null ? other.getRechargeRemark() == null : this.getRechargeRemark().equals(other.getRechargeRemark()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRechargeRecordId() == null) ? 0 : getRechargeRecordId().hashCode());
        result = prime * result + ((getEnterpriseCode() == null) ? 0 : getEnterpriseCode().hashCode());
        result = prime * result + ((getSpAccessCode() == null) ? 0 : getSpAccessCode().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getOperType() == null) ? 0 : getOperType().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getRechargeMsgRate() == null) ? 0 : getRechargeMsgRate().hashCode());
        result = prime * result + ((getRechargeMsgNum() == null) ? 0 : getRechargeMsgNum().hashCode());
        result = prime * result + ((getRechargeMoney() == null) ? 0 : getRechargeMoney().hashCode());
        result = prime * result + ((getRemainderMsgNum() == null) ? 0 : getRemainderMsgNum().hashCode());
        result = prime * result + ((getRechargeRemark() == null) ? 0 : getRechargeRemark().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}