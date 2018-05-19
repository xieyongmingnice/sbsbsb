package com.xunyu.system.pojo.syspay;

import com.xunyu.model.user.UserModel;

/**
 * 系统支付配置状态
 */
public class SysPayState extends UserModel {

    private Long payStateId;//主键
    private Integer payState;//支付配置状态 1支付宝 2微信  3全部开启 4全部关闭
    private Long userId;//用户ID


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPayStateId() {
        return payStateId;
    }

    public void setPayStateId(Long payStateId) {
        this.payStateId = payStateId;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }
}
