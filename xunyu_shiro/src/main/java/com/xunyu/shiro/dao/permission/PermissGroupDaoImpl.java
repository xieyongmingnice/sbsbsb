package com.xunyu.shiro.dao.permission;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.shiro.pojo.permission.PermissionGroup;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/10 9:56
 **/
public class PermissGroupDaoImpl extends BaseDao<PermissionGroup,Long> {

    /**
     * 添加权限分组
     */
    public int addPermissGroup(PermissionGroup pg){

        return super.insert("com.xunyu.shiro.pojo.permission.PermissionGroup.addPermissGroup",pg);
    }

    /**
     * 修改权限分组
     */
    public int updatePermissionGroup(PermissionGroup pg){

        return super.update("com.xunyu.shiro.pojo.permission.PermissionGroup.updatePermissionGroup",pg);
    }

    /**
     * 权限分组列表
     */
    public List<PermissionGroup> permissGroupList(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.shiro.pojo.permission.PermissionGroup.permissGroupList",map);
    }

    /**
     * 权限分组详情
     */
    public PermissionGroup getPermissGroup(Map<String,Object> map){

        return super.selectForObject("com.xunyu.shiro.pojo.permission.PermissionGroup.getPermissGroup",map);
    }


    public PermissGroupDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<PermissionGroup> getClz() {
        return PermissionGroup.class;
    }
}
