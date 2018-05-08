package com.xunyu.model.system.sysarea;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/5/8 9:55
 **/
public class SysAreaModel extends UserModel {

    private Long areaId;//主键
    private String areaCode;//区域编码
    private String areaName;//区域名称
    private String areaIds;//id组成的字符串

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String areaIds) {
        this.areaIds = areaIds;
    }
}
