package com.xunyu.crm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 用户分组视图类
 * @date 2018/4/25 15:14
 */
public class UserGroupVO implements Serializable {

    private static final long serialVersionUID = 4262157291539340628L;
    /**
     * 员工分组ID
     */
    private Long userGroupId;

    /**
     * 员工分组名称
     */
    private String userGroupName;

    /**
     *   是否可用标志
     *   0-不可用，1-可用
     */
    private Integer isabled;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 群组用户数
     */
    private Integer userGroupNumber;

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserGroupNumber() {
        return userGroupNumber;
    }

    public void setUserGroupNumber(Integer userGroupNumber) {
        this.userGroupNumber = userGroupNumber;
    }
}
