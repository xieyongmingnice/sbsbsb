package com.xunyu.shiro.service.permission;

import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.shiro.dao.permission.PermissionDaoImpl;
import com.xunyu.shiro.pojo.permission.Permissions;
import com.xunyu.shiro.pojo.permission.RolesPermissionsR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/9 18:04
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDaoImpl permissionDaoImpl;

    @Override
    public int addPermission(Permissions p) {
        return permissionDaoImpl.addPermission(p);
    }

    @Override
    public int updatePermission(Permissions p) {
        return permissionDaoImpl.updatePermission(p);
    }

    @Override
    public int delPerminssion(String ids) {
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
            n = permissionDaoImpl.delPerminssion(map);
        }
        return n;
    }

    @Override
    public List<Permissions> permissionsList(Map<String, Object> map) {
        return permissionDaoImpl.permissionsList(map);
    }

    @Override
    public int addRolesPer(RolesPermissionsR r) {
        return permissionDaoImpl.addRolesPer(r);
    }
}
