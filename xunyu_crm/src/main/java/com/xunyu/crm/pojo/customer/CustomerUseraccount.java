package com.xunyu.crm.pojo.customer;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/24 10:55
 **/
public class CustomerUseraccount {

    private Long serialNumberId;//主键
    private Long customerId;//客户id
    private Long userId;//用户id
    private Integer accountType;//1主账户  2非主账户

    public Long getSerialNumberId() {
        return serialNumberId;
    }

    public void setSerialNumberId(Long serialNumberId) {
        this.serialNumberId = serialNumberId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}
