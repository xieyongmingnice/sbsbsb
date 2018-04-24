package com.xunyu.shiro.pojo.user;

import com.xunyu.model.user.UserModel;
import com.xunyu.shiro.pojo.roles.RolesUsersR;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author  dth
 * 账号信息
 */
public class User extends UserModel implements Serializable {

    private static final long serialVersionUID = -3267918083809259248L;

    private Long userId;//用户ID

    private String account; //账号

    private String passWord; //密码

    private Integer userType;//账号类型 1-员工，2-客户

    private Integer isabled;//0-不可用，1-可用该账户是否可用，不可用时禁止登陆

    private Date userCreateTime;//创建时间

    private List<RolesUsersR> rolesUsersRList;//角色和用户关系表

    public List<RolesUsersR> getRolesUsersRList() {
        return rolesUsersRList;
    }

    public void setRolesUsersRList(List<RolesUsersR> rolesUsersRList) {
        this.rolesUsersRList = rolesUsersRList;
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
