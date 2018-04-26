package com.xunyu.crm.pojo.cuspay;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/4/26 14:46
 **/
public class CustomerPay extends UserModel{

    private Long payrecordId;//主键
    private Long customerId;//客户id
    private Double payAmount;//付费金额
    private Integer payChannel;//付费渠道
    private Date payTime;//付款时间

    public Long getPayrecordId() {
        return payrecordId;
    }

    public void setPayrecordId(Long payrecordId) {
        this.payrecordId = payrecordId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
