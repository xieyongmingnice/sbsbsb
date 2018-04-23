package com.xunyu.shiro.service.roles;

import com.xunyu.shiro.dao.roles.RolesDaoImpl;
import com.xunyu.shiro.pojo.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/20 18:17
 **/
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    RolesDaoImpl rolesDaoImpl;


    @Override
    public List<Roles> listRoles(Map<String, Object> map) {
        return rolesDaoImpl.listRoles(map);
    }
}
