package com.xunyu.model.log.link;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/23 9:57
 * 链接操作日志
 **/
public class LinkOperLogs extends UserModel {

    private Long linkId;//主键id
    private String gatewayNode;//网关节点
    private String duiduanNode;//对端节点
    private String duiNodeType;//对端节点类型
    private String handleResult;//处理结果
    private String linkDirection;//链接方向
    private Date linkDate;//链接开始时间
    private String agreement; //协议
    private String duiduanIp;//对端ip
    private String duiduanPort;//对端端口号
    private String linkStatus;//链接状态
    private Date discoDate;//断开时间
    private Date createTime;//创建时间

    private String beginTime;
    private String endTime;
    private String linkIds;//用于批量删除

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

    public String getLinkIds() {
        return linkIds;
    }

    public void setLinkIds(String linkIds) {
        this.linkIds = linkIds;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getGatewayNode() {
        return gatewayNode;
    }

    public void setGatewayNode(String gatewayNode) {
        this.gatewayNode = gatewayNode;
    }

    public String getDuiduanNode() {
        return duiduanNode;
    }

    public void setDuiduanNode(String duiduanNode) {
        this.duiduanNode = duiduanNode;
    }

    public String getDuiNodeType() {
        return duiNodeType;
    }

    public void setDuiNodeType(String duiNodeType) {
        this.duiNodeType = duiNodeType;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getLinkDirection() {
        return linkDirection;
    }

    public void setLinkDirection(String linkDirection) {
        this.linkDirection = linkDirection;
    }

    public Date getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(Date linkDate) {
        this.linkDate = linkDate;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getDuiduanIp() {
        return duiduanIp;
    }

    public void setDuiduanIp(String duiduanIp) {
        this.duiduanIp = duiduanIp;
    }

    public String getDuiduanPort() {
        return duiduanPort;
    }

    public void setDuiduanPort(String duiduanPort) {
        this.duiduanPort = duiduanPort;
    }

    public String getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(String linkStatus) {
        this.linkStatus = linkStatus;
    }

    public Date getDiscoDate() {
        return discoDate;
    }

    public void setDiscoDate(Date discoDate) {
        this.discoDate = discoDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
