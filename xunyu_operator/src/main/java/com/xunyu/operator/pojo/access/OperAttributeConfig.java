package com.xunyu.operator.pojo.access;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/6/12 17:18
 **/
public class OperAttributeConfig extends UserModel {

    private Long attrId;//属性id
    private Long aConfigId;//主配置id
    private int attrPriority;//优先级
    private int attrLimit;//出口流量是否限制  1是 2否
    private int attrThreshold;//流量门限
    private int msgNumber;//短信剩余条数
    private int channelState;//是否启用该通道 1启动  2停用
    private int maxConn;//最大连接数
    private int witeRes;//等待响应条数
    private int witeTime;//等待响应时间
    private String pushLoginUser;//推送登录用户名

    public Long getaConfigId() {
        return aConfigId;
    }

    public void setaConfigId(Long aConfigId) {
        this.aConfigId = aConfigId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public int getAttrPriority() {
        return attrPriority;
    }

    public void setAttrPriority(int attrPriority) {
        this.attrPriority = attrPriority;
    }

    public int getAttrLimit() {
        return attrLimit;
    }

    public void setAttrLimit(int attrLimit) {
        this.attrLimit = attrLimit;
    }

    public int getAttrThreshold() {
        return attrThreshold;
    }

    public void setAttrThreshold(int attrThreshold) {
        this.attrThreshold = attrThreshold;
    }

    public int getMsgNumber() {
        return msgNumber;
    }

    public void setMsgNumber(int msgNumber) {
        this.msgNumber = msgNumber;
    }

    public int getChannelState() {
        return channelState;
    }

    public void setChannelState(int channelState) {
        this.channelState = channelState;
    }

    public int getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }

    public int getWiteRes() {
        return witeRes;
    }

    public void setWiteRes(int witeRes) {
        this.witeRes = witeRes;
    }

    public int getWiteTime() {
        return witeTime;
    }

    public void setWiteTime(int witeTime) {
        this.witeTime = witeTime;
    }

    public String getPushLoginUser() {
        return pushLoginUser;
    }

    public void setPushLoginUser(String pushLoginUser) {
        this.pushLoginUser = pushLoginUser;
    }
}
