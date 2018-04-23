package com.xunyu.shiro.dao.roles;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.shiro.pojo.roles.Roles;
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

    public RolesDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<Roles> getClz() {
        return null;
    }
}
