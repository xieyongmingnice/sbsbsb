package com.xunyu.shiro.service.roles;

import com.xunyu.shiro.pojo.roles.Roles;
import com.xunyu.shiro.pojo.roles.RolesUsersR;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/20 18:16
 **/
public interface RolesService {

    /**
     * 获取用户的角色
     */
   List<Roles> listRoles(Map<String,Object> map);

    /**
     * 添加用户角色
     */
    int addRoles(Roles rl);

    /**
     * 修改用户角色
     */
    int updateRoles(Roles rl);

    /**
     * 删除角色
     */
    int delRoles(String ids);

    /**
     * 添加用户角色关联
     */
    int addRolesUser(RolesUsersR rr);

}
