package com.xunyu.model.user;

import java.util.List;

/**
 * @author xym
 * @description 企业部门 参数实体类
 * @date 2018/4/24 10:16
 */
public class DepartmentModel extends UserModel {

    private static final long serialVersionUID = -1134319541431865755L;
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
     * 备注
     * @return
     */
    private String remark;

    /**
     * 批量操作时用到的Id列表
     */
    private List<Long> idList;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
