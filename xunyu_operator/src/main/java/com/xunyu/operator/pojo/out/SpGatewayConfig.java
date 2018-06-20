package com.xunyu.operator.pojo.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author
 * @description
 * @date 2018/6/14 15:47
 */
public class SpGatewayConfig implements Serializable {
    private static final long serialVersionUID = 7220863732452422291L;
    /**
     *   主键
     */
    private Integer spGatewayConfigId;

    /**
     *   运营商类型
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

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.gateway_out_config_id
     *
     * @return the value of tbl_sp_gateway_conifg.gateway_out_config_id
     */
    public String getGatewayOutConfigId() {
        return gatewayOutConfigId;
    }

    /**
     */
    public SpGatewayConfig withGatewayOutConfigId(String gatewayOutConfigId) {
        this.setGatewayOutConfigId(gatewayOutConfigId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.gateway_out_config_id
     *
     * @param gatewayOutConfigId the value for tbl_sp_gateway_conifg.gateway_out_config_id
     */
    public void setGatewayOutConfigId(String gatewayOutConfigId) {
        this.gatewayOutConfigId = gatewayOutConfigId;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.config_id
     *
     * @return the value of tbl_sp_gateway_conifg.config_id
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     */
    public SpGatewayConfig withConfigId(Integer configId) {
        this.setConfigId(configId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.config_id
     *
     * @param configId the value for tbl_sp_gateway_conifg.config_id
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.gateway_access_code
     *
     * @return the value of tbl_sp_gateway_conifg.gateway_access_code
     */
    public String getGatewayAccessCode() {
        return gatewayAccessCode;
    }

    /**
     */
    public SpGatewayConfig withGatewayAccessCode(String gatewayAccessCode) {
        this.setGatewayAccessCode(gatewayAccessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.gateway_access_code
     *
     * @param gatewayAccessCode the value for tbl_sp_gateway_conifg.gateway_access_code
     */
    public void setGatewayAccessCode(String gatewayAccessCode) {
        this.gatewayAccessCode = gatewayAccessCode;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.binary_msg_len_limit
     *
     * @return the value of tbl_sp_gateway_conifg.binary_msg_len_limit
     */
    public Integer getBinaryMsgLenLimit() {
        return binaryMsgLenLimit;
    }

    /**
     */
    public SpGatewayConfig withBinaryMsgLenLimit(Integer binaryMsgLenLimit) {
        this.setBinaryMsgLenLimit(binaryMsgLenLimit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.binary_msg_len_limit
     *
     * @param binaryMsgLenLimit the value for tbl_sp_gateway_conifg.binary_msg_len_limit
     */
    public void setBinaryMsgLenLimit(Integer binaryMsgLenLimit) {
        this.binaryMsgLenLimit = binaryMsgLenLimit;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.sp_msg_len_limit
     *
     * @return the value of tbl_sp_gateway_conifg.sp_msg_len_limit
     */
    public Integer getSpMsgLenLimit() {
        return spMsgLenLimit;
    }

    /**
     */
    public SpGatewayConfig withSpMsgLenLimit(Integer spMsgLenLimit) {
        this.setSpMsgLenLimit(spMsgLenLimit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.sp_msg_len_limit
     *
     * @param spMsgLenLimit the value for tbl_sp_gateway_conifg.sp_msg_len_limit
     */
    public void setSpMsgLenLimit(Integer spMsgLenLimit) {
        this.spMsgLenLimit = spMsgLenLimit;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.fixed_sign_location
     *
     * @return the value of tbl_sp_gateway_conifg.fixed_sign_location
     */
    public Integer getFixedSignLocation() {
        return fixedSignLocation;
    }

    /**
     */
    public SpGatewayConfig withFixedSignLocation(Integer fixedSignLocation) {
        this.setFixedSignLocation(fixedSignLocation);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.fixed_sign_location
     *
     * @param fixedSignLocation the value for tbl_sp_gateway_conifg.fixed_sign_location
     */
    public void setFixedSignLocation(Integer fixedSignLocation) {
        this.fixedSignLocation = fixedSignLocation;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.long_msg_extra_num
     *
     * @return the value of tbl_sp_gateway_conifg.long_msg_extra_num
     */
    public Integer getLongMsgExtraNum() {
        return longMsgExtraNum;
    }

    /**
     */
    public SpGatewayConfig withLongMsgExtraNum(Integer longMsgExtraNum) {
        this.setLongMsgExtraNum(longMsgExtraNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.long_msg_extra_num
     *
     * @param longMsgExtraNum the value for tbl_sp_gateway_conifg.long_msg_extra_num
     */
    public void setLongMsgExtraNum(Integer longMsgExtraNum) {
        this.longMsgExtraNum = longMsgExtraNum;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.is_ascll_supported
     *
     * @return the value of tbl_sp_gateway_conifg.is_ascll_supported
     */
    public Integer getIsAscllSupported() {
        return isAscllSupported;
    }

    /**
     */
    public SpGatewayConfig withIsAscllSupported(Integer isAscllSupported) {
        this.setIsAscllSupported(isAscllSupported);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.is_ascll_supported
     *
     * @param isAscllSupported the value for tbl_sp_gateway_conifg.is_ascll_supported
     */
    public void setIsAscllSupported(Integer isAscllSupported) {
        this.isAscllSupported = isAscllSupported;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.ascll_len_limit
     *
     * @return the value of tbl_sp_gateway_conifg.ascll_len_limit
     */
    public Integer getAscllLenLimit() {
        return ascllLenLimit;
    }

    /**
     */
    public SpGatewayConfig withAscllLenLimit(Integer ascllLenLimit) {
        this.setAscllLenLimit(ascllLenLimit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.ascll_len_limit
     *
     * @param ascllLenLimit the value for tbl_sp_gateway_conifg.ascll_len_limit
     */
    public void setAscllLenLimit(Integer ascllLenLimit) {
        this.ascllLenLimit = ascllLenLimit;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.ascll_sign_len
     *
     * @return the value of tbl_sp_gateway_conifg.ascll_sign_len
     */
    public Integer getAscllSignLen() {
        return ascllSignLen;
    }

    /**
     */
    public SpGatewayConfig withAscllSignLen(Integer ascllSignLen) {
        this.setAscllSignLen(ascllSignLen);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.ascll_sign_len
     *
     * @param ascllSignLen the value for tbl_sp_gateway_conifg.ascll_sign_len
     */
    public void setAscllSignLen(Integer ascllSignLen) {
        this.ascllSignLen = ascllSignLen;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.is_send_without_sign
     *
     * @return the value of tbl_sp_gateway_conifg.is_send_without_sign
     */
    public Integer getIsSendWithoutSign() {
        return isSendWithoutSign;
    }

    /**
     */
    public SpGatewayConfig withIsSendWithoutSign(Integer isSendWithoutSign) {
        this.setIsSendWithoutSign(isSendWithoutSign);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.is_send_without_sign
     *
     * @param isSendWithoutSign the value for tbl_sp_gateway_conifg.is_send_without_sign
     */
    public void setIsSendWithoutSign(Integer isSendWithoutSign) {
        this.isSendWithoutSign = isSendWithoutSign;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.content_without_sign
     *
     * @return the value of tbl_sp_gateway_conifg.content_without_sign
     */
    public String getContentWithoutSign() {
        return contentWithoutSign;
    }

    /**
     */
    public SpGatewayConfig withContentWithoutSign(String contentWithoutSign) {
        this.setContentWithoutSign(contentWithoutSign);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.content_without_sign
     *
     * @param contentWithoutSign the value for tbl_sp_gateway_conifg.content_without_sign
     */
    public void setContentWithoutSign(String contentWithoutSign) {
        this.contentWithoutSign = contentWithoutSign;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.min_sale_cost
     *
     * @return the value of tbl_sp_gateway_conifg.min_sale_cost
     */
    public BigDecimal getMinSaleCost() {
        return minSaleCost;
    }

    /**
     */
    public SpGatewayConfig withMinSaleCost(BigDecimal minSaleCost) {
        this.setMinSaleCost(minSaleCost);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.min_sale_cost
     *
     * @param minSaleCost the value for tbl_sp_gateway_conifg.min_sale_cost
     */
    public void setMinSaleCost(BigDecimal minSaleCost) {
        this.minSaleCost = minSaleCost;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.actual_sale_price
     *
     * @return the value of tbl_sp_gateway_conifg.actual_sale_price
     */
    public BigDecimal getActualSalePrice() {
        return actualSalePrice;
    }

    /**
     */
    public SpGatewayConfig withActualSalePrice(BigDecimal actualSalePrice) {
        this.setActualSalePrice(actualSalePrice);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.actual_sale_price
     *
     * @param actualSalePrice the value for tbl_sp_gateway_conifg.actual_sale_price
     */
    public void setActualSalePrice(BigDecimal actualSalePrice) {
        this.actualSalePrice = actualSalePrice;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.sale_commission_prop
     *
     * @return the value of tbl_sp_gateway_conifg.sale_commission_prop
     */
    public BigDecimal getSaleCommissionProp() {
        return saleCommissionProp;
    }

    /**
     */
    public SpGatewayConfig withSaleCommissionProp(BigDecimal saleCommissionProp) {
        this.setSaleCommissionProp(saleCommissionProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.sale_commission_prop
     *
     * @param saleCommissionProp the value for tbl_sp_gateway_conifg.sale_commission_prop
     */
    public void setSaleCommissionProp(BigDecimal saleCommissionProp) {
        this.saleCommissionProp = saleCommissionProp;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.isabled
     *
     * @return the value of tbl_sp_gateway_conifg.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public SpGatewayConfig withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.isabled
     *
     * @param isabled the value for tbl_sp_gateway_conifg.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_sp_gateway_conifg.create_time
     *
     * @return the value of tbl_sp_gateway_conifg.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     */
    public SpGatewayConfig withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_sp_gateway_conifg.create_time
     *
     * @param createTime the value for tbl_sp_gateway_conifg.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spGatewayConfigId=").append(spGatewayConfigId);
        sb.append(", carrierAgreeId=").append(carrierAgreeId);
        sb.append(", gatewayOutConfigId=").append(gatewayOutConfigId);
        sb.append(", configId=").append(configId);
        sb.append(", gatewayAccessCode=").append(gatewayAccessCode);
        sb.append(", binaryMsgLenLimit=").append(binaryMsgLenLimit);
        sb.append(", spMsgLenLimit=").append(spMsgLenLimit);
        sb.append(", fixedSignLocation=").append(fixedSignLocation);
        sb.append(", longMsgExtraNum=").append(longMsgExtraNum);
        sb.append(", isAscllSupported=").append(isAscllSupported);
        sb.append(", ascllLenLimit=").append(ascllLenLimit);
        sb.append(", ascllSignLen=").append(ascllSignLen);
        sb.append(", isSendWithoutSign=").append(isSendWithoutSign);
        sb.append(", contentWithoutSign=").append(contentWithoutSign);
        sb.append(", minSaleCost=").append(minSaleCost);
        sb.append(", actualSalePrice=").append(actualSalePrice);
        sb.append(", saleCommissionProp=").append(saleCommissionProp);
        sb.append(", isabled=").append(isabled);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }


}