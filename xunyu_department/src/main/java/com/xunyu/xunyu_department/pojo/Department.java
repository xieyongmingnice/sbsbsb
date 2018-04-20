package com.xunyu.xunyu_department.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 部门  实体类
 * @date 2018/4/20 17:38
 */
public class Department implements Serializable{
    private static final long serialVersionUID = 5895836573558705657L;

    /**
     * 部门ID
     */
    private long departmentId;
    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 可用状态标志
     */
    private int isAbled;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getIsAbled() {
        return isAbled;
    }

    public void setIsAbled(int isAbled) {
        this.isAbled = isAbled;
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
}
