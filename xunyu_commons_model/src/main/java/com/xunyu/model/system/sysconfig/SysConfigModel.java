package com.xunyu.model.system.sysconfig;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/4/26 17:40
 **/
public class SysConfigModel extends UserModel {

    private Long sysId;//主键id
    private Long userId;//当前登录用户id

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
