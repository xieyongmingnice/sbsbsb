package com.xunyu.shiro.service.roles;

import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.shiro.dao.roles.RolesDaoImpl;
import com.xunyu.shiro.pojo.roles.Roles;
import com.xunyu.shiro.pojo.roles.RolesUsersR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/20 18:17
 **/
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDaoImpl rolesDaoImpl;


    @Override
    public List<Roles> listRoles(Map<String, Object> map) {
        return rolesDaoImpl.listRoles(map);
    }

    @Override
    public int addRoles(Roles rl) {
        return rolesDaoImpl.addRoles(rl);
    }

    @Override
    public int updateRoles(Roles rl) {
        return rolesDaoImpl.updateRoles(rl);
    }

    @Override
    public int delRoles(String ids) {
        int n = 0;
        if (StringUtils2.isNotEmpty(ids)) {

            Map<String, Object> map = new HashMap<String, Object>();
            String[] idsDir = ids.split(",");
            String[] array = new String[idsDir.length];
            for (int i = 0; i < idsDir.length; i++) {
                if (RandomUtils.isInteger(idsDir[i])) {
                    array[i] = idsDir[i];

                } else {
                    continue;
                }
            }
            map.put("isabled", 0);
            map.put("array", array);
            n = rolesDaoImpl.delRoles(map);
        }
        return n;
    }

    @Override
    public int addRolesUser(RolesUsersR rr) {
        return rolesDaoImpl.addRolesUser(rr);
    }

}
