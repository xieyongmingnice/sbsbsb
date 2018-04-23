package com.xunyu.shiro.pojo.roles;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/20 17:52
 * 角色用户关系表
 **/
public class RolesUsersR implements Serializable {
    private static final long serialVersionUID = -5140875667303015606L;

    private Long roleUserRId;
    private Long roleId;//角色ID
    private Long userId;//用户ID
    private Roles roles;//角色

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Long getRoleUserRId() {
        return roleUserRId;
    }

    public void setRoleUserRId(Long roleUserRId) {
        this.roleUserRId = roleUserRId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
