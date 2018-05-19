package com.xunyu.model.system.syspay;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/4/27 11:42
 **/
public class SysPayModel extends UserModel {

    private String payType;//1支付宝  2微信  3其它

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
