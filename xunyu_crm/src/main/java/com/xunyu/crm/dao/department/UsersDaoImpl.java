package com.xunyu.crm.dao.department;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.department.Users;
import com.xunyu.crm.vo.UsersVO;
import com.xunyu.model.department.DepartmentModel;
import com.xunyu.model.department.UserGroupModel;
import com.xunyu.model.department.UsersModel;
import com.xunyu.model.user.UserModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 用户 dao实现
 * @date 2018/4/25 10:37
 */
@Repository
public class UsersDaoImpl extends BaseDao {

    /**
     * 通过deparmentId查询员工列表
     * @param model
     */
    public List<UsersVO> selectUserListByDepartmentId(DepartmentModel model){
        return super.selectList("com.xunyu.crm.pojo.department.Users.selectUserListByDepartmentId",model);
    }

    /**
     * 通过员工分组id查询员工列表
     * @param model
     * @return
     */
    public List<UsersVO> selectUserListByUserGroupId(UserGroupModel model){
        return super.selectList("com.xunyu.crm.pojo.department.Users.selectUserListByUserGroupId",model);
    }
    public int addUser(UsersModel model){
        return super.insert("com.xunyu.crm.pojo.department.Users.addUser",model);
    }

    public int updateUserInfo(UsersModel model){
        return super.insert("com.xunyu.crm.pojo.department.Users.updateUserInfo",model);
    }

    public int deleteUser(UsersModel model){
        return super.insert("com.xunyu.crm.pojo.department.Users.deleteUser",model);
    }

    public List<UsersVO> selectUserList(UsersModel model){
        return super.selectList("com.xunyu.crm.pojo.department.Users.selectUserList",model);
    }

    public int batchDeleteUser(List<Long> idList){
        return super.insert("com.xunyu.crm.pojo.department.Users.batchDeleteUser",idList);
    }

    public List<Users> selectUserByAccount(UsersModel model){
        return super.selectList("com.xunyu.crm.pojo.department.Users.selectUserByAccount",model);
    }

    public Integer selectTotalRows(UserModel model){
        if (model instanceof DepartmentModel){
            super.selectOne("com.xunyu.crm.pojo.department.Users.selectTotalRowsByDepartmentId",model) ;
        } else if (model instanceof UserGroupModel){
            return super.selectOne("com.xunyu.crm.pojo.department.Users.selectTotalRowsByGroupId",model) ;
        }else if (model instanceof UsersModel){
            return super.selectOne("com.xunyu.crm.pojo.department.Users.selectTotalRows",model);
        }
        return 0;
    }

    public Users selectByPrimaryKey(UserModel model){
        return super.selectOne("com.xunyu.crm.pojo.department.Users.selectByPrimaryKey",model);
    }

    public UsersDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
