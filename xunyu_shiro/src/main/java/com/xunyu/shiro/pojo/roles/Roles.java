package com.xunyu.shiro.pojo.roles;

import com.xunyu.shiro.pojo.permission.RolesPermissionsR;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author dth
 * @date 2018/4/20 17:49
 * 角色
 **/
public class Roles implements Serializable {
    private static final long serialVersionUID = 7083351093581201852L;

    private Long roleId;
    private String roleName;//角色名称
    private Integer isabled; //0-不可用，1-可用，不可用时，不允许被查询出来
    private String remark;//备注
    private Date rolesCreateTime;//创建时间
    private List<RolesPermissionsR> rolesPermissionsRList;//角色和权限的关系表

    public List<RolesPermissionsR> getRolesPermissionsRList() {
        return rolesPermissionsRList;
    }

    public void setRolesPermissionsRList(List<RolesPermissionsR> rolesPermissionsRList) {
        this.rolesPermissionsRList = rolesPermissionsRList;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Date getRolesCreateTime() {
        return rolesCreateTime;
    }

    public void setRolesCreateTime(Date rolesCreateTime) {
        this.rolesCreateTime = rolesCreateTime;
    }
}
