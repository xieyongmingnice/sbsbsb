package com.xunyu.model.log.http;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/23 9:53
 * http操作通知
 **/
public class HttpOperationNotice extends UserModel {

    private Long noticeId;//主键id
    private Date operaTime;//操作时间
    private String nodeType;//节点类型
    private String noticeCode;//通知编码
    private String noticeState;//通知状态
    private String handleState;//处理状态
    private String operaUser;//操作用户

    private String noticeIds;//主键id拼成的字符串，用于批量删除

    public String getNoticeIds() {
        return noticeIds;
    }

    public void setNoticeIds(String noticeIds) {
        this.noticeIds = noticeIds;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Date getOperaTime() {
        return operaTime;
    }

    public void setOperaTime(Date operaTime) {
        this.operaTime = operaTime;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(String noticeState) {
        this.noticeState = noticeState;
    }

    public String getHandleState() {
        return handleState;
    }

    public void setHandleState(String handleState) {
        this.handleState = handleState;
    }

    public String getOperaUser() {
        return operaUser;
    }

    public void setOperaUser(String operaUser) {
        this.operaUser = operaUser;
    }
}
