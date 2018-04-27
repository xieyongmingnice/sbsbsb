package com.xunyu.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author  dth
 * 用户信息(用于用户登录)
 *
 */
public class User implements Serializable {


    private static final long serialVersionUID = 5214167894101236574L;

    private Long userId;//用户ID

    private String account; //账号

    private String passWord; //密码

    private Integer userType;//账号类型 1-员工，2-客户

    private Integer isabled;//0-不可用，1-可用该账户是否可用，不可用时禁止登陆

    private Date userCreateTime;//创建时间

    private String SessionId;


    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }
}
