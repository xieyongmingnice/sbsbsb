package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 普通黑名单 请求参数实体类
 * @date 2018/5/4 16:46
 */
public class NormalBlacklistModel extends UserModel {
    private static final long serialVersionUID = -1613073626030038470L;

    /**
     *   主键
     */
    private Integer normalBlacklistId;

    /**
     *   手机号码
     */
    private String phoneNumber;

    /**
     *   黑名单来源 1:回复加黑，2:手动加黑，3:其他搜集
     */
    private Integer blacklistSource;

    /**
     *   备注
     */
    private String remarks;

    /**
     *   可用状态标签
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

    public Integer getNormalBlacklistId() {
        return normalBlacklistId;
    }

    public void setNormalBlacklistId(Integer normalBlacklistId) {
        this.normalBlacklistId = normalBlacklistId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBlacklistSource() {
        return blacklistSource;
    }

    public void setBlacklistSource(Integer blacklistSource) {
        this.blacklistSource = blacklistSource;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
