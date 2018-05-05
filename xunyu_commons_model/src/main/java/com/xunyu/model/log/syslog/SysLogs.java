package com.xunyu.model.log.syslog;

import com.xunyu.model.user.UserModel;

import java.util.Date;

public class SysLogs extends UserModel {

    private Long logsId;
    private Date operTime;//操作时间
    private String operName;//操作名称
    private String operIp;//操作IP
    private String operType;//操作类型
    private String operObj;//操作对象

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
