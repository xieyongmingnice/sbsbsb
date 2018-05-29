package com.xunyu.model.crm.customer;

import com.xunyu.model.user.UserModel;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/24 15:37
 **/
public class CustomerModel extends UserModel implements Serializable {
    private static final long serialVersionUID = 4460604545233227058L;
    private Long customerId;//主键
    private String customerAccount;//账号
    private String customerName;//客户（企业）名称
    private String enterContact;//联系人
    private String business;//业务
    private String customerIds;//多个主键id
    private Long customerGroupId;//分组id

    public Long getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(String customerIds) {
        this.customerIds = customerIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEnterContact() {
        return enterContact;
    }

    public void setEnterContact(String enterContact) {
        this.enterContact = enterContact;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
