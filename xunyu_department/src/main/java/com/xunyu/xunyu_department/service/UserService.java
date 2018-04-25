package com.xunyu.xunyu_department.service;

import com.xunyu.model.department.DepartmentModel;
import com.xunyu.model.user.UserModel;
import com.xunyu.model.users.UsersModel;
import com.xunyu.xunyu_department.pojo.Users;
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

    /**
     * 新增员工
     * @param model
     * @return
     */
    int addUser(UsersModel model);

    /**
     * 修改员工信息
     * @param model
     * @return
     */
    int updateUserInfo(UsersModel model);

    /**
     * 删除员工
     * @param model
     * @return
     */
    int deleteUser(UsersModel model);

    /**
     * 查询员工列表
     * @param model
     * @return
     */
    List<UsersVO> selectUserList(UsersModel model);

    /**
     * 批量删除员工
     * @param idList
     * @return
     */
    int batchDeleteUser(List<Long> idList);

    /**
     *
     */
    List<Users> selectUserListByAccount(UsersModel model);
}
