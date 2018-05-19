package com.xunyu.system.pojo.syspay;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/4/27 10:36
 **/
public class SysPay extends UserModel {

    private Long payId;//主键id
    private Integer isabled;//1未删除 0删除
    private Date createTime;//创建时间
    private String payName;//支付名称
    private String merchantName;//商户名称
    private String payAccount;//支付账号
    private String payPid;//支付pid
    private String payKey;//支付key
    private String payText;//支付描述
    private Long userId; //当前登录用户id
    private Integer payType;//1支付宝  2微信  3其它

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
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

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayPid() {
        return payPid;
    }

    public void setPayPid(String payPid) {
        this.payPid = payPid;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public String getPayText() {
        return payText;
    }

    public void setPayText(String payText) {
        this.payText = payText;
    }

}
