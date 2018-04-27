package com.xunyu.xunyu_department.service.impl;

import com.xunyu.model.department.UserGroupModel;
import com.xunyu.xunyu_department.dao.UserGroupDaoImpl;
import com.xunyu.xunyu_department.service.UserGroupService;
import com.xunyu.xunyu_department.vo.UserGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author xym
 * @description 员工分组service实现
 * @date 2018/4/25 15:16
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    UserGroupDaoImpl userGroupDao;

    @Override
    public int addUserGroup(UserGroupModel model) {
        return userGroupDao.addUserGroup(model);
    }

    @Override
    public int updateUserGroupInfo(UserGroupModel model) {
        return userGroupDao.updateUserGroupInfo(model);
    }

    @Override
    public int deleteUserGroup(UserGroupModel model) {
        return userGroupDao.deleteUserGroup(model);
    }

    @Override
    public List<UserGroupVO> selectUserGroupList(UserGroupModel model) {
        return userGroupDao.selectUserGroupList(model);
    }

    @Override
    public int batchDeleteUserGroup(List<Long> idList) {
        return userGroupDao.batchDeleteUserGroup(idList);
    }

    @Override
    public Integer selectTotalRows(UserGroupModel model) {
        return userGroupDao.selectTotalRows(model);
    }
}
