package com.xunyu.xunyu_department.dao;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.xunyu_department.pojo.Department;
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
        return super.insert("com.xunyu.xunyu_department.pojo.Department.addDepartment",department);
    }

    public int updateDepartmentInfo(Department department) {
        return super.update("com.xunyu.xunyu_department.pojo.Department.updateDepartmentInfo",department);
    }

    public List<Department> selectDepartmentList(Map<String, Object> map) {
        return super.selectForList("com.xunyu.xunyu_department.pojo.Department.selectDepartmentList",map);
    }

    public int deleteDepartment(Department department){
        return super.update("com.xunyu.xunyu_department.pojo.Department.deleteDepartment",department);
    }

    public int batchDeleteDepartment(List<Long> list) {
        return super.update("com.xunyu.xunyu_department.pojo.Department.batchDeleteDepartment",list);
    }

    public DepartmentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return Department.class;
    }



}
