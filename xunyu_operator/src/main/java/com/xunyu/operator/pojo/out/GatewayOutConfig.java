package com.xunyu.operator.pojo.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * @author xym
 * @description
 * @date 2018/6/14 15:46
 */
public class GatewayOutConfig implements Serializable{
    private static final long serialVersionUID = 4754596805871079157L;
    /**
     * 主键
     */
    private Integer gatewayOutConfigId;

    /**
     *   运营商类型 1：移动 2：联通 3：电信
     */
    private Integer carrierType;

    /**
     *   客户id
     */
    private Integer customerId;

    /**
     *   用户类型  1：预付费，2：后付费
     */
    private Integer customerType;

    /**
     * 协议类型
     */
    private Integer carrierAgreeId;

    /**
     *   企业代码
     */
    private String enterpriseCode;

    /**
     *   接入类型  1:网关直连  2：网关分流
     */
    private Integer accessType;

    /**
     *   企业IP
     */
    private String enterpriseIp;

    /**
     *   企业端口
     */
    private Integer enterprisePort;

    /**
     *   企业用户名
     */
    private String enterpriseAccount;

    /**
     *   企业密码
     */
    private String enterprisePwd;

    /**
     *   赋给SP接入码
     */
    private String spAccessCode;

    /**
     *   上行短信接入码
     */
    private String msgAccessCode;

    /**
     *   下发转码接入码
     */
    private String transAccessCode;

    /**
     *   节点代码
     */
    private String nodeCode;
    /**
     *   网关固定签名位置  1：签名后置，2：签名前置，默认为1
     */
    private Integer fixedSignLocation;

    /**
     *   ASCII签名
     */
    private String ascllSign;

    /**
     *   服务代码
     */
    private String serviceCode;

    /**
     *   号码是否需要86，1：是，0：否，默认否
     */
    private Integer isNeedPrefix;

    /**
     *   MO模式，1：需要，0：不需要，默认0
     */
    private Integer moPattern;

    /**
     *   MO网关ID
     */
    private Integer moGatewayId;

    /**
     *   报告消息ID模式
     */
    private Integer reportMsgType;

    /**
     *   下发流量门限
     */
    private Integer sendFlowThreshold;

    /**
     *   报告回复推送流量门限
     */
    private Integer replyFlowThreshold;

    /**
     *   是否启用，1：是，0：否，废弃：2 默认1
     */
    private Integer isUsed;

    /**
     *   付费模式，1：预付费，2：后付费，默认1
     */
    private Integer payType;

    /**
     *   押金
     */
    private BigDecimal deposit;

    /**
     *   费率
     */
    private BigDecimal rate;

    /**
     *   在线充值起充条数
     */
    private Integer rechargeNumLimit;

    /**
     *   是否启用在线充值，1：是，0：否，默认1
     */
    private Integer isOnlineRechargeUsed;

    /**
     *   短信剩余条数
     */
    private Integer remainderMsgNum;

    /**
     *   质押条数
     */
    private Integer pledgeNum;

    /**
     *   信用率
     */
    private BigDecimal creditRate;

    /**
     *   审核模式
     */
    private Integer auditType;

    /**
     *   优先级
     */
    private Integer priority;

    /**
     *   最大连接数
     */
    private Integer maxConnectNum;

    /**
     *   启用时间
     */
    private Date useTime;

    /**
     *   失效时间
     */
    private Date invalidTime;

    /**
     *   是否强制签名，1：是，0：否，默认0
     */
    private Integer isForcedSign;

    /**
     *   签名内容
     */
    private String signContent;

    /**
     *   签名位置，1：签名后置，0：签名前置，默认1
     */
    private Integer signLocation;

    /**
     *   是否必须签名，1：是，0：否，默认0
     */
    private Integer isMustSign;

    /**
     *   审核条数
     */
    private Integer auditNum;

    /**
     *   是否启用黑名单，1：是，0：否，默认0
     */
    private Integer isUseBlacklist;

    /**
     *   是否启用白名单，1：是，0：否，默认0
     */
    private Integer isUseWhitelist;

    /**
     *   是否启用系统红白名单，1：是，0：否，默认0
     */
    private Integer isUseSysRedlistWhitelist;

    /**
     *   是否启用网关关键字拦截，1：是，0：否，默认0
     */
    private Integer isUseKeywordIncpt;

    /**
     *   SP长短信组包方式
     */
    private Integer longMsgPackType;

    /**
     *   是否自动返还，1:是，0：否，默认0
     */
    private Integer isAutoReturn;

    /**
     *   下发接入号超长是否截断，1：是，0：否，默认1
     */
    private Integer isIncptLongAccessCode;

    /**
     *   SP描述
     */
    private String spDesc;

    /**
     *   是否启用平台处理
     */
    private Integer isUsePlatformHandle;

    /**
     *   平台处理比例
     */
    private BigDecimal platformHandleProp;

    /**
     *   平台处理成功报告比例
     */
    private Long handleRepProp;

    /**
     *   平台处理成功报告实时比例
     */
    private Long handleRepRealtimeProp;

    /**
     *   平台处理成功报告回传时间
     */
    private Integer handleRepReturnTime;

    /**
     *   平台处理未知报告比例
     */
    private Long platformHandleUnknowProp;

    /**
     *   错号空号等成功比例
     */
    private Long wrongNumSucPorp;

    /**
     *   错号空号等未知比例
     */
    private Long wrongNumUnknowPorp;

    /**
     *   错误报告转成功比例
     */
    private Long wrongReportSucProp;

    /**
     *   是否启用超时改变状态，1：是，0：否，默认0
     */
    private Integer isUseOvertimeChange;

    /**
     *   改变状态超时比例
     */
    private Long changeOvertimeProp;

    /**
     *   改变状态超时时间开始，单位分钟
     */
    private Integer changeOvertimeStartTime;

    /**
     *   改变状态超时时间结束，单位：分钟
     */
    private Integer changeOvertimeEndTime;

    /**
     *   是否启用审核关键字，1：是，0：否，默认0
     */
    private Integer isUseAuditKeyword;

    /**
     *   用户号码发送限制条数
     */
    private Integer userSendLimit;

    /**
     *   是否启用号段分流，1：是，0：否，默认0
     */
    private Integer isUseNumShunt;

