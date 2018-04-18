package com.xunyu.consume.service;
import com.xunyu.consume.pojo.UserInfo;
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
    long countUserInfo(Map<String, Object> map);

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
