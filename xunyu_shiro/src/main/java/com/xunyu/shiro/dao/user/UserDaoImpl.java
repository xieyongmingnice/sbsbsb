package com.xunyu.shiro.dao.user;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.shiro.pojo.user.User;
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
     * 获取用户详情
     */
    public User getUserDetail(Map<String, Object> map){

        return super.selectOne("com.xunyu.shiro.pojo.user.User.getUserDetail",map);
    }

    /**
     * 获取用户信息
     */
    public User getUserInfo(Map<String,Object> map){

        return super.selectOne("com.xunyu.shiro.pojo.user.User.getUserInfo",map);
    }

    /**
     * 获取用户列表
     */
    public List<User> listUser(Map<String, Object> map) {
        return super.selectForListObject("com.xunyu.shiro.pojo.user.User.listUser", map);
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
