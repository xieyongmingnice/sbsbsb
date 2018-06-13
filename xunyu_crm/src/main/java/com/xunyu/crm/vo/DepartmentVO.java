package com.xunyu.crm.vo;

import java.io.Serializable;
import java.util.Date;

public class DepartmentVO implements Serializable{

    private static final long serialVersionUID = -1249975456918550208L;
    /**
     * 部门ID
     */
    private Long departmentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门联系人
     */
    private String departmentLinkman;

    /**
     * 部门电话
     */
    private String departmentPhone;
    /**
     * 可用状态标志
     */
    private int isabled;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 部门员工数
     */
    private Integer employeeNum;


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLinkman() {
        return departmentLinkman;
    }

    public void setDepartmentLinkman(String departmentLinkman) {
        this.departmentLinkman = departmentLinkman;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public int getIsabled() {
        return isabled;
    }

    public void setIsabled(int isabled) {
        this.isabled = isabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }
}
