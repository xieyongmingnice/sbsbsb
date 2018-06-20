package com.xunyu.operator.vo.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 * @description 
 * @date 2018/6/20 11:00
 */
public class SpGatewayConfigVO implements Serializable{
    private static final long serialVersionUID = 184972824726705979L;
    /**
     *   主键
     */
    private Integer spGatewayConfigId;

    /**
     *   协议id
     */
    private Integer carrierAgreeId;

    /**
     * 网关接出配置id
     */
    private String gatewayOutConfigId;

    /**
     *   网关接入配置id
     */
    private Integer configId;

    /**
     *   网关接入码
     */
    private String gatewayAccessCode;

    /**
     *   二进制短信长度限制
     */
    private Integer binaryMsgLenLimit;

    /**
     *   SP短信长度限制
     */
    private Integer spMsgLenLimit;

    /**
     *   网关固定签名位置 1：签名后置，2：签名前置，默认为1
     */
    private Integer fixedSignLocation;

    /**
     *   SP长短信额外可发字数
     */
    private Integer longMsgExtraNum;

    /**
     *   是否ASCII支持  1：支持，0：不支持，默认为0
     */
    private Integer isAscllSupported;

    /**
     *   ASCII长度限制
     */
    private Integer ascllLenLimit;

    /**
     *   ASCII签名长度
     */
    private Integer ascllSignLen;

    /**
     *   是否去签名发送，1：是，0：否，默认否
     */
    private Integer isSendWithoutSign;

    /**
     *   发送去签名内容
     */
    private String contentWithoutSign;

    /**
     *   业务最低销售成本
     */
    private BigDecimal minSaleCost;

    /**
     *   业务销售实际价格
     */
    private BigDecimal actualSalePrice;

    /**
     *   业务销售提成比例
     */
    private BigDecimal saleCommissionProp;

    /**
     *   1：可用，0：不可用，默认1
     */
    private Integer isabled;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     * 以下是自定义字段
     */
    /**
     * 协议名称
     */
    private String agreeName;

    /**
     * 网关名称
     */
    private String channelName;

    /**
     * 是否固定位置字符串
     */
    private String fixedSignLocationStr;
    /**
     * 是否支持ascll字符串
     */
    private String isAscllSupportedStr;
    /**
     * 是否去签名发送字符串
     */
    private String isSendWithoutSignStr;

    public Integer getSpGatewayConfigId() {
        return spGatewayConfigId;
    }

    public void setSpGatewayConfigId(Integer spGatewayConfigId) {
        this.spGatewayConfigId = spGatewayConfigId;
    }

    public Integer getCarrierAgreeId() {
        return carrierAgreeId;
    }

    public void setCarrierAgreeId(Integer carrierAgreeId) {
        this.carrierAgreeId = carrierAgreeId;
    }

    public String getGatewayOutConfigId() {
        return gatewayOutConfigId;
    }

    public void setGatewayOutConfigId(String gatewayOutConfigId) {
        this.gatewayOutConfigId = gatewayOutConfigId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getGatewayAccessCode() {
        return gatewayAccessCode;
    }

    public void setGatewayAccessCode(String gatewayAccessCode) {
        this.gatewayAccessCode = gatewayAccessCode;
    }

    public Integer getBinaryMsgLenLimit() {
        return binaryMsgLenLimit;
    }

    public void setBinaryMsgLenLimit(Integer binaryMsgLenLimit) {
        this.binaryMsgLenLimit = binaryMsgLenLimit;
    }

    public Integer getSpMsgLenLimit() {
        return spMsgLenLimit;
    }

    public void setSpMsgLenLimit(Integer spMsgLenLimit) {
        this.spMsgLenLimit = spMsgLenLimit;
    }

    public Integer getFixedSignLocation() {
        return fixedSignLocation;
    }

    public void setFixedSignLocation(Integer fixedSignLocation) {
        this.fixedSignLocation = fixedSignLocation;
    }

    public Integer getLongMsgExtraNum() {
        return longMsgExtraNum;
    }

    public void setLongMsgExtraNum(Integer longMsgExtraNum) {
        this.longMsgExtraNum = longMsgExtraNum;
    }

    public Integer getIsAscllSupported() {
        return isAscllSupported;
    }

    public void setIsAscllSupported(Integer isAscllSupported) {
        this.isAscllSupported = isAscllSupported;
    }

    public Integer getAscllLenLimit() {
        return ascllLenLimit;
    }

    public void setAscllLenLimit(Integer ascllLenLimit) {
        this.ascllLenLimit = ascllLenLimit;
    }

    public Integer getAscllSignLen() {
        return ascllSignLen;
    }

    public void setAscllSignLen(Integer ascllSignLen) {
        this.ascllSignLen = ascllSignLen;
    }

    public Integer getIsSendWithoutSign() {
        return isSendWithoutSign;
    }

    public void setIsSendWithoutSign(Integer isSendWithoutSign) {
        this.isSendWithoutSign = isSendWithoutSign;
    }

    public String getContentWithoutSign() {
        return contentWithoutSign;
    }

    public void setContentWithoutSign(String contentWithoutSign) {
        this.contentWithoutSign = contentWithoutSign;
    }

    public BigDecimal getMinSaleCost() {
        return minSaleCost;
    }

    public void setMinSaleCost(BigDecimal minSaleCost) {
        this.minSaleCost = minSaleCost;
    }

    public BigDecimal getActualSalePrice() {
        return actualSalePrice;
    }

    public void setActualSalePrice(BigDecimal actualSalePrice) {
        this.actualSalePrice = actualSalePrice;
    }

    public BigDecimal getSaleCommissionProp() {
        return saleCommissionProp;
    }

    public void setSaleCommissionProp(BigDecimal saleCommissionProp) {
        this.saleCommissionProp = saleCommissionProp;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAgreeName() {
        return agreeName;
    }

    public void setAgreeName(String agreeName) {
        this.agreeName = agreeName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getFixedSignLocationStr() {
        return fixedSignLocationStr;
    }

    public void setFixedSignLocationStr(String fixedSignLocationStr) {
        this.fixedSignLocationStr = fixedSignLocationStr;
    }

    public String getIsAscllSupportedStr() {
        return isAscllSupportedStr;
    }

    public void setIsAscllSupportedStr(String isAscllSupportedStr) {
        this.isAscllSupportedStr = isAscllSupportedStr;
    }

    public String getIsSendWithoutSignStr() {
        return isSendWithoutSignStr;
    }

    public void setIsSendWithoutSignStr(String isSendWithoutSignStr) {
        this.isSendWithoutSignStr = isSendWithoutSignStr;
    }
}
