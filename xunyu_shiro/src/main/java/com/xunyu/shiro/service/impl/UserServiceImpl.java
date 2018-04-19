package com.xunyu.shiro.service.impl;

import com.xunyu.shiro.pojo.UserInfo;
import com.xunyu.shiro.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author dth
 * @date 2018/4/18 14:20
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfo getUserInfo(Map<String, Object> map) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("dth123");
        userInfo.setPwd("fcea920f7412b5da7be0cf42b8c93759");// e10adc3949ba59abbe56e057f20f883e
        return userInfo;
    }
}
