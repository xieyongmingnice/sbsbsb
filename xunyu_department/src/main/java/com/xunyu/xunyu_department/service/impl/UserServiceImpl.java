package com.xunyu.xunyu_department.service.impl;

import com.xunyu.model.user.DepartmentModel;
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
}
