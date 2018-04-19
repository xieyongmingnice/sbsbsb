package com.xunyu.shiro.service;

import com.xunyu.shiro.pojo.UserInfo;

import java.util.Map;

/**
 * @author dth
 * @date 2018/4/18 14:20
 **/
public interface UserService {

    public UserInfo getUserInfo(Map<String,Object> map);
}
