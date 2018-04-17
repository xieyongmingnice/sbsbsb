package com.xunyu.provider.service;

import com.xunyu.entity.User;
import com.xunyu.provider.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/11 15:15
 **/
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入dao层
     *
     * @param map
     * @return
     */
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public List<User> listUser(Map<String, Object> map) {
        return userDao.listUser(map);
    }
}
