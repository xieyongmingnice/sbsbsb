package com.xunyu.xunyu_department.service;

import com.xunyu.model.department.UserGroupModel;
import com.xunyu.xunyu_department.vo.UserGroupVO;

import java.util.List;

/**
 * @author xym
 * @description 员工分组service接口
 * @date 2018/4/25 15:08
 */
public interface UserGroupService {

    /**
     * 新增员工分组
     */
    int addUserGroup(UserGroupModel model);
    /**
     * 修改员工分组信息
     */
    int updateUserGroupInfo(UserGroupModel model);
    /**
     * 删除员工分组信息
     */
    int deleteUserGroup(UserGroupModel model);
    /**
     * 查询员工分组信息列表
     */
    List<UserGroupVO> selectUserGroupList(UserGroupModel model);
    /**
     * 批量删除员工分组信息
     */
    int batchDeleteUserGroup(List<Long> idList);
    /**
     * 查询员工分组总条数
     */
    Integer selectTotalRows(UserGroupModel model);
}
