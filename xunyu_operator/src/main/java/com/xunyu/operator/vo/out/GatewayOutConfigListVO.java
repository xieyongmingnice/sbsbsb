package com.xunyu.operator.vo.out;

import com.xunyu.operator.pojo.access.OperAccessCoreConfig;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xym
 * @description 网关接出配置列表VO
 * @date 2018/6/14 12:03
 */
public class GatewayOutConfigListVO implements Serializable{
    private static final long serialVersionUID = -1938592598948089150L;
    /**
     * 主键
     */
    private Integer gatewayOutConfigId;

    /**
     * 协议类型str
     */
    private String agreeTypeStr;

    /**
     * 接出网关名称(网关接入码)
     */
    private String channelName;

    /**
     * 用户类型str
     */
    private String customerTypeStr;

    /**
     * 企业IP
     */
    private String enterpriseIp;

    /**
     * 企业代码
     */
    private String enterpriseCode;

    /**
     * 企业联系人
     */
    private String enterContact;

    /**
     * 企业名称
     */
    private String customerName;

    /**
     * 企业侧接入码
     */
    private String spAccessCode;

    /**
     *   短信剩余条数
     */
    private Integer remainderMsgNum;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     *   是否启用，1：是，0：否，默认1
     */
    private Integer isUsed;

    /**
     * 归属业务
     */
    private String operatorName;

    /**
     * 是否有效
     */
    private Integer isabled;

    /**
     * 是否有效 字符串
     */
    private String isUsedStr;
    /**
     * 网关节点列表
     */
    private List<OperAccessCoreConfig> operAccessCoreConfigList;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getIsUsedStr() {
        return isUsedStr;
    }

    public void setIsUsedStr(String isUsedStr) {
        this.isUsedStr = isUsedStr;
    }

    public Integer getGatewayOutConfigId() {
        return gatewayOutConfigId;
    }

    public void setGatewayOutConfigId(Integer gatewayOutConfigId) {
        this.gatewayOutConfigId = gatewayOutConfigId;
    }

    public String getAgreeTypeStr() {
        return agreeTypeStr;
    }

    public void setAgreeTypeStr(String agreeTypeStr) {
        this.agreeTypeStr = agreeTypeStr;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getCustomerTypeStr() {
        return customerTypeStr;
    }

    public void setCustomerTypeStr(String customerTypeStr) {
        this.customerTypeStr = customerTypeStr;
    }

    public String getEnterpriseIp() {
        return enterpriseIp;
    }

    public void setEnterpriseIp(String enterpriseIp) {
        this.enterpriseIp = enterpriseIp;
    }

    public String getEnterContact() {
        return enterContact;
    }

    public void setEnterContact(String enterContact) {
        this.enterContact = enterContact;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSpAccessCode() {
        return spAccessCode;
    }

    public void setSpAccessCode(String spAccessCode) {
        this.spAccessCode = spAccessCode;
    }

    public Integer getRemainderMsgNum() {
        return remainderMsgNum;
    }

    public void setRemainderMsgNum(Integer remainderMsgNum) {
        this.remainderMsgNum = remainderMsgNum;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public List<OperAccessCoreConfig> getOperAccessCoreConfigList() {
        return operAccessCoreConfigList;
    }

    public void setOperAccessCoreConfigList(List<OperAccessCoreConfig> operAccessCoreConfigList) {
        this.operAccessCoreConfigList = operAccessCoreConfigList;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }
}
