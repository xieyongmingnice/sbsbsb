package com.xunyu.shiro.dao.permission;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.shiro.pojo.permission.Permissions;
import com.xunyu.shiro.pojo.permission.RolesPermissionsR;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/9 18:05
 **/
@Repository
public class PermissionDaoImpl extends BaseDao<Permissions,Long> {

    /**
     * 添加权限
     */
    public int addPermission(Permissions p){

        return super.insert("com.xunyu.shiro.pojo.permission.Permissions.addPermission",p);
    }

    /**
     * 修改权限
     */
    public int updatePermission(Permissions p){

        return super.update("com.xunyu.shiro.pojo.permission.Permissions.updatePermission",p);
    }

    /**
     * 删除
     */
    public int delPerminssion(Map<String,Object> map){

        return super.update("com.xunyu.shiro.pojo.permission.Permissions.delPerminssion",map);
    }

    /**
     * 获取权限列表
     */
    public List<Permissions> permissionsList(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.shiro.pojo.permission.Permissions.permissionsList",map);
    }

    /**
     * 添加角色权限关联
     */
    int addRolesPer(RolesPermissionsR r){

        return super.insert("com.xunyu.shiro.pojo.permission.Permissions.addRolesPer",r);
    }

    public PermissionDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<Permissions> getClz() {
        return Permissions.class;
    }
}
