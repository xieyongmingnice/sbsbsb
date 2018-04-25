package com.xunyu.xunyu_department.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 员工分组实体类
 * @date 2018/4/25 14:45
 */
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1079259782336957778L;
    /**
     *
     * 员工分组ID
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    private Long userGroupId;

    /**
     *
     * 员工分组名称
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    private String userGroupName;

    /**
     *
     *   是否可用标志
     *   0-不可用，1-可用
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    private Integer isabled;

    /**
     *
     * 备注
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    private String remark;

    /**
     *
     * 创建时间
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    private Date createTime;



    /**
     * This method returns the value of the database column tbl_user_group.user_group_id
     *
     * @return the value of tbl_user_group.user_group_id
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public Long getUserGroupId() {
        return userGroupId;
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public UserGroup withUserGroupId(Long userGroupId) {
        this.setUserGroupId(userGroupId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_user_group.user_group_id
     *
     * @param userGroupId the value for tbl_user_group.user_group_id
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    /**
     * This method returns the value of the database column tbl_user_group.user_group_name
     *
     * @return the value of tbl_user_group.user_group_name
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public String getUserGroupName() {
        return userGroupName;
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public UserGroup withUserGroupName(String userGroupName) {
        this.setUserGroupName(userGroupName);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_user_group.user_group_name
     *
     * @param userGroupName the value for tbl_user_group.user_group_name
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    /**
     * This method returns the value of the database column tbl_user_group.isabled
     *
     * @return the value of tbl_user_group.isabled
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public UserGroup withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_user_group.isabled
     *
     * @param isabled the value for tbl_user_group.isabled
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_user_group.remark
     *
     * @return the value of tbl_user_group.remark
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public UserGroup withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_user_group.remark
     *
     * @param remark the value for tbl_user_group.remark
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column tbl_user_group.create_time
     *
     * @return the value of tbl_user_group.create_time
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public UserGroup withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_user_group.create_time
     *
     * @param createTime the value for tbl_user_group.create_time
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userGroupId=").append(userGroupId);
        sb.append(", userGroupName=").append(userGroupName);
        sb.append(", isabled=").append(isabled);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserGroup other = (UserGroup) that;
        return (this.getUserGroupId() == null ? other.getUserGroupId() == null : this.getUserGroupId().equals(other.getUserGroupId()))
            && (this.getUserGroupName() == null ? other.getUserGroupName() == null : this.getUserGroupName().equals(other.getUserGroupName()))
            && (this.getIsabled() == null ? other.getIsabled() == null : this.getIsabled().equals(other.getIsabled()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     *
     * @mbg.generated Wed Apr 25 14:43:51 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserGroupId() == null) ? 0 : getUserGroupId().hashCode());
        result = prime * result + ((getUserGroupName() == null) ? 0 : getUserGroupName().hashCode());
        result = prime * result + ((getIsabled() == null) ? 0 : getIsabled().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}