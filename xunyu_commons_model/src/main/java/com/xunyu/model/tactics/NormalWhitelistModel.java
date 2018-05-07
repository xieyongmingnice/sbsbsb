package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 白名单 请求参数实体类
 * @date 2018/5/7 13:52
 */
public class NormalWhitelistModel extends UserModel {
    private static final long serialVersionUID = 1667231589883903440L;

    /**
     *   主键
     *
     */
    private Integer normalWhitelistId;

    /**
     *   手机号
     *
     */
    private String phoneNumber;

    /**
     *   加入时间
     *
     */
    private Date joinTime;

    /**
     *   1：可用，0：不可用
     *
     */
    private Integer isabled;

    /**
     *   开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 批量操作时用的主键集合
     */
    private List<Long> idList;

    public Integer getNormalWhitelistId() {
        return normalWhitelistId;
    }

    public void setNormalWhitelistId(Integer normalWhitelistId) {
        this.normalWhitelistId = normalWhitelistId;
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

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
