package com.xunyu.crm.service.department.impl;

import com.xunyu.crm.dao.department.DepartmentDaoImpl;
import com.xunyu.crm.pojo.department.Department;
import com.xunyu.crm.service.department.DepartmentService;
import com.xunyu.model.department.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDaoImpl dao ;

    @Override
    public int addDepartment(Department department) {
        return dao.addDepartment(department);
    }

    @Override
    public int deleteDepartment(Department department) {
        return dao.deleteDepartment(department);
    }

    @Override
    public List<Department> selectDepartmentList(Map<String, Object> map) {
        return dao.selectDepartmentList(map);
    }

    @Override
    public int updateDepartmentInfo(Department department) {
        return dao.updateDepartmentInfo(department);
    }

    @Override
    public int batchDeleteDepartment(List<Long> list) {
        return dao.batchDeleteDepartment(list);
    }

    @Override
    public Integer selectTotalRows(DepartmentModel model) {
        return dao.selectTotalRows(model);
    }

    @Override
    public Department selectByPrimaryKey(DepartmentModel model) {
        return dao.selectByPrimaryKey(model);
    }
}
