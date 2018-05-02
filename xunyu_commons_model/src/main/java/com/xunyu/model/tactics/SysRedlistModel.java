package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author xym
 * @description 系统红名单  请求参数model
 * @date 2018/4/28 14:17
 */
public class SysRedlistModel extends UserModel{
    private static final long serialVersionUID = -353652518206452870L;

    /**
     * id
     */
    private Integer sysRedlistId;

    /**
     *   手机号
     */
    private String phoneNumber;

    /**
     *   红名单来源
     */
    private Integer redlistSource;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   备注
     */
    private String remarks;

    /**
     *   加入时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;


    public Integer getSysRedlistId() {
        return sysRedlistId;
    }

    public void setSysRedlistId(Integer sysRedlistId) {
        this.sysRedlistId = sysRedlistId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRedlistSource() {
        return redlistSource;
    }

    public void setRedlistSource(Integer redlistSource) {
        this.redlistSource = redlistSource;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
