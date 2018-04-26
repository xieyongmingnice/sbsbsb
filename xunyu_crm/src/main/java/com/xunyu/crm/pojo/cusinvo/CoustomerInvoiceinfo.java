package com.xunyu.crm.pojo.cusinvo;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/4/26 15:22
 * 客户发票信息抬头表
 **/
public class CoustomerInvoiceinfo extends UserModel {

    private Long invoiceinfoId;//主键
    private Long customerId;//客户id
    private String companyName;//公司名称
    private String taxNum;//税号
    private String bankname;//开户银行
    private String bankaccount;//银行账户
    private String address;//单位地址
    private String telphone;//电话号码
    private Date createTime;//创建时间

    public Long getInvoiceinfoId() {
        return invoiceinfoId;
    }

    public void setInvoiceinfoId(Long invoiceinfoId) {
        this.invoiceinfoId = invoiceinfoId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
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
