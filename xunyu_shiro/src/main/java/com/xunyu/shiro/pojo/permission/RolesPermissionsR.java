package com.xunyu.shiro.pojo.permission;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/20 17:45
 * 角色权限对照表
 **/
public class RolesPermissionsR implements Serializable {

    private static final long serialVersionUID = -5273379498271373482L;

    private Long rolesPermissionRId;
    private Long roleId;//角色ID
    private Long permissionId;//权限ID
    private Permissions permissions;//权限

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public Long getRolesPermissionRId() {
        return rolesPermissionRId;
    }

    public void setRolesPermissionRId(Long rolesPermissionRId) {
        this.rolesPermissionRId = rolesPermissionRId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
