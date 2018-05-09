package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 错号空号配置管理 请求参数实体类
 * @date 2018/5/9 15:52
 */
public class WrongNumberConfigModel extends UserModel {
    private static final long serialVersionUID = -5652852732911286593L;

    /**
     *   主键
     */
    private Integer wrongNumConfigId;

    /**
     *   手机号码
     */
    private String phoneNumber;

    /**
     *   1：可用，0：不可用，默认为1
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 批量操作时用的参数集合（手机号）
     */
    private List<String> idList;

    public Integer getWrongNumConfigId() {
        return wrongNumConfigId;
    }

    public void setWrongNumConfigId(Integer wrongNumConfigId) {
        this.wrongNumConfigId = wrongNumConfigId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
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

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }
}
