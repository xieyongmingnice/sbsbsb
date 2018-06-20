package com.xunyu.model.operator.out;


import com.xunyu.model.user.UserModel;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xym
 * @description 充值记录model
 * @date 2018/6/19 10:29
 */
public class RechargeRecordModel extends UserModel implements Serializable{
    private static final long serialVersionUID = 1631454173990343769L;

    /**
     * 主键
     */
    private Integer rechargeRecordId;
    /**
     *   企业代码
     */
    @NotBlank(message = "企业代码不能为空")
    private String enterpriseCode;

    /**
     *   企业接入号(赋给SP接入码)
     */
    @NotBlank(message = "企业接入号不能为空")
    private String spAccessCode;

    /**
     *   业务类型 1:短信 2:彩信 3:语音 4:流量
     */
    @NotNull(message = "业务类型不能为空")
    private Integer serviceType;

    /**
     *   操作类型 1：手动充值 2：手动扣除 3：手动返还 4：其他保留
     */
    @NotNull(message = "操作类型不能为空")
    private Integer operType;

    /**
     *   付款类型 1:未付款 2:已付款 3:无需付款 4:已退款 5:未退款 6:无需退款 7:其他情况
     */
    @NotNull(message = "付款类型不能为空")
    private Integer payType;

    /**
     *   充值短信费率
     */
    @NotNull(message = "充值短信费率不能为空")
    private BigDecimal rechargeMsgRate;

    /**
     *   充值短信条数
     */
    @NotNull(message = "充值短信条数不能为空")
    private Integer rechargeMsgNum;

    /**
     *   充值总金额
     */
    @NotNull(message = "充值总金额不能为空")
    private BigDecimal rechargeMoney;

    /**
     *   当前剩余短信量
     */
    @NotNull(message = "当前剩余短信量不能为空")
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
     * 充值后条数
     */
    private Integer numAfterRecharge;

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getSpAccessCode() {
        return spAccessCode;
    }

    public void setSpAccessCode(String spAccessCode) {
        this.spAccessCode = spAccessCode;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getRechargeMsgRate() {
        return rechargeMsgRate;
    }

    public void setRechargeMsgRate(BigDecimal rechargeMsgRate) {
        this.rechargeMsgRate = rechargeMsgRate;
    }

    public Integer getRechargeMsgNum() {
        return rechargeMsgNum;
    }

    public void setRechargeMsgNum(Integer rechargeMsgNum) {
        this.rechargeMsgNum = rechargeMsgNum;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Integer getRemainderMsgNum() {
        return remainderMsgNum;
    }

    public void setRemainderMsgNum(Integer remainderMsgNum) {
        this.remainderMsgNum = remainderMsgNum;
    }

    public String getRechargeRemark() {
        return rechargeRemark;
    }

    public void setRechargeRemark(String rechargeRemark) {
        this.rechargeRemark = rechargeRemark;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNumAfterRecharge() {
        return numAfterRecharge;
    }

    public void setNumAfterRecharge(Integer numAfterRecharge) {
        this.numAfterRecharge = numAfterRecharge;
    }

    public Integer getRechargeRecordId() {
        return rechargeRecordId;
    }

    public void setRechargeRecordId(Integer rechargeRecordId) {
        this.rechargeRecordId = rechargeRecordId;
    }
}
