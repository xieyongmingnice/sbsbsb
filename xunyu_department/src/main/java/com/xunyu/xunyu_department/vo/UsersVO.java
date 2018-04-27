package com.xunyu.xunyu_department.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description  员工VO
 * @date 2018/4/25 10:53
 */
public class UsersVO implements Serializable{
    private static final long serialVersionUID = 6068165852947723583L;
    /**
     * 员工id
     */
    private Long  userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型 1-员工 ，2-用户
     */
    private Integer userType;

    /**
     * 可用状态
     */
    private Integer isabled;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户类型 字符串：员工 ，用户
     */
    private String userTypeStr;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserTypeStr() {
        return userTypeStr;
    }

    public void setUserTypeStr(String userTypeStr) {
        this.userTypeStr = userTypeStr;
    }
}
