package com.xunyu.model.users;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 用户、员工 参数实体类
 * @date 2018/4/25 17:10
 */
public class UsersModel extends UserModel {
    private static final long serialVersionUID = 284661741673633051L;

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
    private int userType;
    /**
     * 可用状态标签 1可用  0不可用
     */
    private int isabled;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 批量操作时用的主键id集合
     */
    private List<Long> idList;

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

    public void setIsabled(int isabled) {
        this.isabled = isabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
