package com.xunyu.model.operator.out;

import com.xunyu.model.user.UserModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 网关接出配置参数类
 * @date 2018/6/12 13:49
 */
public class GatewayOutConfigModel extends UserModel implements Serializable {

    private static final long serialVersionUID = 7055384099306513477L;
    /**
     * 主键
     */
    private Integer tblGatewayOutConfigId;

    /**
     *   客户id
     */
    private Integer customerId;

    /**
     *   用户类型 1：预付费，2：后付费
     */
    private Integer customerType;

    /**
     *   企业代码
     */
    private String enterpriseCode;

    /**
     *   接入类型
     */
    private Integer accessType;

    /**
     *   协议类型
     */
    private Integer agreeType;

    /**
     *   网关节点
     */
    private String gatewayNode;

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
     *   网关接入码
     */
    private String gatewayAccessCode;

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
     *   ASCII签名
     */
    private String ascllSign;

    /**
     *   服务代码
     */
    private String serviceCode;

    /**
     *   是否去签名发送，1：是，0：否，默认否
     */
    private Integer isSendWithoutSign;

    /**
     *   发送去签名内容
     */
    private String contentWithoutSign;

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
     *   是否启用，1：是，0：否，默认1
     */
    private Integer isUsed;

    /**
     *   付费模式，1：预付费，2：后付费，默认1
     */
    private Integer payType;

    /**
     *   押金
     */
    private Long deposit;

    /**
     *   费率
     */
    private Long rate;

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
    private Long creditRate;

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
     *   业务最低销售成本
     */
    private Long minSaleCost;

    /**
     *   业务销售实际价格
     */
    private Long actualSalePrice;

    /**
     *   业务销售提成比例
     */
    private Long saleCommissionProp;

    /**
     *   是否启用平台处理
     */
    private Integer isUsePlatformHandle;

    /**
     *   平台处理比例
     */
    private Long platformHandleProp;

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
    private Date balNoticeTime;

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
     * 归属业务人员id
     */
    private Integer operatorId;

    /**
     *   是否有效标志。1：是，0：否，默认1
     */
    private Integer isabled;

    /**
     *   创建时间
     */
    private Date createTime;

    public Integer getTblGatewayOutConfigId() {
        return tblGatewayOutConfigId;
    }

