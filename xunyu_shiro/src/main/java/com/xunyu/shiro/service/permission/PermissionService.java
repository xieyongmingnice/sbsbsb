package com.xunyu.shiro.service.permission;

import com.xunyu.shiro.pojo.permission.Permissions;
import com.xunyu.shiro.pojo.permission.RolesPermissionsR;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/9 18:02
 **/
public interface PermissionService {

    /**
     * 添加权限
     */
    int addPermission(Permissions p);

    /**
     * 修改权限
     */
    int updatePermission(Permissions p);

    /**
     * 删除
     */
    int delPerminssion(String ids);

    /**
     * 获取权限列表
     */
    List<Permissions> permissionsList(Map<String,Object> map);

    /**
     * 添加角色权限关联
     */
    int addRolesPer(RolesPermissionsR r);
}
