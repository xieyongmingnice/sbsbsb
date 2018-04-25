package com.xunyu.xunyu_department.vo;

import java.util.Date;

/**
 * @author xym
 * @description  员工VO
 * @date 2018/4/25 10:53
 */
public class UsersVO {
    /**
     * 流水id
     */
    private long  userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户类型
     */
    private String userType;
    /**
     *
     */
    private int isabled;
    /**
     *
     */
    private Date createTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getIsabled() {
        return isabled;
    }

    public void setIsabled(int isAbled) {
        this.isabled = isAbled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}