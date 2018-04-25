package com.xunyu.xunyu_department.service.impl;

import com.xunyu.model.department.DepartmentModel;
import com.xunyu.model.users.UsersModel;
import com.xunyu.xunyu_department.dao.UserDaoImpl;
import com.xunyu.xunyu_department.pojo.Users;
import com.xunyu.xunyu_department.service.UserService;
import com.xunyu.xunyu_department.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl dao;
    @Override
    public List<UsersVO> selectUserListByDepartmentId(DepartmentModel model) {
        return dao.selectUserListByDepartmentId(model);
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
}
