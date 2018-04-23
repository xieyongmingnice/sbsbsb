package com.xunyu.shiro.service.user;

import com.xunyu.shiro.pojo.user.User;

import java.util.Map;

/**
 * @author dth
 * @date 2018/4/18 14:20
 **/
public interface UserService {

    /**
     * 获取用户信息
     * @param map
     * @return
     */
    User getUserInfo(Map<String,Object> map);

    /**
     * 获取用户详情
     */
    User getUserDetail(Map<String,Object> map);

    /**
     * 修改用户信息
     */
    int updateUser(User user);

    /**
     * 添加用户信息
     */
    int addUser(User user);
}
