package com.xunyu.crm.dao.department;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.department.Department;
import com.xunyu.model.department.DepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xym
 * @description
 * @date 2018/4/23 18:29
 */
@Repository
public class DepartmentDaoImpl extends BaseDao{


    public int addDepartment(Department department) {
        return super.insert("com.xunyu.crm.pojo.department.Department.addDepartment",department);
    }

    public int updateDepartmentInfo(Department department) {
        return super.update("com.xunyu.crm.pojo.department.Department.updateDepartmentInfo",department);
    }

    public List<Department> selectDepartmentList(Map<String, Object> map) {
        return super.selectForList("com.xunyu.crm.pojo.department.Department.selectDepartmentList",map);
    }

    public int deleteDepartment(Department department){
        return super.update("com.xunyu.crm.pojo.department.Department.deleteDepartment",department);
    }

    public int batchDeleteDepartment(List<Long> list) {
        return super.update("com.xunyu.crm.pojo.department.Department.batchDeleteDepartment",list);
    }

    public Integer selectTotalRows(DepartmentModel model){
        return super.selectOne("com.xunyu.crm.pojo.department.Department.selectTotalRows",model);
    }

    public Department selectByPrimaryKey(DepartmentModel model){
        return super.selectOne("com.xunyu.crm.pojo.department.Department.selectByPrimaryKey",model);
    }

    public DepartmentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return Department.class;
    }



}
