package com.xunyu.consume.dao.User.impl;

import com.commons.core.dao.impl.BaseDao;
import com.commons.core.sql.dto.DataRecord;
import com.commons.core.util.JavaBeanMap;
import com.xunyu.consume.dao.User.UserInfoDao;
import com.xunyu.consume.pojo.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo, Long> implements UserInfoDao {

    @Autowired
    public UserInfoDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<UserInfo> getClz() {
        return UserInfo.class;
    }


    @Override
    public UserInfo queryByUserId(Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        DataRecord dataRecord = super.selectForDataRecord("com.xunyu.entity.UserInfo.queryByUserId", map);
        UserInfo userInfo = (UserInfo) JavaBeanMap.convertMap2JavaBean(dataRecord, UserInfo.class);
        return userInfo;
    }

    @Override
    public long countUserInfo(Map<String, Object> map) {
        long total = super.selectForObject("com.xunyu.entity.UserInfo.countUserInfo", map);

        return total;
    }

    @Override
    public List<UserInfo> listUser(Map<String, Object> map) {
        List<UserInfo> listInfo = super.selectForListObject("com.xunyu.entity.UserInfo.listUser", map);
        if (listInfo != null) {
            return listInfo;
        } else {
            return null;
        }
    }

    @Override
    public long insertUserInfo(UserInfo info) {
        return super.insert("com.xunyu.entity.UserInfo.insertUserInfo", info);
    }

    @Override
    public long updateUserInfo(UserInfo info) {
        return super.update("com.xunyu.entity.UserInfo.updateUserInfo", info);
    }

    @Override
    public int deleteUserInfo(List<Long> ids) {
        return super.delete("com.xunyu.entity.UserInfo.deleteUserInfo", ids);
    }

}
