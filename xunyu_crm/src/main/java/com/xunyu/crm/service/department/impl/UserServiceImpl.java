package com.xunyu.crm.service.department.impl;

import com.xunyu.crm.dao.department.UsersDaoImpl;
import com.xunyu.crm.pojo.department.Users;
import com.xunyu.crm.service.department.UserService;
import com.xunyu.crm.vo.UsersVO;
import com.xunyu.model.department.DepartmentModel;
import com.xunyu.model.department.UserGroupModel;
import com.xunyu.model.department.UsersModel;
import com.xunyu.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDaoImpl dao;
    @Override
    public List<UsersVO> selectUserListByDepartmentId(DepartmentModel model) {
        return dao.selectUserListByDepartmentId(model);
    }

    @Override
    public List<UsersVO> selectUserListByUserGroupId(UserGroupModel model) {
        return dao.selectUserListByUserGroupId(model);
    }

    @Override
    public int addUser(UsersModel model) {
        return dao.addUser(model);
    }

    @Override
    public int updateUserInfo(UsersModel model) {
        return dao.updateUserInfo(model);
    }

    @Override
    public int deleteUser(UsersModel model) {
        return dao.deleteUser(model);
    }

    @Override
    public List<UsersVO> selectUserList(UsersModel model) {
        return dao.selectUserList(model);
    }

    @Override
    public int batchDeleteUser(List<Long> idList) {
        return dao.batchDeleteUser(idList);
    }

    @Override
    public List<Users> selectUserListByAccount(UsersModel model) {
        return dao.selectUserByAccount(model);
    }

    @Override
    public Integer selectTotalRows(UserModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public Users selectByPrimaryKey(UserModel model) {
        return dao.selectByPrimaryKey(model);
    }
}
