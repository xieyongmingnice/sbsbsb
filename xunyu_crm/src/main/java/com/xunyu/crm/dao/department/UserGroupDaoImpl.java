package com.xunyu.crm.dao.department;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.department.UserGroup;
import com.xunyu.crm.vo.UserGroupVO;
import com.xunyu.model.department.UserGroupModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description 员工分组dao实现
 * @date 2018/4/25 15:17
 */
@Repository
public class UserGroupDaoImpl extends BaseDao {

    /**
     * 新增员工分组
     */
    public int addUserGroup(UserGroupModel model){
        return super.insert("com.xunyu.crm.pojo.department.UserGroup.addUserGroup",model);
    }
    /**
     * 修改员工分组信息
     */
    public int updateUserGroupInfo(UserGroupModel model){
        return super.update("com.xunyu.crm.pojo.department.UserGroup.updateUserGroupInfo",model);
    }
    /**
     * 删除员工分组信息
     */
    public int deleteUserGroup(UserGroupModel model){
        return super.delete("com.xunyu.crm.pojo.department.UserGroup.deleteUserGroup",model);
    }
    /**
     * 查询员工分组信息列表
     */
    public List<UserGroupVO> selectUserGroupList(UserGroupModel model){
        return super.selectList("com.xunyu.crm.pojo.department.UserGroup.selectUserGroupList",model);
    }
    /**
     * 批量删除员工分组信息
     */
    public int batchDeleteUserGroup(List<Long> idList){
        return super.delete("com.xunyu.crm.pojo.department.UserGroup.batchDeleteUserGroup",idList);
    }

    /**
     * 统计全部条数
     * @return
     */
    public Integer selectTotalRows(UserGroupModel model){
        return super.selectOne("com.xunyu.crm.pojo.department.UserGroup.selectTotalRows",model);
    }

    /**
     * 根据主键查询
     */
    public UserGroup selectByPrimaryKey(Long id){
        return super.selectOne("com.xunyu.crm.pojo.department.UserGroup.selectByPrimaryKey",id);
    }

    public UserGroupDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
