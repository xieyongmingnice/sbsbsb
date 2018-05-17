package com.xunyu.crm.dao.customer.user;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.customer.CustomerUseraccount;
import com.xunyu.model.user.User;
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

        return super.update("com.xunyu.model.user.User.updateUser", user);
    }

    /**
     * 添加用户信息
     */
    public int addUser(User user){

       return super.insert("com.xunyu.model.user.User.addUser", user);
    }

    /**
     * 添加中间表信息
     */
    public int addCustomerUseraccount(CustomerUseraccount cu){

        return super.insert("com.xunyu.model.user.User.addCustomerUseraccount", cu);
    }

    /**
     * 获取账号信息
     */
    public User getUserByAccount(Map<String,Object> map){
        return super.selectForObject("com.xunyu.model.user.User.getUserByAccount",map);
    }
    /**
     * 批量删除用户表的客户账号
     */
    public int delUser(Map<String,Object> map){

        return super.update("com.xunyu.model.user.User.delUser",map);
    }
    /**
     * 通过客户id获取用户id
     */
    public List<User> getUserIdByCustomerIds(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.model.user.User.getUserIdByCustomerIds",map);
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
