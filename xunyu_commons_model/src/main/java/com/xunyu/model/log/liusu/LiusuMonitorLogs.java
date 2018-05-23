package com.xunyu.model.log.liusu;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/23 10:06
 * 流速监控日志
 **/
public class LiusuMonitorLogs extends UserModel {

    private Long liusuId;//主键id
    private String nodeStatus;//节点类型
    private String nodeCode;//节点编码
    private String nodeName;//节点名称
    private String nodeAgree;//节点协议
    private String nodeNum;//节点接入号
    private Long sulv;//速率
    private Long storageNum;//平台存储量
    private Long totalNum;//2分钟总量
    private String gatewayName;//网关名称
    private String enterpriseNode;//企业代码
    private String enterpriseName;//企业名称
    private Date createTime;//创建时间

    private String liusuIds;//主键拼成的id  用于批量删除

    public String getLiusuIds() {
        return liusuIds;
    }

    public void setLiusuIds(String liusuIds) {
        this.liusuIds = liusuIds;
    }

    public Long getLiusuId() {
        return liusuId;
    }

    public void setLiusuId(Long liusuId) {
        this.liusuId = liusuId;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeAgree() {
        return nodeAgree;
    }

    public void setNodeAgree(String nodeAgree) {
        this.nodeAgree = nodeAgree;
    }

    public String getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(String nodeNum) {
        this.nodeNum = nodeNum;
    }

    public Long getSulv() {
        return sulv;
    }

    public void setSulv(Long sulv) {
        this.sulv = sulv;
    }

    public Long getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Long storageNum) {
        this.storageNum = storageNum;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getEnterpriseNode() {
        return enterpriseNode;
    }

    public void setEnterpriseNode(String enterpriseNode) {
        this.enterpriseNode = enterpriseNode;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
