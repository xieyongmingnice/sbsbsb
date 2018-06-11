package com.xunyu.operator.pojo.access;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/6/11 10:55
 *   网关入口 核心配置实体
 **/
public class OperAccessCoreConfig extends UserModel {

    private Long configId;//主键
    private Long operatorId;//运营商配置id
    private String channelCode;//自定义通道编码
    private String channelName;//自定义通道名称
    private int agreeType;//协议类型  1、移动、2联通、3电信
    private String childrenAgreeType;//自协议类型
    private String serviceIp;//服务端ip
    private String servicePort;//服务端端口
    private String enterpriseCode;//企业代码
    private String enterAccount;//企业用户名
    private String enterPwd;//企业密码
    private String nodeCode;//节点代码
    private String accessCode;//接入码
    private String serviceCode;//服务代码
    private int ordinaryMsgNum;//普通短信字节数
    private int extendNum;//扩展位数
    private int whetherExtend;//是否启用签名扩展
    private int isable;//1启用 2停用 3作废
    private Date createTime;//创建时间
    private OperExtendConfig operExtendConfig;//网关扩展属性配置
    private OperMarkConfig operMarkConfig;//网关备注信息

    public OperExtendConfig getOperExtendConfig() {
        return operExtendConfig;
    }

    public void setOperExtendConfig(OperExtendConfig operExtendConfig) {
        this.operExtendConfig = operExtendConfig;
    }

    public OperMarkConfig getOperMarkConfig() {
        return operMarkConfig;
    }

    public void setOperMarkConfig(OperMarkConfig operMarkConfig) {
        this.operMarkConfig = operMarkConfig;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getAgreeType() {
        return agreeType;
    }

    public void setAgreeType(int agreeType) {
        this.agreeType = agreeType;
    }

    public String getChildrenAgreeType() {
        return childrenAgreeType;
    }

    public void setChildrenAgreeType(String childrenAgreeType) {
        this.childrenAgreeType = childrenAgreeType;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getEnterAccount() {
        return enterAccount;
    }

    public void setEnterAccount(String enterAccount) {
        this.enterAccount = enterAccount;
    }

    public String getEnterPwd() {
        return enterPwd;
    }

    public void setEnterPwd(String enterPwd) {
        this.enterPwd = enterPwd;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public int getOrdinaryMsgNum() {
        return ordinaryMsgNum;
    }

    public void setOrdinaryMsgNum(int ordinaryMsgNum) {
        this.ordinaryMsgNum = ordinaryMsgNum;
    }

    public int getExtendNum() {
        return extendNum;
    }

    public void setExtendNum(int extendNum) {
        this.extendNum = extendNum;
    }

    public int getWhetherExtend() {
        return whetherExtend;
    }

    public void setWhetherExtend(int whetherExtend) {
        this.whetherExtend = whetherExtend;
    }

    public int getIsable() {
        return isable;
    }

    public void setIsable(int isable) {
        this.isable = isable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
