package com.xunyu.consume.service.impl;

import com.commons.core.message.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xunyu.consume.dao.User.UserInfoDao;
import com.xunyu.consume.service.UserInfoService;
import com.xunyu.entity.User;
import com.xunyu.entity.UserInfo;
import com.xunyu.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
//@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 跨服务获取数据
     */
    public Result<List<User>> listUserOther(UserModel userModel) {

        System.out.println("我进来了。。。");
        return listUserOther(userModel);
    }

    @Override
    public UserInfo queryByUserId(Long userId) {
        return userInfoDao.queryByUserId(userId);
    }

    @Override
    public long countUserInfo(Map<String, Object> map) {
        return userInfoDao.countUserInfo(map);
    }

    @Override
    public List<UserInfo> listUser(Map<String, Object> map) {
        return userInfoDao.listUser(map);
    }

    @Override
    @HystrixCommand(fallbackMethod = "errorHandler")
    public long insertUserInfo(UserInfo info) {
        return this.userInfoDao.insertUserInfo(info);
    }

    @Override
    public long updateUserInfo(UserInfo info) {
        return userInfoDao.updateUserInfo(info);
    }

    @Override
    public int deleteUserInfo(List<Long> ids) {
        return userInfoDao.deleteUserInfo(ids);
    }

    public String errorHandler() {
        String msg = "网络延迟请稍等...";
        return msg;
    }

}
