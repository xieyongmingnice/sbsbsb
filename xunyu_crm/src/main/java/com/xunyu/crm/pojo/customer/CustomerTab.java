package com.xunyu.crm.pojo.customer;

import com.xunyu.model.user.UserModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dth
 * @date 2018/4/24 10:35
 * 客户表
 **/
public class CustomerTab extends UserModel{

    private Long customerId;//主键
    private Long customerGroupId;//客户分组id
    private String customerName;//客户（企业）名称
    private String address;//客户地址
    private String telphone;//客户电话
    private Date createTime;//创建时间
    private String customerAccount;//账号
    private String customerPsw;//密码
    private String enterContact;//联系人
    private String mophone;//用户手机
    private String qq;
    private String email;
    private String business;//业务
    private String finance;//财务
    private String customerService;//客服
    private String manager;//经理
    private Double price;//单价  小数点后3位
    private String remark;//备注
    private String contractNum;//编号
    private Double deposit;//押金  小数点后两位
    private String filePath;//文件地址
    private Integer isabled;// 1可用  其它表示不可用

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCustomerPsw() {
        return customerPsw;
    }

    public void setCustomerPsw(String customerPsw) {
        this.customerPsw = customerPsw;
    }

    public String getEnterContact() {
        return enterContact;
    }

    public void setEnterContact(String enterContact) {
        this.enterContact = enterContact;
    }

    public String getMophone() {
        return mophone;
    }

    public void setMophone(String mophone) {
        this.mophone = mophone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getCustomerService() {
        return customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
