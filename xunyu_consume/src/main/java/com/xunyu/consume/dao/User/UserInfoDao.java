package com.xunyu.consume.dao.User;

import com.commons.core.dao.IBaseDao;
import com.xunyu.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by xc.xiong on 2017/9/5.
 */
@Component
public interface UserInfoDao extends IBaseDao<UserInfo, Long> {

    /**
     * 获取用户详情
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
