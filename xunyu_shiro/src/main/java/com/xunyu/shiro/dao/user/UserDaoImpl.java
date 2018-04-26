package com.xunyu.shiro.dao.user;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.user.User;
import com.xunyu.shiro.pojo.user.UserAll;
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
     * 修改用户信息
     */
    public int updateUser(User user){

        return super.update("com.xunyu.shiro.pojo.user.UserAll.updateUser", user);
    }

    /**
     * 添加用户信息
     */
    public int addUser(User user){

       return super.insert("com.xunyu.shiro.pojo.user.UserAll.addUser", user);
    }

    /**
     * 获取用户详情
     */
    public UserAll getUserDetail(Map<String, Object> map){

        return super.selectForObject("com.xunyu.shiro.pojo.user.UserAll.getUserDetail",map);
    }

    /**
     * 获取用户信息
     */
    public User  getUserInfo(Map<String,Object> map){

        return super.selectForObject("com.xunyu.shiro.pojo.user.UserAll.getUserInfo",map);
    }

    /**
     * 获取用户列表
     */
    public List<User> listUser(Map<String, Object> map) {
        return super.selectForListObject("com.xunyu.shiro.pojo.user.UserAll.listUser", map);
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