    /**
     *   是否启用余额短信提醒，1：是，0：否，默认0
     */
    private Integer isUseBalanceNotice;

    /**
     *   余额提醒条数
     */
    private Integer balNoticeNum;

    /**
     *   余额提醒内容
     */
    private String balNoticeContent;

    /**
     *   余额提醒间隔，单位：天
     */
    private Integer balNoticeInterval;

    /**
     *   余额提醒时间
     */
    private Time balNoticeTime;

    /**
     *   是否启用HTTP接口，1：是，0：否，默认0
     */
    private Integer isUseHttp;

    /**
     *   HTTP绑定IP地址
     */
    private String httpBindIp;

    /**
     *   是否启用推送，1：是，0：否，默认0
     */
    private Integer isUsePush;

    /**
     *   HTTP绑定推送回复地址
     */
    private String httpReplyAddress;

    /**
     *   HTTP绑定推送报告地址
     */
    private String httpReportAddress;

    /**
     *   HTTP绑定推送报告回复地址
     */
    private String httpReportReplyAddress;

    /**
     *   归属业务人员id
     */
    private Integer operatorId;

    /**
     *   可用状态标签。1：是，0：否，默认1
     */
    private Integer isabled;

    /**
     *   创建时间
     */
    private Date createTime;



    /**
     * This method returns the value of the database column tbl_gateway_out_config.gateway_out_config_id
     *
     * @return the value of tbl_gateway_out_config.gateway_out_config_id
     */
    public Integer getGatewayOutConfigId() {
        return gatewayOutConfigId;
    }

