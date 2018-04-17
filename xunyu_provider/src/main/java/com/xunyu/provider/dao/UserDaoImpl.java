package com.xunyu.provider.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/11 15:08
 **/
@Repository
public class UserDaoImpl extends BaseDao<User, Long> {


    /**
     * 获取用户列表
     */
    public List<User> listUser(Map<String, Object> map) {
        return super.selectForListObject("com.xunyu.entity.User.listUser", map);
    }

    /**
     * 获取session工厂
     *
     * @param sqlSessionFactory
     */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<User> getClz() {
        return User.class;
    }


}
