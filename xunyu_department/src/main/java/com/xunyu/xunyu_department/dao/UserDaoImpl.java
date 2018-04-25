package com.xunyu.xunyu_department.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.department.DepartmentModel;
import com.xunyu.model.users.UsersModel;
import com.xunyu.xunyu_department.pojo.Users;
import com.xunyu.xunyu_department.vo.UsersVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 用户 dao实现
 * @date 2018/4/25 10:37
 */
@Repository
public class UserDaoImpl extends BaseDao {

    /**
     * 通过deparmentId查询员工列表
     * @param model
     */
    public List<UsersVO> selectUserListByDepartmentId(DepartmentModel model){
        return super.selectList("com.xunyu.xunyu_department.pojo.Users.selectUserListByDepartmentId",model);
    }

    public int addUser(UsersModel model){
        return super.insert("com.xunyu.xunyu_department.pojo.Users.addUser",model);
    }

    public int updateUserInfo(UsersModel model){
        return super.insert("com.xunyu.xunyu_department.pojo.Users.updateUserInfo",model);
    }

    public int deleteUser(UsersModel model){
        return super.insert("com.xunyu.xunyu_department.pojo.Users.deleteUser",model);
    }

    public List<UsersVO> selectUserList(UsersModel model){
        return super.selectList("com.xunyu.xunyu_department.pojo.Users.selectUserList",model);
    }

    public int batchDeleteUser(List<Long> idList){
        return super.insert("com.xunyu.xunyu_department.pojo.Users.batchDeleteUser",idList);
    }

    public List<Users> selectUserByAccount(UsersModel model){
        return super.selectList("com.xunyu.xunyu_department.pojo.Users.selectUserByAccount",model);
    }

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
