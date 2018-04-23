package com.xunyu.shiro.pojo.permission;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dth
 * @date 2018/4/20 17:34
 * 权限分组
 **/
public class PermissionGroup implements Serializable {


    private static final long serialVersionUID = 1295548618257230440L;

    private Long permissionGroupId;
    private String permissionGroupName;//权限分组名称
    private String remark;//备注
    private Integer isabled;//1有效  0无效
    private Date permisGroupCreateTime;//创建时间

    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getPermissionGroupName() {
        return permissionGroupName;
    }

    public void setPermissionGroupName(String permissionGroupName) {
        this.permissionGroupName = permissionGroupName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getPermisGroupCreateTime() {
        return permisGroupCreateTime;
    }

    public void setPermisGroupCreateTime(Date permisGroupCreateTime) {
        this.permisGroupCreateTime = permisGroupCreateTime;
    }
}
