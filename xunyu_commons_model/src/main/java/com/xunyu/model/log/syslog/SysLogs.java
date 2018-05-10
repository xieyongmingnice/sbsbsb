package com.xunyu.model.log.syslog;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/10 9:23
 **/
public class SysLogs extends UserModel {

    private Long logsId;
    private Date operTime;//操作时间
    private String operName;//操作名称
    private String operIp;//操作IP
    private String operType;//操作类型
    private String operObj;//操作对象
    private String enterContact;//联系人
    private String operPort;//操作端口
    private String operText;//操作描述
    private Integer operStatus;// 操作状态 1成功  2失败

    private String beginTime;//开始时间
    private String endTime; //结束时间
    private String logsIds;//id组成的字符串

    public String getLogsIds() {
        return logsIds;
    }

    public void setLogsIds(String logsIds) {
        this.logsIds = logsIds;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEnterContact() {
        return enterContact;
    }

    public void setEnterContact(String enterContact) {
        this.enterContact = enterContact;
    }

    public String getOperPort() {
        return operPort;
    }

    public void setOperPort(String operPort) {
        this.operPort = operPort;
    }

    public String getOperText() {
        return operText;
    }

    public void setOperText(String operText) {
        this.operText = operText;
    }

    public Integer getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(Integer operStatus) {
        this.operStatus = operStatus;
    }

    public Long getLogsId() {
        return logsId;
    }

    public void setLogsId(Long logsId) {
        this.logsId = logsId;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOperObj() {
        return operObj;
    }

    public void setOperObj(String operObj) {
        this.operObj = operObj;
    }
}
