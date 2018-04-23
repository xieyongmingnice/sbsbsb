package com.xunyu.shiro.service.user;

import com.xunyu.shiro.dao.user.UserDaoImpl;
import com.xunyu.shiro.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/18 14:20
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public User getUserInfo(Map<String, Object> map) {

        return userDaoImpl.getUserInfo(map);
    }

    @Override
    public User getUserDetail(Map<String, Object> map) {
        return userDaoImpl.getUserDetail(map);
    }

    @Override
    public int updateUser(User user) {
        return userDaoImpl.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userDaoImpl.addUser(user);
    }
}
