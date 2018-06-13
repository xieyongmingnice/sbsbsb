package com.xunyu.crm.pojo.department;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 员工用户
 * @date 2018/4/20 18:02
 */
public class Users implements Serializable{
    private static final long serialVersionUID = 8471439465791691291L;
    /**
     * 员工id
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
    private int userType;
    /**
     * 可用状态标签 1：可用，0：不可用
     */
    private int isabled;
    /**
     * 创建时间
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
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