    public void setTblGatewayOutConfigId(Integer tblGatewayOutConfigId) {
        this.tblGatewayOutConfigId = tblGatewayOutConfigId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Integer getAgreeType() {
        return agreeType;
    }

    public void setAgreeType(Integer agreeType) {
        this.agreeType = agreeType;
    }

    public String getGatewayNode() {
        return gatewayNode;
    }

    public void setGatewayNode(String gatewayNode) {
        this.gatewayNode = gatewayNode;
    }

    public String getEnterpriseIp() {
        return enterpriseIp;
    }

    public void setEnterpriseIp(String enterpriseIp) {
        this.enterpriseIp = enterpriseIp;
    }

    public Integer getEnterprisePort() {
        return enterprisePort;
    }

    public void setEnterprisePort(Integer enterprisePort) {
        this.enterprisePort = enterprisePort;
    }

    public String getEnterpriseAccount() {
        return enterpriseAccount;
    }

    public void setEnterpriseAccount(String enterpriseAccount) {
        this.enterpriseAccount = enterpriseAccount;
    }

    public String getEnterprisePwd() {
        return enterprisePwd;
    }

    public void setEnterprisePwd(String enterprisePwd) {
        this.enterprisePwd = enterprisePwd;
    }

    public String getGatewayAccessCode() {
        return gatewayAccessCode;
    }

    public void setGatewayAccessCode(String gatewayAccessCode) {
        this.gatewayAccessCode = gatewayAccessCode;
    }

    public String getSpAccessCode() {
        return spAccessCode;
    }

    public void setSpAccessCode(String spAccessCode) {
        this.spAccessCode = spAccessCode;
    }

    public String getMsgAccessCode() {
        return msgAccessCode;
    }

    public void setMsgAccessCode(String msgAccessCode) {
        this.msgAccessCode = msgAccessCode;
    }

    public String getTransAccessCode() {
        return transAccessCode;
    }

    public void setTransAccessCode(String transAccessCode) {
        this.transAccessCode = transAccessCode;
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

    public String getAscllSign() {
        return ascllSign;
    }

    public void setAscllSign(String ascllSign) {
        this.ascllSign = ascllSign;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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

    public Integer getIsNeedPrefix() {
        return isNeedPrefix;
    }

    public void setIsNeedPrefix(Integer isNeedPrefix) {
        this.isNeedPrefix = isNeedPrefix;
    }

    public Integer getMoPattern() {
        return moPattern;
    }

    public void setMoPattern(Integer moPattern) {
        this.moPattern = moPattern;
    }

    public Integer getMoGatewayId() {
        return moGatewayId;
    }

    public void setMoGatewayId(Integer moGatewayId) {
        this.moGatewayId = moGatewayId;
    }

    public Integer getReportMsgType() {
        return reportMsgType;
    }

    public void setReportMsgType(Integer reportMsgType) {
        this.reportMsgType = reportMsgType;
    }

    public Integer getSendFlowThreshold() {
        return sendFlowThreshold;
    }

    public void setSendFlowThreshold(Integer sendFlowThreshold) {
        this.sendFlowThreshold = sendFlowThreshold;
    }

    public Integer getReplyFlowThreshold() {
        return replyFlowThreshold;
    }

    public void setReplyFlowThreshold(Integer replyFlowThreshold) {
        this.replyFlowThreshold = replyFlowThreshold;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Integer getRechargeNumLimit() {
        return rechargeNumLimit;
    }

    public void setRechargeNumLimit(Integer rechargeNumLimit) {
        this.rechargeNumLimit = rechargeNumLimit;
    }

    public Integer getIsOnlineRechargeUsed() {
        return isOnlineRechargeUsed;
    }

    public void setIsOnlineRechargeUsed(Integer isOnlineRechargeUsed) {
        this.isOnlineRechargeUsed = isOnlineRechargeUsed;
    }

    public Integer getRemainderMsgNum() {
        return remainderMsgNum;
    }

    public void setRemainderMsgNum(Integer remainderMsgNum) {
        this.remainderMsgNum = remainderMsgNum;
    }

    public Integer getPledgeNum() {
        return pledgeNum;
    }

    public void setPledgeNum(Integer pledgeNum) {
        this.pledgeNum = pledgeNum;
    }

    public Long getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Long creditRate) {
        this.creditRate = creditRate;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getMaxConnectNum() {
        return maxConnectNum;
    }

    public void setMaxConnectNum(Integer maxConnectNum) {
        this.maxConnectNum = maxConnectNum;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Integer getIsForcedSign() {
        return isForcedSign;
    }

    public void setIsForcedSign(Integer isForcedSign) {
        this.isForcedSign = isForcedSign;
    }

    public String getSignContent() {
        return signContent;
    }

    public void setSignContent(String signContent) {
        this.signContent = signContent;
    }

    public Integer getSignLocation() {
        return signLocation;
    }

    public void setSignLocation(Integer signLocation) {
        this.signLocation = signLocation;
    }

    public Integer getIsMustSign() {
        return isMustSign;
    }

    public void setIsMustSign(Integer isMustSign) {
        this.isMustSign = isMustSign;
    }

    public Integer getAuditNum() {
        return auditNum;
    }

    public void setAuditNum(Integer auditNum) {
        this.auditNum = auditNum;
    }

    public Integer getIsUseBlacklist() {
        return isUseBlacklist;
    }

    public void setIsUseBlacklist(Integer isUseBlacklist) {
        this.isUseBlacklist = isUseBlacklist;
    }

    public Integer getIsUseWhitelist() {
        return isUseWhitelist;
    }

    public void setIsUseWhitelist(Integer isUseWhitelist) {
        this.isUseWhitelist = isUseWhitelist;
    }

    public Integer getIsUseSysRedlistWhitelist() {
        return isUseSysRedlistWhitelist;
    }

    public void setIsUseSysRedlistWhitelist(Integer isUseSysRedlistWhitelist) {
        this.isUseSysRedlistWhitelist = isUseSysRedlistWhitelist;
    }

    public Integer getIsUseKeywordIncpt() {
        return isUseKeywordIncpt;
    }

    public void setIsUseKeywordIncpt(Integer isUseKeywordIncpt) {
        this.isUseKeywordIncpt = isUseKeywordIncpt;
    }

    public Integer getLongMsgPackType() {
        return longMsgPackType;
    }

    public void setLongMsgPackType(Integer longMsgPackType) {
        this.longMsgPackType = longMsgPackType;
    }

    public Integer getIsAutoReturn() {
        return isAutoReturn;
    }

    public void setIsAutoReturn(Integer isAutoReturn) {
        this.isAutoReturn = isAutoReturn;
    }

    public Integer getIsIncptLongAccessCode() {
        return isIncptLongAccessCode;
    }

    public void setIsIncptLongAccessCode(Integer isIncptLongAccessCode) {
        this.isIncptLongAccessCode = isIncptLongAccessCode;
    }

    public String getSpDesc() {
        return spDesc;
    }

    public void setSpDesc(String spDesc) {
        this.spDesc = spDesc;
    }

    public Long getMinSaleCost() {
        return minSaleCost;
    }

    public void setMinSaleCost(Long minSaleCost) {
        this.minSaleCost = minSaleCost;
    }

    public Long getActualSalePrice() {
        return actualSalePrice;
    }

    public void setActualSalePrice(Long actualSalePrice) {
        this.actualSalePrice = actualSalePrice;
    }

    public Long getSaleCommissionProp() {
        return saleCommissionProp;
    }

    public void setSaleCommissionProp(Long saleCommissionProp) {
        this.saleCommissionProp = saleCommissionProp;
    }

    public Integer getIsUsePlatformHandle() {
        return isUsePlatformHandle;
    }

    public void setIsUsePlatformHandle(Integer isUsePlatformHandle) {
        this.isUsePlatformHandle = isUsePlatformHandle;
    }

    public Long getPlatformHandleProp() {
        return platformHandleProp;
    }

    public void setPlatformHandleProp(Long platformHandleProp) {
        this.platformHandleProp = platformHandleProp;
    }

    public Long getHandleRepProp() {
        return handleRepProp;
    }

    public void setHandleRepProp(Long handleRepProp) {
        this.handleRepProp = handleRepProp;
    }

    public Long getHandleRepRealtimeProp() {
        return handleRepRealtimeProp;
    }

    public void setHandleRepRealtimeProp(Long handleRepRealtimeProp) {
        this.handleRepRealtimeProp = handleRepRealtimeProp;
    }

    public Integer getHandleRepReturnTime() {
        return handleRepReturnTime;
    }

    public void setHandleRepReturnTime(Integer handleRepReturnTime) {
        this.handleRepReturnTime = handleRepReturnTime;
    }

    public Long getPlatformHandleUnknowProp() {
        return platformHandleUnknowProp;
    }

    public void setPlatformHandleUnknowProp(Long platformHandleUnknowProp) {
        this.platformHandleUnknowProp = platformHandleUnknowProp;
    }

    public Long getWrongNumSucPorp() {
        return wrongNumSucPorp;
    }

    public void setWrongNumSucPorp(Long wrongNumSucPorp) {
        this.wrongNumSucPorp = wrongNumSucPorp;
    }

    public Long getWrongNumUnknowPorp() {
        return wrongNumUnknowPorp;
    }

    public void setWrongNumUnknowPorp(Long wrongNumUnknowPorp) {
        this.wrongNumUnknowPorp = wrongNumUnknowPorp;
    }

    public Long getWrongReportSucProp() {
        return wrongReportSucProp;
    }

    public void setWrongReportSucProp(Long wrongReportSucProp) {
        this.wrongReportSucProp = wrongReportSucProp;
    }

    public Integer getIsUseOvertimeChange() {
        return isUseOvertimeChange;
    }

    public void setIsUseOvertimeChange(Integer isUseOvertimeChange) {
        this.isUseOvertimeChange = isUseOvertimeChange;
    }

    public Long getChangeOvertimeProp() {
        return changeOvertimeProp;
    }

    public void setChangeOvertimeProp(Long changeOvertimeProp) {
        this.changeOvertimeProp = changeOvertimeProp;
    }

    public Integer getChangeOvertimeStartTime() {
        return changeOvertimeStartTime;
    }

    public void setChangeOvertimeStartTime(Integer changeOvertimeStartTime) {
        this.changeOvertimeStartTime = changeOvertimeStartTime;
    }

    public Integer getChangeOvertimeEndTime() {
        return changeOvertimeEndTime;
    }

    public void setChangeOvertimeEndTime(Integer changeOvertimeEndTime) {
        this.changeOvertimeEndTime = changeOvertimeEndTime;
    }

    public Integer getIsUseAuditKeyword() {
        return isUseAuditKeyword;
    }

    public void setIsUseAuditKeyword(Integer isUseAuditKeyword) {
        this.isUseAuditKeyword = isUseAuditKeyword;
    }

    public Integer getUserSendLimit() {
        return userSendLimit;
    }

    public void setUserSendLimit(Integer userSendLimit) {
        this.userSendLimit = userSendLimit;
    }

    public Integer getIsUseNumShunt() {
        return isUseNumShunt;
    }

    public void setIsUseNumShunt(Integer isUseNumShunt) {
        this.isUseNumShunt = isUseNumShunt;
    }

    public Integer getIsUseBalanceNotice() {
        return isUseBalanceNotice;
    }

    public void setIsUseBalanceNotice(Integer isUseBalanceNotice) {
        this.isUseBalanceNotice = isUseBalanceNotice;
    }

    public Integer getBalNoticeNum() {
        return balNoticeNum;
    }

    public void setBalNoticeNum(Integer balNoticeNum) {
        this.balNoticeNum = balNoticeNum;
    }

    public String getBalNoticeContent() {
        return balNoticeContent;
    }

    public void setBalNoticeContent(String balNoticeContent) {
        this.balNoticeContent = balNoticeContent;
    }

    public Integer getBalNoticeInterval() {
        return balNoticeInterval;
    }

    public void setBalNoticeInterval(Integer balNoticeInterval) {
        this.balNoticeInterval = balNoticeInterval;
    }

    public Date getBalNoticeTime() {
        return balNoticeTime;
    }

    public void setBalNoticeTime(Date balNoticeTime) {
        this.balNoticeTime = balNoticeTime;
    }

    public Integer getIsUseHttp() {
        return isUseHttp;
    }

    public void setIsUseHttp(Integer isUseHttp) {
        this.isUseHttp = isUseHttp;
    }

    public String getHttpBindIp() {
        return httpBindIp;
    }

    public void setHttpBindIp(String httpBindIp) {
        this.httpBindIp = httpBindIp;
    }

    public Integer getIsUsePush() {
        return isUsePush;
    }

    public void setIsUsePush(Integer isUsePush) {
        this.isUsePush = isUsePush;
    }

    public String getHttpReplyAddress() {
        return httpReplyAddress;
    }

    public void setHttpReplyAddress(String httpReplyAddress) {
        this.httpReplyAddress = httpReplyAddress;
    }

    public String getHttpReportAddress() {
        return httpReportAddress;
    }

    public void setHttpReportAddress(String httpReportAddress) {
        this.httpReportAddress = httpReportAddress;
    }

    public String getHttpReportReplyAddress() {
        return httpReportReplyAddress;
    }

    public void setHttpReportReplyAddress(String httpReportReplyAddress) {
        this.httpReportReplyAddress = httpReportReplyAddress;
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
}
