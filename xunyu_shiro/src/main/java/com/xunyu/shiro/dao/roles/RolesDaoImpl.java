package com.xunyu.shiro.dao.roles;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.shiro.pojo.roles.Roles;
import com.xunyu.shiro.pojo.roles.RolesUsersR;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/20 18:18
 **/
@Repository
public class RolesDaoImpl extends BaseDao<Roles, Long> {

    /**
     * 获取用户角色
     * @param map
     */
    public List<Roles> listRoles(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.shiro.pojo.roles.Roles.listRoles",map);
    }

    /**
     * 添加用户角色
     */
    public int addRoles(Roles rl){

        return super.insert("com.xunyu.shiro.pojo.roles.Roles.addRoles",rl);
    }

    /**
     * 修改用户角色
     */
    public int updateRoles(Roles rl){

        return super.update("com.xunyu.shiro.pojo.roles.Roles.updateRoles",rl);
    }

    /**
     * 删除角色
     */
    public int delRoles(Map<String,Object> map){

        return super.update("com.xunyu.shiro.pojo.roles.Roles.delRoles",map);
    }

    /**
     * 添加用户角色关联
     */
    public int addRolesUser(RolesUsersR rr){

        return super.insert("com.xunyu.shiro.pojo.roles.Roles.addRolesUser",rr);
    }

    public RolesDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<Roles> getClz() {
        return null;
    }
}
