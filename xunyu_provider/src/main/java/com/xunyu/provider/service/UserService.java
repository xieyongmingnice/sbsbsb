package com.xunyu.provider.service;

import com.xunyu.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/11 15:13
 **/
public interface UserService {

    /**
     * 获取用户列表
     */
    public List<User> listUser(Map<String, Object> map);
}
