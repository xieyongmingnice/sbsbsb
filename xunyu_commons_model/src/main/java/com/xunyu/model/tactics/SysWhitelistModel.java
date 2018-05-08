package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 系统白名单 请求参数实体类
 * @date 2018/5/3 18:12
 */
public class SysWhitelistModel extends UserModel{

    private static final long serialVersionUID = 4390369855167165790L;

    /**
     *   主键
     */
    private Integer sysWhitelistId;

    /**
     *   手机号码
     */
    private String phoneNumber;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     * 批量操作时用的参数集合（手机号）
     */
    private List<String> idList;

    /**
     *   加入时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    public Integer getSysWhitelistId() {
        return sysWhitelistId;
    }

    public void setSysWhitelistId(Integer sysWhitelistId) {
        this.sysWhitelistId = sysWhitelistId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
