package com.xunyu.xunyu_department.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.user.DepartmentModel;
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

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
