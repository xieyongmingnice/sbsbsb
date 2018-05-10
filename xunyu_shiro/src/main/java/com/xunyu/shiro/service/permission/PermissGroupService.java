package com.xunyu.shiro.service.permission;

import com.xunyu.shiro.pojo.permission.PermissionGroup;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/10 9:53
 **/
public interface PermissGroupService {

    /**
     * 添加权限分组
     */
    int addPermissGroup(PermissionGroup pg);

    /**
     * 修改权限分组
     */
    int updatePermissionGroup(PermissionGroup pg);

    /**
     * 权限分组列表
     */
    List<PermissionGroup>  permissGroupList(Map<String,Object> map);

    /**
     * 权限分组详情
     */
    PermissionGroup getPermissGroup(Map<String,Object> map);
}
