package com.xunyu.xunyu_department.service.impl;

import com.xunyu.model.user.DepartmentModel;
import com.xunyu.xunyu_department.dao.DepartmentDaoImpl;
import com.xunyu.xunyu_department.pojo.Department;
import com.xunyu.xunyu_department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService{

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
}
