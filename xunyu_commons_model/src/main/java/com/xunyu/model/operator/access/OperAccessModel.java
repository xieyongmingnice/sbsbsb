package com.xunyu.model.operator.access;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/6/11 15:35
 **/
public class OperAccessModel extends UserModel {

    private Long configId;//主键
    private String channelName;//自定义通道名称
    private String serviceIp;//服务端ip
    private String enterpriseCode;//企业代码
    private String accessCode;//接入码
    private Integer isable;//1启用 2停用 3作废(恢复时值传2(停用状态)) 4删除
    private String gatewayNumber;//网关号段
    private Integer agreeType;//协议类型  1、移动、2联通、3电信
    private String configIds;//批量操作是id组成的字符串

    public String getConfigIds() {
        return configIds;
    }

    public void setConfigIds(String configIds) {
        this.configIds = configIds;
    }

    public Integer getAgreeType() {
        return agreeType;
    }

    public void setAgreeType(Integer agreeType) {
        this.agreeType = agreeType;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getIsable() {
        return isable;
    }

    public void setIsable(Integer isable) {
        this.isable = isable;
    }

    public String getGatewayNumber() {
        return gatewayNumber;
    }

    public void setGatewayNumber(String gatewayNumber) {
        this.gatewayNumber = gatewayNumber;
    }
}
