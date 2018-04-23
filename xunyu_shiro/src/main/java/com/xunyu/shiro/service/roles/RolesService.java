package com.xunyu.shiro.service.roles;

import com.xunyu.shiro.pojo.roles.Roles;

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
}
