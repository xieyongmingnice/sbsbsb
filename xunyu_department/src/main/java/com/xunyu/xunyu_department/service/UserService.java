package com.xunyu.xunyu_department.service;

import com.xunyu.model.department.DepartmentModel;
import com.xunyu.xunyu_department.vo.UsersVO;

import java.util.List;

/**
 * @author xym
 * @description 员工service
 * @date 2018/4/25 10:35
 */
public interface UserService {

    /**
     * 通过部门id查询userList
     * @param model
     * @return
     */
    List<UsersVO> selectUserListByDepartmentId(DepartmentModel model);

}
