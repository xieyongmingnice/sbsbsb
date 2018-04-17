package com.xunyu.consume.service;

import com.commons.core.message.Result;
import com.xunyu.entity.User;
import com.xunyu.entity.UserInfo;
import com.xunyu.model.user.UserModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


public interface UserInfoService {


    /**
     * 根据用户id查询用户基础信息
     *
     * @param userId
     * @return
     */
    UserInfo queryByUserId(Long userId);

    /**
     * 获取用户集合
     */
    public long countUserInfo(Map<String, Object> map);

    List<UserInfo> listUser(Map<String, Object> map);

    /**
     * 批量添加用户信息
     */
    long insertUserInfo(UserInfo info);

    /**
     * 更新数据
     */
    long updateUserInfo(UserInfo info);

    /**
     * 删除数据
     */
    int deleteUserInfo(List<Long> ids);


}
