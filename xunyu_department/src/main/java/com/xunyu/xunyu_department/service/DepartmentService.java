package com.xunyu.xunyu_department.service;

import com.xunyu.model.department.DepartmentModel;
import com.xunyu.xunyu_department.pojo.Department;

import java.util.List;
import java.util.Map;

/**
 * @author xym
 * @description 企业部门service接口
 * @date 2018/4/23 18:27
 */
public interface DepartmentService {

    /**
     * 新增企业部门
     */
    int addDepartment(Department department);
    /**
     * 删除企业部门
     */
    int deleteDepartment(Department department);

    /**
     * 查询部门list
     */
    List<Department> selectDepartmentList(Map<String,Object> map);
    /**
     * 修改部门信息
     */
    int updateDepartmentInfo(Department department);

    /**
     * 批量删除企业部门
     */
    int batchDeleteDepartment(List<Long> list);

    /**
     * 查询list时查询总条数
     * @param model
     * @return
     */
    Integer selectTotalRows(DepartmentModel model);


    /**
     * 查询单条部门记录
     */
    Department selectByPrimaryKey(DepartmentModel model);
}
