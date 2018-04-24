package com.xunyu.crm.pojo.customer;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/24 10:55
 **/
public class CustomerUseraccount implements Serializable {
    private static final long serialVersionUID = -380758574865818839L;
    private Long customerId;//主键
    private Long userId;//用户id
    private Integer accountType;//1主账户  2非主账户

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
