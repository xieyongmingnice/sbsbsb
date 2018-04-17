package com.xunyu.provider.pojo;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/11 15:07
 **/
public class User implements Serializable {
    private static final long serialVersionUID = -2238653690138272255L;

    private Long userId;
    private String userName;//用户名

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
