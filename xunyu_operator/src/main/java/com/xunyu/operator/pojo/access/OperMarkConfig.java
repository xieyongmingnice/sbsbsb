package com.xunyu.operator.pojo.access;

/**
 * @author dth
 * @date 2018/6/11 11:28
 **/
public class OperMarkConfig{

    private Long markId;//主键
    private Long configId;//核心配置id
    private String gatewayText;//网关描述
    private double purchasePrice;//网关进价成本
    private double salesCost;//最低销售成本
    private String gatewayNumber;//网关号段

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getGatewayText() {
        return gatewayText;
    }

    public void setGatewayText(String gatewayText) {
        this.gatewayText = gatewayText;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalesCost() {
        return salesCost;
    }

    public void setSalesCost(double salesCost) {
        this.salesCost = salesCost;
    }

    public String getGatewayNumber() {
        return gatewayNumber;
    }

    public void setGatewayNumber(String gatewayNumber) {
        this.gatewayNumber = gatewayNumber;
    }
}
