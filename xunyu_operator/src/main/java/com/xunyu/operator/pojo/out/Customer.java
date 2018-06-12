package com.xunyu.operator.pojo.out;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 客户实体类
 * @date 2018/6/12 16:26
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = -4286611142886980651L;
    /**
     *   客户流水ID自增长
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private Integer customerId;

    /**
     *   客户分组ID
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private Integer customerGroupId;

    /**
     *   客户名称
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String customerName;

    /**
     *   客户地址
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String address;

    /**
     *   客户电话
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String telphone;

    /**
     *   账号
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String customerAccount;

    /**
     *   密码
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String customerPsw;

    /**
     *   联系人
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String enterContact;

    /**
     *   用户手机
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String mophone;

    /**
     *   qq
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String qq;

    /**
     *   用户邮件
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String email;

    /**
     *   业务
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String business;

    /**
     *   财务
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String finance;

    /**
     *   客服
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String customerService;

    /**
     *   经理
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String manager;

    /**
     *   账号
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private Double price;

    /**
     *   备注
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String remark;

    /**
     *   编号
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String contractNum;

    /**
     *   押金金额
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private Double deposit;

    /**
     *   文件地址
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String filePath;

    /**
     *   1可用  其它表示不可用
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private Byte isabled;

    /**
     *   创建时间
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private Date createTime;

    /**
     *
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    private String originPath;


    /**
     * This method returns the value of the database column tbl_customer.customer_id
     *
     * @return the value of tbl_customer.customer_id
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCustomerId(Integer customerId) {
        this.setCustomerId(customerId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.customer_id
     *
     * @param customerId the value for tbl_customer.customer_id
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method returns the value of the database column tbl_customer.customer_group_id
     *
     * @return the value of tbl_customer.customer_group_id
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Integer getCustomerGroupId() {
        return customerGroupId;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCustomerGroupId(Integer customerGroupId) {
        this.setCustomerGroupId(customerGroupId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.customer_group_id
     *
     * @param customerGroupId the value for tbl_customer.customer_group_id
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCustomerGroupId(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    /**
     * This method returns the value of the database column tbl_customer.customer_name
     *
     * @return the value of tbl_customer.customer_name
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCustomerName(String customerName) {
        this.setCustomerName(customerName);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.customer_name
     *
     * @param customerName the value for tbl_customer.customer_name
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * This method returns the value of the database column tbl_customer.address
     *
     * @return the value of tbl_customer.address
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.address
     *
     * @param address the value for tbl_customer.address
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method returns the value of the database column tbl_customer.telphone
     *
     * @return the value of tbl_customer.telphone
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withTelphone(String telphone) {
        this.setTelphone(telphone);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.telphone
     *
     * @param telphone the value for tbl_customer.telphone
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * This method returns the value of the database column tbl_customer.customer_account
     *
     * @return the value of tbl_customer.customer_account
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getCustomerAccount() {
        return customerAccount;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCustomerAccount(String customerAccount) {
        this.setCustomerAccount(customerAccount);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.customer_account
     *
     * @param customerAccount the value for tbl_customer.customer_account
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    /**
     * This method returns the value of the database column tbl_customer.customer_psw
     *
     * @return the value of tbl_customer.customer_psw
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getCustomerPsw() {
        return customerPsw;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCustomerPsw(String customerPsw) {
        this.setCustomerPsw(customerPsw);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.customer_psw
     *
     * @param customerPsw the value for tbl_customer.customer_psw
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCustomerPsw(String customerPsw) {
        this.customerPsw = customerPsw;
    }

    /**
     * This method returns the value of the database column tbl_customer.enter_contact
     *
     * @return the value of tbl_customer.enter_contact
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getEnterContact() {
        return enterContact;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withEnterContact(String enterContact) {
        this.setEnterContact(enterContact);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.enter_contact
     *
     * @param enterContact the value for tbl_customer.enter_contact
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setEnterContact(String enterContact) {
        this.enterContact = enterContact;
    }

    /**
     * This method returns the value of the database column tbl_customer.mophone
     *
     * @return the value of tbl_customer.mophone
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getMophone() {
        return mophone;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withMophone(String mophone) {
        this.setMophone(mophone);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.mophone
     *
     * @param mophone the value for tbl_customer.mophone
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setMophone(String mophone) {
        this.mophone = mophone;
    }

    /**
     * This method returns the value of the database column tbl_customer.qq
     *
     * @return the value of tbl_customer.qq
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getQq() {
        return qq;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withQq(String qq) {
        this.setQq(qq);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.qq
     *
     * @param qq the value for tbl_customer.qq
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * This method returns the value of the database column tbl_customer.email
     *
     * @return the value of tbl_customer.email
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.email
     *
     * @param email the value for tbl_customer.email
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the value of the database column tbl_customer.business
     *
     * @return the value of tbl_customer.business
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getBusiness() {
        return business;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withBusiness(String business) {
        this.setBusiness(business);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.business
     *
     * @param business the value for tbl_customer.business
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * This method returns the value of the database column tbl_customer.finance
     *
     * @return the value of tbl_customer.finance
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getFinance() {
        return finance;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withFinance(String finance) {
        this.setFinance(finance);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.finance
     *
     * @param finance the value for tbl_customer.finance
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setFinance(String finance) {
        this.finance = finance;
    }

    /**
     * This method returns the value of the database column tbl_customer.customer_service
     *
     * @return the value of tbl_customer.customer_service
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getCustomerService() {
        return customerService;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCustomerService(String customerService) {
        this.setCustomerService(customerService);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.customer_service
     *
     * @param customerService the value for tbl_customer.customer_service
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    /**
     * This method returns the value of the database column tbl_customer.manager
     *
     * @return the value of tbl_customer.manager
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getManager() {
        return manager;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withManager(String manager) {
        this.setManager(manager);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.manager
     *
     * @param manager the value for tbl_customer.manager
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * This method returns the value of the database column tbl_customer.price
     *
     * @return the value of tbl_customer.price
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withPrice(Double price) {
        this.setPrice(price);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.price
     *
     * @param price the value for tbl_customer.price
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method returns the value of the database column tbl_customer.remark
     *
     * @return the value of tbl_customer.remark
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.remark
     *
     * @param remark the value for tbl_customer.remark
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column tbl_customer.contract_num
     *
     * @return the value of tbl_customer.contract_num
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getContractNum() {
        return contractNum;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withContractNum(String contractNum) {
        this.setContractNum(contractNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.contract_num
     *
     * @param contractNum the value for tbl_customer.contract_num
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    /**
     * This method returns the value of the database column tbl_customer.deposit
     *
     * @return the value of tbl_customer.deposit
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Double getDeposit() {
        return deposit;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withDeposit(Double deposit) {
        this.setDeposit(deposit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.deposit
     *
     * @param deposit the value for tbl_customer.deposit
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    /**
     * This method returns the value of the database column tbl_customer.file_path
     *
     * @return the value of tbl_customer.file_path
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withFilePath(String filePath) {
        this.setFilePath(filePath);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.file_path
     *
     * @param filePath the value for tbl_customer.file_path
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method returns the value of the database column tbl_customer.isabled
     *
     * @return the value of tbl_customer.isabled
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Byte getIsabled() {
        return isabled;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withIsabled(Byte isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.isabled
     *
     * @param isabled the value for tbl_customer.isabled
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setIsabled(Byte isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_customer.create_time
     *
     * @return the value of tbl_customer.create_time
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.create_time
     *
     * @param createTime the value for tbl_customer.create_time
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column tbl_customer.origin_path
     *
     * @return the value of tbl_customer.origin_path
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public String getOriginPath() {
        return originPath;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public Customer withOriginPath(String originPath) {
        this.setOriginPath(originPath);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_customer.origin_path
     *
     * @param originPath the value for tbl_customer.origin_path
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    public void setOriginPath(String originPath) {
        this.originPath = originPath;
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerId=").append(customerId);
        sb.append(", customerGroupId=").append(customerGroupId);
        sb.append(", customerName=").append(customerName);
        sb.append(", address=").append(address);
        sb.append(", telphone=").append(telphone);
        sb.append(", customerAccount=").append(customerAccount);
        sb.append(", customerPsw=").append(customerPsw);
        sb.append(", enterContact=").append(enterContact);
        sb.append(", mophone=").append(mophone);
        sb.append(", qq=").append(qq);
        sb.append(", email=").append(email);
        sb.append(", business=").append(business);
        sb.append(", finance=").append(finance);
        sb.append(", customerService=").append(customerService);
        sb.append(", manager=").append(manager);
        sb.append(", price=").append(price);
        sb.append(", remark=").append(remark);
        sb.append(", contractNum=").append(contractNum);
        sb.append(", deposit=").append(deposit);
        sb.append(", filePath=").append(filePath);
        sb.append(", isabled=").append(isabled);
        sb.append(", createTime=").append(createTime);
        sb.append(", originPath=").append(originPath);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
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
        Customer other = (Customer) that;
        return (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCustomerGroupId() == null ? other.getCustomerGroupId() == null : this.getCustomerGroupId().equals(other.getCustomerGroupId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTelphone() == null ? other.getTelphone() == null : this.getTelphone().equals(other.getTelphone()))
            && (this.getCustomerAccount() == null ? other.getCustomerAccount() == null : this.getCustomerAccount().equals(other.getCustomerAccount()))
            && (this.getCustomerPsw() == null ? other.getCustomerPsw() == null : this.getCustomerPsw().equals(other.getCustomerPsw()))
            && (this.getEnterContact() == null ? other.getEnterContact() == null : this.getEnterContact().equals(other.getEnterContact()))
            && (this.getMophone() == null ? other.getMophone() == null : this.getMophone().equals(other.getMophone()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getBusiness() == null ? other.getBusiness() == null : this.getBusiness().equals(other.getBusiness()))
            && (this.getFinance() == null ? other.getFinance() == null : this.getFinance().equals(other.getFinance()))
            && (this.getCustomerService() == null ? other.getCustomerService() == null : this.getCustomerService().equals(other.getCustomerService()))
            && (this.getManager() == null ? other.getManager() == null : this.getManager().equals(other.getManager()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOriginPath() == null ? other.getOriginPath() == null : this.getOriginPath().equals(other.getOriginPath()));
    }

    /**
     *
     * @mbg.generated Tue Jun 12 16:23:59 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCustomerGroupId() == null) ? 0 : getCustomerGroupId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTelphone() == null) ? 0 : getTelphone().hashCode());
        result = prime * result + ((getCustomerAccount() == null) ? 0 : getCustomerAccount().hashCode());
        result = prime * result + ((getCustomerPsw() == null) ? 0 : getCustomerPsw().hashCode());
        result = prime * result + ((getEnterContact() == null) ? 0 : getEnterContact().hashCode());
        result = prime * result + ((getMophone() == null) ? 0 : getMophone().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getBusiness() == null) ? 0 : getBusiness().hashCode());
        result = prime * result + ((getFinance() == null) ? 0 : getFinance().hashCode());
        result = prime * result + ((getCustomerService() == null) ? 0 : getCustomerService().hashCode());
        result = prime * result + ((getManager() == null) ? 0 : getManager().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOriginPath() == null) ? 0 : getOriginPath().hashCode());
        return result;
    }
}