package com.xunyu.shiro.pojo.permission;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dth
 * @date 2018/4/20 17:39
 * 权限表
 **/
public class Permissions implements Serializable {
    private static final long serialVersionUID = -5188620779834464045L;

    private Long permissionId;
    private String permissionName;//权限名称
    private Long permissionGroupId;//权限组ID
    private String permissionDomain;//权限属于哪个应用
    private Integer permissionType;//1-页面访问控制权限，2-功能级访问控制权限
    private String permissionUri;//功能的访问地址
    private Integer isabled;//0-不可用，1-可用
    private String remark;//权限备注
    private Date permissionCreateTime;//创建时间
    private PermissionGroup permissionGroup;//权限组

    public PermissionGroup getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(PermissionGroup permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getPermissionDomain() {
        return permissionDomain;
    }

    public void setPermissionDomain(String permissionDomain) {
        this.permissionDomain = permissionDomain;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionUri() {
        return permissionUri;
    }

    public void setPermissionUri(String permissionUri) {
        this.permissionUri = permissionUri;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getPermissionCreateTime() {
        return permissionCreateTime;
    }

    public void setPermissionCreateTime(Date permissionCreateTime) {
        this.permissionCreateTime = permissionCreateTime;
    }
}