    /**
     */
    public GatewayOutConfig withGatewayOutConfigId(Integer gatewayOutConfigId) {
        this.setGatewayOutConfigId(gatewayOutConfigId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.gateway_out_config_id
     *
     * @param gatewayOutConfigId the value for tbl_gateway_out_config.gateway_out_config_id
     */
    public void setGatewayOutConfigId(Integer gatewayOutConfigId) {
        this.gatewayOutConfigId = gatewayOutConfigId;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.carrier_type
     *
     * @return the value of tbl_gateway_out_config.carrier_type
     */
    public Integer getCarrierType() {
        return carrierType;
    }

    /**
     */
    public GatewayOutConfig withCarrierType(Integer carrierType) {
        this.setCarrierType(carrierType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.carrier_type
     *
     * @param carrierType the value for tbl_gateway_out_config.carrier_type
     */
    public void setCarrierType(Integer carrierType) {
        this.carrierType = carrierType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.customer_id
     *
     * @return the value of tbl_gateway_out_config.customer_id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     */
    public GatewayOutConfig withCustomerId(Integer customerId) {
        this.setCustomerId(customerId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.customer_id
     *
     * @param customerId the value for tbl_gateway_out_config.customer_id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.customer_type
     *
     * @return the value of tbl_gateway_out_config.customer_type
     */
    public Integer getCustomerType() {
        return customerType;
    }

    /**
     */
    public GatewayOutConfig withCustomerType(Integer customerType) {
        this.setCustomerType(customerType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.customer_type
     *
     * @param customerType the value for tbl_gateway_out_config.customer_type
     */
    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.enterprise_code
     *
     * @return the value of tbl_gateway_out_config.enterprise_code
     */
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    /**
     */
    public GatewayOutConfig withEnterpriseCode(String enterpriseCode) {
        this.setEnterpriseCode(enterpriseCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.enterprise_code
     *
     * @param enterpriseCode the value for tbl_gateway_out_config.enterprise_code
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.access_type
     *
     * @return the value of tbl_gateway_out_config.access_type
     */
    public Integer getAccessType() {
        return accessType;
    }

    /**
     */
    public GatewayOutConfig withAccessType(Integer accessType) {
        this.setAccessType(accessType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.access_type
     *
     * @param accessType the value for tbl_gateway_out_config.access_type
     */
    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.enterprise_ip
     *
     * @return the value of tbl_gateway_out_config.enterprise_ip
     */
    public String getEnterpriseIp() {
        return enterpriseIp;
    }

    /**
     */
    public GatewayOutConfig withEnterpriseIp(String enterpriseIp) {
        this.setEnterpriseIp(enterpriseIp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.enterprise_ip
     *
     * @param enterpriseIp the value for tbl_gateway_out_config.enterprise_ip
     */
    public void setEnterpriseIp(String enterpriseIp) {
        this.enterpriseIp = enterpriseIp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.enterprise_port
     *
     * @return the value of tbl_gateway_out_config.enterprise_port
     */
    public Integer getEnterprisePort() {
        return enterprisePort;
    }

    /**
     */
    public GatewayOutConfig withEnterprisePort(Integer enterprisePort) {
        this.setEnterprisePort(enterprisePort);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.enterprise_port
     *
     * @param enterprisePort the value for tbl_gateway_out_config.enterprise_port
     */
    public void setEnterprisePort(Integer enterprisePort) {
        this.enterprisePort = enterprisePort;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.enterprise_account
     *
     * @return the value of tbl_gateway_out_config.enterprise_account
     */
    public String getEnterpriseAccount() {
        return enterpriseAccount;
    }

    /**
     */
    public GatewayOutConfig withEnterpriseAccount(String enterpriseAccount) {
        this.setEnterpriseAccount(enterpriseAccount);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.enterprise_account
     *
     * @param enterpriseAccount the value for tbl_gateway_out_config.enterprise_account
     */
    public void setEnterpriseAccount(String enterpriseAccount) {
        this.enterpriseAccount = enterpriseAccount;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.enterprise_pwd
     *
     * @return the value of tbl_gateway_out_config.enterprise_pwd
     */
    public String getEnterprisePwd() {
        return enterprisePwd;
    }

    /**
     */
    public GatewayOutConfig withEnterprisePwd(String enterprisePwd) {
        this.setEnterprisePwd(enterprisePwd);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.enterprise_pwd
     *
     * @param enterprisePwd the value for tbl_gateway_out_config.enterprise_pwd
     */
    public void setEnterprisePwd(String enterprisePwd) {
        this.enterprisePwd = enterprisePwd;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.sp_access_code
     *
     * @return the value of tbl_gateway_out_config.sp_access_code
     */
    public String getSpAccessCode() {
        return spAccessCode;
    }

    /**
     */
    public GatewayOutConfig withSpAccessCode(String spAccessCode) {
        this.setSpAccessCode(spAccessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.sp_access_code
     *
     * @param spAccessCode the value for tbl_gateway_out_config.sp_access_code
     */
    public void setSpAccessCode(String spAccessCode) {
        this.spAccessCode = spAccessCode;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.msg_access_code
     *
     * @return the value of tbl_gateway_out_config.msg_access_code
     */
    public String getMsgAccessCode() {
        return msgAccessCode;
    }

    /**
     */
    public GatewayOutConfig withMsgAccessCode(String msgAccessCode) {
        this.setMsgAccessCode(msgAccessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.msg_access_code
     *
     * @param msgAccessCode the value for tbl_gateway_out_config.msg_access_code
     */
    public void setMsgAccessCode(String msgAccessCode) {
        this.msgAccessCode = msgAccessCode;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.trans_access_code
     *
     * @return the value of tbl_gateway_out_config.trans_access_code
     */
    public String getTransAccessCode() {
        return transAccessCode;
    }

    /**
     */
    public GatewayOutConfig withTransAccessCode(String transAccessCode) {
        this.setTransAccessCode(transAccessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.trans_access_code
     *
     * @param transAccessCode the value for tbl_gateway_out_config.trans_access_code
     */
    public void setTransAccessCode(String transAccessCode) {
        this.transAccessCode = transAccessCode;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.node_code
     *
     * @return the value of tbl_gateway_out_config.node_code
     */
    public String getNodeCode() {
        return nodeCode;
    }

    /**
     */
    public GatewayOutConfig withNodeCode(String nodeCode) {
        this.setNodeCode(nodeCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.node_code
     *
     * @param nodeCode the value for tbl_gateway_out_config.node_code
     */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }


    /**
     * This method returns the value of the database column tbl_gateway_out_config.fixed_sign_location
     *
     * @return the value of tbl_gateway_out_config.fixed_sign_location
     */
    public Integer getFixedSignLocation() {
        return fixedSignLocation;
    }

    /**
     */
    public GatewayOutConfig withFixedSignLocation(Integer fixedSignLocation) {
        this.setFixedSignLocation(fixedSignLocation);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.fixed_sign_location
     *
     * @param fixedSignLocation the value for tbl_gateway_out_config.fixed_sign_location
     */
    public void setFixedSignLocation(Integer fixedSignLocation) {
        this.fixedSignLocation = fixedSignLocation;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.ascll_sign
     *
     * @return the value of tbl_gateway_out_config.ascll_sign
     */
    public String getAscllSign() {
        return ascllSign;
    }

    /**
     */
    public GatewayOutConfig withAscllSign(String ascllSign) {
        this.setAscllSign(ascllSign);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.ascll_sign
     *
     * @param ascllSign the value for tbl_gateway_out_config.ascll_sign
     */
    public void setAscllSign(String ascllSign) {
        this.ascllSign = ascllSign;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.service_code
     *
     * @return the value of tbl_gateway_out_config.service_code
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     */
    public GatewayOutConfig withServiceCode(String serviceCode) {
        this.setServiceCode(serviceCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.service_code
     *
     * @param serviceCode the value for tbl_gateway_out_config.service_code
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_need_prefix
     *
     * @return the value of tbl_gateway_out_config.is_need_prefix
     */
    public Integer getIsNeedPrefix() {
        return isNeedPrefix;
    }

    /**
     */
    public GatewayOutConfig withIsNeedPrefix(Integer isNeedPrefix) {
        this.setIsNeedPrefix(isNeedPrefix);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_need_prefix
     *
     * @param isNeedPrefix the value for tbl_gateway_out_config.is_need_prefix
     */
    public void setIsNeedPrefix(Integer isNeedPrefix) {
        this.isNeedPrefix = isNeedPrefix;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.mo_pattern
     *
     * @return the value of tbl_gateway_out_config.mo_pattern
     */
    public Integer getMoPattern() {
        return moPattern;
    }

    /**
     */
    public GatewayOutConfig withMoPattern(Integer moPattern) {
        this.setMoPattern(moPattern);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.mo_pattern
     *
     * @param moPattern the value for tbl_gateway_out_config.mo_pattern
     */
    public void setMoPattern(Integer moPattern) {
        this.moPattern = moPattern;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.mo_gateway_id
     *
     * @return the value of tbl_gateway_out_config.mo_gateway_id
     */
    public Integer getMoGatewayId() {
        return moGatewayId;
    }

    /**
     */
    public GatewayOutConfig withMoGatewayId(Integer moGatewayId) {
        this.setMoGatewayId(moGatewayId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.mo_gateway_id
     *
     * @param moGatewayId the value for tbl_gateway_out_config.mo_gateway_id
     */
    public void setMoGatewayId(Integer moGatewayId) {
        this.moGatewayId = moGatewayId;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.report_msg_type
     *
     * @return the value of tbl_gateway_out_config.report_msg_type
     */
    public Integer getReportMsgType() {
        return reportMsgType;
    }

    /**
     */
    public GatewayOutConfig withReportMsgType(Integer reportMsgType) {
        this.setReportMsgType(reportMsgType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.report_msg_type
     *
     * @param reportMsgType the value for tbl_gateway_out_config.report_msg_type
     */
    public void setReportMsgType(Integer reportMsgType) {
        this.reportMsgType = reportMsgType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.send_flow_threshold
     *
     * @return the value of tbl_gateway_out_config.send_flow_threshold
     */
    public Integer getSendFlowThreshold() {
        return sendFlowThreshold;
    }

    /**
     */
    public GatewayOutConfig withSendFlowThreshold(Integer sendFlowThreshold) {
        this.setSendFlowThreshold(sendFlowThreshold);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.send_flow_threshold
     *
     * @param sendFlowThreshold the value for tbl_gateway_out_config.send_flow_threshold
     */
    public void setSendFlowThreshold(Integer sendFlowThreshold) {
        this.sendFlowThreshold = sendFlowThreshold;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.reply_flow_threshold
     *
     * @return the value of tbl_gateway_out_config.reply_flow_threshold
     */
    public Integer getReplyFlowThreshold() {
        return replyFlowThreshold;
    }

    /**
     */
    public GatewayOutConfig withReplyFlowThreshold(Integer replyFlowThreshold) {
        this.setReplyFlowThreshold(replyFlowThreshold);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.reply_flow_threshold
     *
     * @param replyFlowThreshold the value for tbl_gateway_out_config.reply_flow_threshold
     */
    public void setReplyFlowThreshold(Integer replyFlowThreshold) {
        this.replyFlowThreshold = replyFlowThreshold;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_used
     *
     * @return the value of tbl_gateway_out_config.is_used
     */
    public Integer getIsUsed() {
        return isUsed;
    }

    /**
     */
    public GatewayOutConfig withIsUsed(Integer isUsed) {
        this.setIsUsed(isUsed);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_used
     *
     * @param isUsed the value for tbl_gateway_out_config.is_used
     */
    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.pay_type
     *
     * @return the value of tbl_gateway_out_config.pay_type
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     */
    public GatewayOutConfig withPayType(Integer payType) {
        this.setPayType(payType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.pay_type
     *
     * @param payType the value for tbl_gateway_out_config.pay_type
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.deposit
     *
     * @return the value of tbl_gateway_out_config.deposit
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     */
    public GatewayOutConfig withDeposit(BigDecimal deposit) {
        this.setDeposit(deposit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.deposit
     *
     * @param deposit the value for tbl_gateway_out_config.deposit
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.rate
     *
     * @return the value of tbl_gateway_out_config.rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     */
    public GatewayOutConfig withRate(BigDecimal rate) {
        this.setRate(rate);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.rate
     *
     * @param rate the value for tbl_gateway_out_config.rate
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.recharge_num_limit
     *
     * @return the value of tbl_gateway_out_config.recharge_num_limit
     */
    public Integer getRechargeNumLimit() {
        return rechargeNumLimit;
    }

    /**
     */
    public GatewayOutConfig withRechargeNumLimit(Integer rechargeNumLimit) {
        this.setRechargeNumLimit(rechargeNumLimit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.recharge_num_limit
     *
     * @param rechargeNumLimit the value for tbl_gateway_out_config.recharge_num_limit
     */
    public void setRechargeNumLimit(Integer rechargeNumLimit) {
        this.rechargeNumLimit = rechargeNumLimit;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_online_recharge_used
     *
     * @return the value of tbl_gateway_out_config.is_online_recharge_used
     */
    public Integer getIsOnlineRechargeUsed() {
        return isOnlineRechargeUsed;
    }

    /**
     */
    public GatewayOutConfig withIsOnlineRechargeUsed(Integer isOnlineRechargeUsed) {
        this.setIsOnlineRechargeUsed(isOnlineRechargeUsed);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_online_recharge_used
     *
     * @param isOnlineRechargeUsed the value for tbl_gateway_out_config.is_online_recharge_used
     */
    public void setIsOnlineRechargeUsed(Integer isOnlineRechargeUsed) {
        this.isOnlineRechargeUsed = isOnlineRechargeUsed;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.remainder_msg_num
     *
     * @return the value of tbl_gateway_out_config.remainder_msg_num
     */
    public Integer getRemainderMsgNum() {
        return remainderMsgNum;
    }

    /**
     */
    public GatewayOutConfig withRemainderMsgNum(Integer remainderMsgNum) {
        this.setRemainderMsgNum(remainderMsgNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.remainder_msg_num
     *
     * @param remainderMsgNum the value for tbl_gateway_out_config.remainder_msg_num
     */
    public void setRemainderMsgNum(Integer remainderMsgNum) {
        this.remainderMsgNum = remainderMsgNum;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.pledge_num
     *
     * @return the value of tbl_gateway_out_config.pledge_num
     */
    public Integer getPledgeNum() {
        return pledgeNum;
    }

    /**
     */
    public GatewayOutConfig withPledgeNum(Integer pledgeNum) {
        this.setPledgeNum(pledgeNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.pledge_num
     *
     * @param pledgeNum the value for tbl_gateway_out_config.pledge_num
     */
    public void setPledgeNum(Integer pledgeNum) {
        this.pledgeNum = pledgeNum;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.credit_rate
     *
     * @return the value of tbl_gateway_out_config.credit_rate
     */
    public BigDecimal getCreditRate() {
        return creditRate;
    }

    /**
     */
    public GatewayOutConfig withCreditRate(BigDecimal creditRate) {
        this.setCreditRate(creditRate);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.credit_rate
     *
     * @param creditRate the value for tbl_gateway_out_config.credit_rate
     */
    public void setCreditRate(BigDecimal creditRate) {
        this.creditRate = creditRate;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.audit_type
     *
     * @return the value of tbl_gateway_out_config.audit_type
     */
    public Integer getAuditType() {
        return auditType;
    }

    /**
     */
    public GatewayOutConfig withAuditType(Integer auditType) {
        this.setAuditType(auditType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.audit_type
     *
     * @param auditType the value for tbl_gateway_out_config.audit_type
     */
    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.priority
     *
     * @return the value of tbl_gateway_out_config.priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     */
    public GatewayOutConfig withPriority(Integer priority) {
        this.setPriority(priority);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.priority
     *
     * @param priority the value for tbl_gateway_out_config.priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.max_connect_num
     *
     * @return the value of tbl_gateway_out_config.max_connect_num
     */
    public Integer getMaxConnectNum() {
        return maxConnectNum;
    }

    /**
     */
    public GatewayOutConfig withMaxConnectNum(Integer maxConnectNum) {
        this.setMaxConnectNum(maxConnectNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.max_connect_num
     *
     * @param maxConnectNum the value for tbl_gateway_out_config.max_connect_num
     */
    public void setMaxConnectNum(Integer maxConnectNum) {
        this.maxConnectNum = maxConnectNum;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.use_time
     *
     * @return the value of tbl_gateway_out_config.use_time
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     */
    public GatewayOutConfig withUseTime(Date useTime) {
        this.setUseTime(useTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.use_time
     *
     * @param useTime the value for tbl_gateway_out_config.use_time
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.invalid_time
     *
     * @return the value of tbl_gateway_out_config.invalid_time
     */
    public Date getInvalidTime() {
        return invalidTime;
    }

    /**
     */
    public GatewayOutConfig withInvalidTime(Date invalidTime) {
        this.setInvalidTime(invalidTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.invalid_time
     *
     * @param invalidTime the value for tbl_gateway_out_config.invalid_time
     */
    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_forced_sign
     *
     * @return the value of tbl_gateway_out_config.is_forced_sign
     */
    public Integer getIsForcedSign() {
        return isForcedSign;
    }

    /**
     */
    public GatewayOutConfig withIsForcedSign(Integer isForcedSign) {
        this.setIsForcedSign(isForcedSign);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_forced_sign
     *
     * @param isForcedSign the value for tbl_gateway_out_config.is_forced_sign
     */
    public void setIsForcedSign(Integer isForcedSign) {
        this.isForcedSign = isForcedSign;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.sign_content
     *
     * @return the value of tbl_gateway_out_config.sign_content
     */
    public String getSignContent() {
        return signContent;
    }

    /**
     */
    public GatewayOutConfig withSignContent(String signContent) {
        this.setSignContent(signContent);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.sign_content
     *
     * @param signContent the value for tbl_gateway_out_config.sign_content
     */
    public void setSignContent(String signContent) {
        this.signContent = signContent;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.sign_location
     *
     * @return the value of tbl_gateway_out_config.sign_location
     */
    public Integer getSignLocation() {
        return signLocation;
    }

    /**
     */
    public GatewayOutConfig withSignLocation(Integer signLocation) {
        this.setSignLocation(signLocation);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.sign_location
     *
     * @param signLocation the value for tbl_gateway_out_config.sign_location
     */
    public void setSignLocation(Integer signLocation) {
        this.signLocation = signLocation;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_must_sign
     *
     * @return the value of tbl_gateway_out_config.is_must_sign
     */
    public Integer getIsMustSign() {
        return isMustSign;
    }

    /**
     */
    public GatewayOutConfig withIsMustSign(Integer isMustSign) {
        this.setIsMustSign(isMustSign);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_must_sign
     *
     * @param isMustSign the value for tbl_gateway_out_config.is_must_sign
     */
    public void setIsMustSign(Integer isMustSign) {
        this.isMustSign = isMustSign;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.audit_num
     *
     * @return the value of tbl_gateway_out_config.audit_num
     */
    public Integer getAuditNum() {
        return auditNum;
    }

    /**
     */
    public GatewayOutConfig withAuditNum(Integer auditNum) {
        this.setAuditNum(auditNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.audit_num
     *
     * @param auditNum the value for tbl_gateway_out_config.audit_num
     */
    public void setAuditNum(Integer auditNum) {
        this.auditNum = auditNum;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_blacklist
     *
     * @return the value of tbl_gateway_out_config.is_use_blacklist
     */
    public Integer getIsUseBlacklist() {
        return isUseBlacklist;
    }

    /**
     */
    public GatewayOutConfig withIsUseBlacklist(Integer isUseBlacklist) {
        this.setIsUseBlacklist(isUseBlacklist);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_blacklist
     *
     * @param isUseBlacklist the value for tbl_gateway_out_config.is_use_blacklist
     */
    public void setIsUseBlacklist(Integer isUseBlacklist) {
        this.isUseBlacklist = isUseBlacklist;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_whitelist
     *
     * @return the value of tbl_gateway_out_config.is_use_whitelist
     */
    public Integer getIsUseWhitelist() {
        return isUseWhitelist;
    }

    /**
     */
    public GatewayOutConfig withIsUseWhitelist(Integer isUseWhitelist) {
        this.setIsUseWhitelist(isUseWhitelist);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_whitelist
     *
     * @param isUseWhitelist the value for tbl_gateway_out_config.is_use_whitelist
     */
    public void setIsUseWhitelist(Integer isUseWhitelist) {
        this.isUseWhitelist = isUseWhitelist;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_sys_redlist_whitelist
     *
     * @return the value of tbl_gateway_out_config.is_use_sys_redlist_whitelist
     */
    public Integer getIsUseSysRedlistWhitelist() {
        return isUseSysRedlistWhitelist;
    }

    /**
     */
    public GatewayOutConfig withIsUseSysRedlistWhitelist(Integer isUseSysRedlistWhitelist) {
        this.setIsUseSysRedlistWhitelist(isUseSysRedlistWhitelist);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_sys_redlist_whitelist
     *
     * @param isUseSysRedlistWhitelist the value for tbl_gateway_out_config.is_use_sys_redlist_whitelist
     */
    public void setIsUseSysRedlistWhitelist(Integer isUseSysRedlistWhitelist) {
        this.isUseSysRedlistWhitelist = isUseSysRedlistWhitelist;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_keyword_incpt
     *
     * @return the value of tbl_gateway_out_config.is_use_keyword_incpt
     */
    public Integer getIsUseKeywordIncpt() {
        return isUseKeywordIncpt;
    }

    /**
     */
    public GatewayOutConfig withIsUseKeywordIncpt(Integer isUseKeywordIncpt) {
        this.setIsUseKeywordIncpt(isUseKeywordIncpt);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_keyword_incpt
     *
     * @param isUseKeywordIncpt the value for tbl_gateway_out_config.is_use_keyword_incpt
     */
    public void setIsUseKeywordIncpt(Integer isUseKeywordIncpt) {
        this.isUseKeywordIncpt = isUseKeywordIncpt;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.long_msg_pack_type
     *
     * @return the value of tbl_gateway_out_config.long_msg_pack_type
     */
    public Integer getLongMsgPackType() {
        return longMsgPackType;
    }

    /**
     */
    public GatewayOutConfig withLongMsgPackType(Integer longMsgPackType) {
        this.setLongMsgPackType(longMsgPackType);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.long_msg_pack_type
     *
     * @param longMsgPackType the value for tbl_gateway_out_config.long_msg_pack_type
     */
    public void setLongMsgPackType(Integer longMsgPackType) {
        this.longMsgPackType = longMsgPackType;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_auto_return
     *
     * @return the value of tbl_gateway_out_config.is_auto_return
     */
    public Integer getIsAutoReturn() {
        return isAutoReturn;
    }

    /**
     */
    public GatewayOutConfig withIsAutoReturn(Integer isAutoReturn) {
        this.setIsAutoReturn(isAutoReturn);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_auto_return
     *
     * @param isAutoReturn the value for tbl_gateway_out_config.is_auto_return
     */
    public void setIsAutoReturn(Integer isAutoReturn) {
        this.isAutoReturn = isAutoReturn;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_incpt_long_access_code
     *
     * @return the value of tbl_gateway_out_config.is_incpt_long_access_code
     */
    public Integer getIsIncptLongAccessCode() {
        return isIncptLongAccessCode;
    }

    /**
     */
    public GatewayOutConfig withIsIncptLongAccessCode(Integer isIncptLongAccessCode) {
        this.setIsIncptLongAccessCode(isIncptLongAccessCode);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_incpt_long_access_code
     *
     * @param isIncptLongAccessCode the value for tbl_gateway_out_config.is_incpt_long_access_code
     */
    public void setIsIncptLongAccessCode(Integer isIncptLongAccessCode) {
        this.isIncptLongAccessCode = isIncptLongAccessCode;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.sp_desc
     *
     * @return the value of tbl_gateway_out_config.sp_desc
     */
    public String getSpDesc() {
        return spDesc;
    }

    /**
     */
    public GatewayOutConfig withSpDesc(String spDesc) {
        this.setSpDesc(spDesc);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.sp_desc
     *
     * @param spDesc the value for tbl_gateway_out_config.sp_desc
     */
    public void setSpDesc(String spDesc) {
        this.spDesc = spDesc;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_platform_handle
     *
     * @return the value of tbl_gateway_out_config.is_use_platform_handle
     */
    public Integer getIsUsePlatformHandle() {
        return isUsePlatformHandle;
    }

    /**
     */
    public GatewayOutConfig withIsUsePlatformHandle(Integer isUsePlatformHandle) {
        this.setIsUsePlatformHandle(isUsePlatformHandle);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_platform_handle
     *
     * @param isUsePlatformHandle the value for tbl_gateway_out_config.is_use_platform_handle
     */
    public void setIsUsePlatformHandle(Integer isUsePlatformHandle) {
        this.isUsePlatformHandle = isUsePlatformHandle;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.platform_handle_prop
     *
     * @return the value of tbl_gateway_out_config.platform_handle_prop
     */
    public BigDecimal getPlatformHandleProp() {
        return platformHandleProp;
    }

    /**
     */
    public GatewayOutConfig withPlatformHandleProp(BigDecimal platformHandleProp) {
        this.setPlatformHandleProp(platformHandleProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.platform_handle_prop
     *
     * @param platformHandleProp the value for tbl_gateway_out_config.platform_handle_prop
     */
    public void setPlatformHandleProp(BigDecimal platformHandleProp) {
        this.platformHandleProp = platformHandleProp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.handle_rep_prop
     *
     * @return the value of tbl_gateway_out_config.handle_rep_prop
     */
    public Long getHandleRepProp() {
        return handleRepProp;
    }

    /**
     */
    public GatewayOutConfig withHandleRepProp(Long handleRepProp) {
        this.setHandleRepProp(handleRepProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.handle_rep_prop
     *
     * @param handleRepProp the value for tbl_gateway_out_config.handle_rep_prop
     */
    public void setHandleRepProp(Long handleRepProp) {
        this.handleRepProp = handleRepProp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.handle_rep_realtime_prop
     *
     * @return the value of tbl_gateway_out_config.handle_rep_realtime_prop
     */
    public Long getHandleRepRealtimeProp() {
        return handleRepRealtimeProp;
    }

    /**
     */
    public GatewayOutConfig withHandleRepRealtimeProp(Long handleRepRealtimeProp) {
        this.setHandleRepRealtimeProp(handleRepRealtimeProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.handle_rep_realtime_prop
     *
     * @param handleRepRealtimeProp the value for tbl_gateway_out_config.handle_rep_realtime_prop
     */
    public void setHandleRepRealtimeProp(Long handleRepRealtimeProp) {
        this.handleRepRealtimeProp = handleRepRealtimeProp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.handle_rep_return_time
     *
     * @return the value of tbl_gateway_out_config.handle_rep_return_time
     */
    public Integer getHandleRepReturnTime() {
        return handleRepReturnTime;
    }

    /**
     */
    public GatewayOutConfig withHandleRepReturnTime(Integer handleRepReturnTime) {
        this.setHandleRepReturnTime(handleRepReturnTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.handle_rep_return_time
     *
     * @param handleRepReturnTime the value for tbl_gateway_out_config.handle_rep_return_time
     */
    public void setHandleRepReturnTime(Integer handleRepReturnTime) {
        this.handleRepReturnTime = handleRepReturnTime;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.platform_handle_unknow_prop
     *
     * @return the value of tbl_gateway_out_config.platform_handle_unknow_prop
     */
    public Long getPlatformHandleUnknowProp() {
        return platformHandleUnknowProp;
    }

    /**
     */
    public GatewayOutConfig withPlatformHandleUnknowProp(Long platformHandleUnknowProp) {
        this.setPlatformHandleUnknowProp(platformHandleUnknowProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.platform_handle_unknow_prop
     *
     * @param platformHandleUnknowProp the value for tbl_gateway_out_config.platform_handle_unknow_prop
     */
    public void setPlatformHandleUnknowProp(Long platformHandleUnknowProp) {
        this.platformHandleUnknowProp = platformHandleUnknowProp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.wrong_num_suc_porp
     *
     * @return the value of tbl_gateway_out_config.wrong_num_suc_porp
     */
    public Long getWrongNumSucPorp() {
        return wrongNumSucPorp;
    }

    /**
     */
    public GatewayOutConfig withWrongNumSucPorp(Long wrongNumSucPorp) {
        this.setWrongNumSucPorp(wrongNumSucPorp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.wrong_num_suc_porp
     *
     * @param wrongNumSucPorp the value for tbl_gateway_out_config.wrong_num_suc_porp
     */
    public void setWrongNumSucPorp(Long wrongNumSucPorp) {
        this.wrongNumSucPorp = wrongNumSucPorp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.wrong_num_unknow_porp
     *
     * @return the value of tbl_gateway_out_config.wrong_num_unknow_porp
     */
    public Long getWrongNumUnknowPorp() {
        return wrongNumUnknowPorp;
    }

    /**
     */
    public GatewayOutConfig withWrongNumUnknowPorp(Long wrongNumUnknowPorp) {
        this.setWrongNumUnknowPorp(wrongNumUnknowPorp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.wrong_num_unknow_porp
     *
     * @param wrongNumUnknowPorp the value for tbl_gateway_out_config.wrong_num_unknow_porp
     */
    public void setWrongNumUnknowPorp(Long wrongNumUnknowPorp) {
        this.wrongNumUnknowPorp = wrongNumUnknowPorp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.wrong_report_suc_prop
     *
     * @return the value of tbl_gateway_out_config.wrong_report_suc_prop
     */
    public Long getWrongReportSucProp() {
        return wrongReportSucProp;
    }

    /**
     */
    public GatewayOutConfig withWrongReportSucProp(Long wrongReportSucProp) {
        this.setWrongReportSucProp(wrongReportSucProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.wrong_report_suc_prop
     *
     * @param wrongReportSucProp the value for tbl_gateway_out_config.wrong_report_suc_prop
     */
    public void setWrongReportSucProp(Long wrongReportSucProp) {
        this.wrongReportSucProp = wrongReportSucProp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_overtime_change
     *
     * @return the value of tbl_gateway_out_config.is_use_overtime_change
     */
    public Integer getIsUseOvertimeChange() {
        return isUseOvertimeChange;
    }

    /**
     */
    public GatewayOutConfig withIsUseOvertimeChange(Integer isUseOvertimeChange) {
        this.setIsUseOvertimeChange(isUseOvertimeChange);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_overtime_change
     *
     * @param isUseOvertimeChange the value for tbl_gateway_out_config.is_use_overtime_change
     */
    public void setIsUseOvertimeChange(Integer isUseOvertimeChange) {
        this.isUseOvertimeChange = isUseOvertimeChange;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.change_overtime_prop
     *
     * @return the value of tbl_gateway_out_config.change_overtime_prop
     */
    public Long getChangeOvertimeProp() {
        return changeOvertimeProp;
    }

    /**
     */
    public GatewayOutConfig withChangeOvertimeProp(Long changeOvertimeProp) {
        this.setChangeOvertimeProp(changeOvertimeProp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.change_overtime_prop
     *
     * @param changeOvertimeProp the value for tbl_gateway_out_config.change_overtime_prop
     */
    public void setChangeOvertimeProp(Long changeOvertimeProp) {
        this.changeOvertimeProp = changeOvertimeProp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.change_overtime_start_time
     *
     * @return the value of tbl_gateway_out_config.change_overtime_start_time
     */
    public Integer getChangeOvertimeStartTime() {
        return changeOvertimeStartTime;
    }

    /**
     */
    public GatewayOutConfig withChangeOvertimeStartTime(Integer changeOvertimeStartTime) {
        this.setChangeOvertimeStartTime(changeOvertimeStartTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.change_overtime_start_time
     *
     * @param changeOvertimeStartTime the value for tbl_gateway_out_config.change_overtime_start_time
     */
    public void setChangeOvertimeStartTime(Integer changeOvertimeStartTime) {
        this.changeOvertimeStartTime = changeOvertimeStartTime;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.change_overtime_end_time
     *
     * @return the value of tbl_gateway_out_config.change_overtime_end_time
     */
    public Integer getChangeOvertimeEndTime() {
        return changeOvertimeEndTime;
    }

    /**
     */
    public GatewayOutConfig withChangeOvertimeEndTime(Integer changeOvertimeEndTime) {
        this.setChangeOvertimeEndTime(changeOvertimeEndTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.change_overtime_end_time
     *
     * @param changeOvertimeEndTime the value for tbl_gateway_out_config.change_overtime_end_time
     */
    public void setChangeOvertimeEndTime(Integer changeOvertimeEndTime) {
        this.changeOvertimeEndTime = changeOvertimeEndTime;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_audit_keyword
     *
     * @return the value of tbl_gateway_out_config.is_use_audit_keyword
     */
    public Integer getIsUseAuditKeyword() {
        return isUseAuditKeyword;
    }

    /**
     */
    public GatewayOutConfig withIsUseAuditKeyword(Integer isUseAuditKeyword) {
        this.setIsUseAuditKeyword(isUseAuditKeyword);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_audit_keyword
     *
     * @param isUseAuditKeyword the value for tbl_gateway_out_config.is_use_audit_keyword
     */
    public void setIsUseAuditKeyword(Integer isUseAuditKeyword) {
        this.isUseAuditKeyword = isUseAuditKeyword;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.user_send_limit
     *
     * @return the value of tbl_gateway_out_config.user_send_limit
     */
    public Integer getUserSendLimit() {
        return userSendLimit;
    }

    /**
     */
    public GatewayOutConfig withUserSendLimit(Integer userSendLimit) {
        this.setUserSendLimit(userSendLimit);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.user_send_limit
     *
     * @param userSendLimit the value for tbl_gateway_out_config.user_send_limit
     */
    public void setUserSendLimit(Integer userSendLimit) {
        this.userSendLimit = userSendLimit;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_num_shunt
     *
     * @return the value of tbl_gateway_out_config.is_use_num_shunt
     */
    public Integer getIsUseNumShunt() {
        return isUseNumShunt;
    }

    /**
     */
    public GatewayOutConfig withIsUseNumShunt(Integer isUseNumShunt) {
        this.setIsUseNumShunt(isUseNumShunt);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_num_shunt
     *
     * @param isUseNumShunt the value for tbl_gateway_out_config.is_use_num_shunt
     */
    public void setIsUseNumShunt(Integer isUseNumShunt) {
        this.isUseNumShunt = isUseNumShunt;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_balance_notice
     *
     * @return the value of tbl_gateway_out_config.is_use_balance_notice
     */
    public Integer getIsUseBalanceNotice() {
        return isUseBalanceNotice;
    }

    /**
     */
    public GatewayOutConfig withIsUseBalanceNotice(Integer isUseBalanceNotice) {
        this.setIsUseBalanceNotice(isUseBalanceNotice);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_balance_notice
     *
     * @param isUseBalanceNotice the value for tbl_gateway_out_config.is_use_balance_notice
     */
    public void setIsUseBalanceNotice(Integer isUseBalanceNotice) {
        this.isUseBalanceNotice = isUseBalanceNotice;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.bal_notice_num
     *
     * @return the value of tbl_gateway_out_config.bal_notice_num
     */
    public Integer getBalNoticeNum() {
        return balNoticeNum;
    }

    /**
     */
    public GatewayOutConfig withBalNoticeNum(Integer balNoticeNum) {
        this.setBalNoticeNum(balNoticeNum);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.bal_notice_num
     *
     * @param balNoticeNum the value for tbl_gateway_out_config.bal_notice_num
     */
    public void setBalNoticeNum(Integer balNoticeNum) {
        this.balNoticeNum = balNoticeNum;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.bal_notice_content
     *
     * @return the value of tbl_gateway_out_config.bal_notice_content
     */
    public String getBalNoticeContent() {
        return balNoticeContent;
    }

    /**
     */
    public GatewayOutConfig withBalNoticeContent(String balNoticeContent) {
        this.setBalNoticeContent(balNoticeContent);
        return this;
    }

    public Integer getCarrierAgreeId() {
        return carrierAgreeId;
    }

    public void setCarrierAgreeId(Integer carrierAgreeId) {
        this.carrierAgreeId = carrierAgreeId;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.bal_notice_content
     *
     * @param balNoticeContent the value for tbl_gateway_out_config.bal_notice_content
     */
    public void setBalNoticeContent(String balNoticeContent) {
        this.balNoticeContent = balNoticeContent;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.bal_notice_interval
     *
     * @return the value of tbl_gateway_out_config.bal_notice_interval
     */
    public Integer getBalNoticeInterval() {
        return balNoticeInterval;
    }

    /**
     */
    public GatewayOutConfig withBalNoticeInterval(Integer balNoticeInterval) {
        this.setBalNoticeInterval(balNoticeInterval);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.bal_notice_interval
     *
     * @param balNoticeInterval the value for tbl_gateway_out_config.bal_notice_interval
     */
    public void setBalNoticeInterval(Integer balNoticeInterval) {
        this.balNoticeInterval = balNoticeInterval;
    }

    public Time getBalNoticeTime() {
        return balNoticeTime;
    }

    public void setBalNoticeTime(Time balNoticeTime) {
        this.balNoticeTime = balNoticeTime;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_http
     *
     * @return the value of tbl_gateway_out_config.is_use_http
     */
    public Integer getIsUseHttp() {
        return isUseHttp;
    }

    /**
     */
    public GatewayOutConfig withIsUseHttp(Integer isUseHttp) {
        this.setIsUseHttp(isUseHttp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_http
     *
     * @param isUseHttp the value for tbl_gateway_out_config.is_use_http
     */
    public void setIsUseHttp(Integer isUseHttp) {
        this.isUseHttp = isUseHttp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.http_bind_ip
     *
     * @return the value of tbl_gateway_out_config.http_bind_ip
     */
    public String getHttpBindIp() {
        return httpBindIp;
    }

    /**
     */
    public GatewayOutConfig withHttpBindIp(String httpBindIp) {
        this.setHttpBindIp(httpBindIp);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.http_bind_ip
     *
     * @param httpBindIp the value for tbl_gateway_out_config.http_bind_ip
     */
    public void setHttpBindIp(String httpBindIp) {
        this.httpBindIp = httpBindIp;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.is_use_push
     *
     * @return the value of tbl_gateway_out_config.is_use_push
     */
    public Integer getIsUsePush() {
        return isUsePush;
    }

    /**
     */
    public GatewayOutConfig withIsUsePush(Integer isUsePush) {
        this.setIsUsePush(isUsePush);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.is_use_push
     *
     * @param isUsePush the value for tbl_gateway_out_config.is_use_push
     */
    public void setIsUsePush(Integer isUsePush) {
        this.isUsePush = isUsePush;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.http_reply_address
     *
     * @return the value of tbl_gateway_out_config.http_reply_address
     */
    public String getHttpReplyAddress() {
        return httpReplyAddress;
    }

    /**
     */
    public GatewayOutConfig withHttpReplyAddress(String httpReplyAddress) {
        this.setHttpReplyAddress(httpReplyAddress);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.http_reply_address
     *
     * @param httpReplyAddress the value for tbl_gateway_out_config.http_reply_address
     */
    public void setHttpReplyAddress(String httpReplyAddress) {
        this.httpReplyAddress = httpReplyAddress;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.http_report_address
     *
     * @return the value of tbl_gateway_out_config.http_report_address
     */
    public String getHttpReportAddress() {
        return httpReportAddress;
    }

    /**
     */
    public GatewayOutConfig withHttpReportAddress(String httpReportAddress) {
        this.setHttpReportAddress(httpReportAddress);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.http_report_address
     *
     * @param httpReportAddress the value for tbl_gateway_out_config.http_report_address
     */
    public void setHttpReportAddress(String httpReportAddress) {
        this.httpReportAddress = httpReportAddress;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.http_report_reply_address
     *
     * @return the value of tbl_gateway_out_config.http_report_reply_address
     */
    public String getHttpReportReplyAddress() {
        return httpReportReplyAddress;
    }

    /**
     */
    public GatewayOutConfig withHttpReportReplyAddress(String httpReportReplyAddress) {
        this.setHttpReportReplyAddress(httpReportReplyAddress);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.http_report_reply_address
     *
     * @param httpReportReplyAddress the value for tbl_gateway_out_config.http_report_reply_address
     */
    public void setHttpReportReplyAddress(String httpReportReplyAddress) {
        this.httpReportReplyAddress = httpReportReplyAddress;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.operator_id
     *
     * @return the value of tbl_gateway_out_config.operator_id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     */
    public GatewayOutConfig withOperatorId(Integer operatorId) {
        this.setOperatorId(operatorId);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.operator_id
     *
     * @param operatorId the value for tbl_gateway_out_config.operator_id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.isabled
     *
     * @return the value of tbl_gateway_out_config.isabled
     */
    public Integer getIsabled() {
        return isabled;
    }

    /**
     */
    public GatewayOutConfig withIsabled(Integer isabled) {
        this.setIsabled(isabled);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.isabled
     *
     * @param isabled the value for tbl_gateway_out_config.isabled
     */
    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    /**
     * This method returns the value of the database column tbl_gateway_out_config.create_time
     *
     * @return the value of tbl_gateway_out_config.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     */
    public GatewayOutConfig withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method sets the value of the database column tbl_gateway_out_config.create_time
     *
     * @param createTime the value for tbl_gateway_out_config.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     */



}