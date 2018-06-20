package com.xunyu.model.operator.out;

import com.xunyu.model.operator.out.group.GatewayOutConfigGroup;
import com.xunyu.model.operator.out.group.SpConfigGroup;
import com.xunyu.model.operator.out.group.GatewayOutConfigShuntGroup;
import com.xunyu.model.user.UserModel;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 网关接出配置参数类
 * @date 2018/6/12 13:49
 */
public class GatewayOutConfigModel extends UserModel implements Serializable {

    private static final long serialVersionUID = 7055384099306513477L;

    /**
     *
     */
    @NotNull(message = "网关接触配置id不可为空，请重新填写后提交",groups = SpConfigGroup.class)
    private Integer gatewayOutConfigId;

    /**
     * 运营商类型
     */
    @NotNull(message = "运营商类型不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer carrierType;

    /**
     *   客户id
     */
    @NotNull(message = "客户id不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer customerId;

    /**
     *   用户类型 1：预付费，2：后付费
     */
    @NotNull(message = "用户类型不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer customerType;

    /**
     *   企业代码
     */
    @NotNull(message = "企业代码不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private String enterpriseCode;

    /**
     *   接入类型
     */
    @NotNull(message = "接入类型不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer accessType;

    /**
     *   企业IP
     */
    @NotBlank(message = "企业IP不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
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
    @NotBlank(message = "企业密码不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private String enterprisePwd;


    /**
     *   赋给SP接入码
     */
    @NotBlank(message = "sp接入码不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private String spAccessCode;

    /**
     *   上行短信接入码
     */
    @NotBlank(message = "上行短信接入码不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private String msgAccessCode;

    /**
     *   下发转码接入码
     */
    private String transAccessCode;



    /**
     *   ASCII签名
     */
    private String ascllSign;

    /**
     *   服务代码
     */
    private String serviceCode;


    /**
     * 协议类型
     */
    @NotNull(message = "协议类型不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class, SpConfigGroup.class})
    private Integer carrierAgreeId;
    /**
     *   号码是否需要86，1：是，0：否，默认否
     */
    @NotNull(message = "号码是否需要86不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isNeedPrefix;

    /**
     *   MO模式，1：需要，0：不需要，默认0
     */
    @NotNull(message = "MO模式不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer moPattern;

    /**
     *   MO网关ID
     */
    private Integer moGatewayId;

    /**
     *   报告消息ID模式
     */
    @NotNull(message = "报告消息ID模式不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer reportMsgType;

    /**
     *   下发流量门限
     */
    @NotNull(message = "下发流量门限不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer sendFlowThreshold;

    /**
     *   报告回复推送流量门限
     */
    @NotNull(message = "报告回复推送流量门限不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer replyFlowThreshold;

    /**
     *   是否启用，1：是，0：否，默认1
     */
    @NotNull(message = "是否启用不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUsed;

    /**
     *   付费模式，1：预付费，2：后付费，默认1
     */
    @NotNull(message = "付费模式不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer payType;

    /**
     *   押金
     */
    @NotNull(message = "押金不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal deposit;

    /**
     *   费率
     */
    @NotNull(message = "费率不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal rate;

    /**
     *   在线充值起充条数
     */
    @NotNull(message = "在线充值起充条数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer rechargeNumLimit;

    /**
     *   是否启用在线充值，1：是，0：否，默认1
     */
    @NotNull(message = "是否启用在线充值不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isOnlineRechargeUsed;

    /**
     *   短信剩余条数
     */
    private Integer remainderMsgNum;

    /**
     *   质押条数
     */
    @NotNull(message = "质押条数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer pledgeNum;

    /**
     *   信用率
     */
    @NotNull(message = "信用率不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal creditRate;

    /**
     *   审核模式
     */
    @NotNull(message = "审核模式不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer auditType;

    /**
     *   优先级
     */
    @NotNull(message = "优先级不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer priority;

    /**
     *   最大连接数
     */
    @NotNull(message = "最大连接数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
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
    @NotNull(message = "是否强制签名不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isForcedSign;

    /**
     *   签名内容
     */
    @NotBlank(message = "签名内容不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private String signContent;

    /**
     *   签名位置，1：签名后置，0：签名前置，默认1
     */
    @NotNull(message = "签名位置不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer signLocation;

    /**
     *   是否必须签名，1：是，0：否，默认0
     */
    @NotNull(message = "是否必须签名不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isMustSign;

    /**
     *   审核条数
     */
    @NotNull(message = "审核条数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer auditNum;

    /**
     *   是否启用黑名单，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用黑名单不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseBlacklist;

    /**
     *   是否启用白名单，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用白名单不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseWhitelist;

    /**
     *   是否启用系统红白名单，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用系统红白名单不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseSysRedlistWhitelist;

    /**
     *   是否启用网关关键字拦截，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用网关关键字拦截不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseKeywordIncpt;

    /**
     *   SP长短信组包方式
     */
    @NotNull(message = "SP长短信组包方式不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer longMsgPackType;

    /**
     *   是否自动返还，1:是，0：否，默认0
     */
    @NotNull(message = "是否自动返还不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isAutoReturn;

    /**
     *   下发接入号超长是否截断，1：是，0：否，默认1
     */
    @NotNull(message = "下发接入号超长是否截断不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isIncptLongAccessCode;

    /**
     *   SP描述
     */
    private String spDesc;

    /**
     *   是否启用平台处理
     */
    @NotNull(message = "是否启用平台处理不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUsePlatformHandle;

    /**
     *   平台处理比例
     */
    @NotNull(message = "平台处理比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal platformHandleProp;

    /**
     *   平台处理成功报告比例
     */
    @NotNull(message = "平台处理成功报告比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal handleRepProp;

    /**
     *   平台处理成功报告实时比例
     */
    @NotNull(message = "平台处理成功报告实时比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal handleRepRealtimeProp;

    /**
     *   平台处理成功报告回传时间
     */
    @NotNull(message = "平台处理成功报告回传时间不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer handleRepReturnTime;

    /**
     *   平台处理未知报告比例
     */
    @NotNull(message = "平台处理未知报告比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal platformHandleUnknowProp;

    /**
     *   错号空号等成功比例
     */
    @NotNull(message = "错号空号等成功比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal wrongNumSucPorp;

    /**
     *   错号空号等未知比例
     */
    @NotNull(message = "错号空号等未知比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal wrongNumUnknowPorp;

    /**
     *   错误报告转成功比例
     */
    @NotNull(message = "错误报告转成功比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal wrongReportSucProp;

    /**
     *   是否启用超时改变状态，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用超时改变状态不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseOvertimeChange;

    /**
     *   改变状态超时比例
     */
    @NotNull(message = "改变状态超时比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private BigDecimal changeOvertimeProp;

    /**
     *   改变状态超时时间开始，单位分钟
     */
    @NotNull(message = "改变状态超时时间开始不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer changeOvertimeStartTime;

    /**
     *   改变状态超时时间结束，单位：分钟
     */
    @NotNull(message = "改变状态超时时间结束不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer changeOvertimeEndTime;

    /**
     *   是否启用审核关键字，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用审核关键字不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseAuditKeyword;

    /**
     *   用户号码发送限制条数
     */
    @NotNull(message = "用户号码发送限制条数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer userSendLimit;

    /**
     *   是否启用号段分流，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用号段分流不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseNumShunt;

    /**
     *   是否启用余额短信提醒，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用余额短信提醒不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseBalanceNotice;

    /**
     *   余额提醒条数
     */
    @NotNull(message = "余额提醒条数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer balNoticeNum;

    /**
     *   余额提醒内容
     */
    @NotBlank(message = "余额提醒内容不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private String balNoticeContent;

    /**
     *   余额提醒间隔，单位：天
     */
    @NotNull(message = "余额提醒间隔不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer balNoticeInterval;

    /**
     *   余额提醒时间
     */
    @NotNull(message = "余额提醒时间不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Time balNoticeTime;

    /**
     *   是否启用HTTP接口，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用HTTP接口不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class, GatewayOutConfigShuntGroup.class})
    private Integer isUseHttp;

    /**
     *   HTTP绑定IP地址
     */
    private String httpBindIp;

    /**
     *   是否启用推送，1：是，0：否，默认0
     */
    @NotNull(message = "是否启用推送不可为空，请重新填写后提交",groups = { GatewayOutConfigGroup.class,GatewayOutConfigShuntGroup.class})
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

    /**
     * 节点代码
     */
    private String nodeCode;

    /**
     * 以下为sp网关接出配置的字段
     */
    /**
     *   运营商类型
     */
    private Integer agreeType;

    /**
     *   网关接入配置id
     */
    @NotNull(message = "网关接入配置id不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private Integer configId;

    /**
     *   网关接入码
     */
    @NotBlank(message = "网关接入码不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private String gatewayAccessCode;

    /**
     *   二进制短信长度限制
     */
    @NotNull(message = "二进制短信长度限制不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private Integer binaryMsgLenLimit;

    /**
     *   SP短信长度限制
     */
    @NotNull(message = "SP短信长度限制不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private Integer spMsgLenLimit;

    /**
     *   网关固定签名位置 1：签名后置，2：签名前置，默认为1
     */
    @NotNull(message = "网关固定签名位置不可为空，请重新填写后提交",groups ={GatewayOutConfigGroup.class,SpConfigGroup.class})
    private Integer fixedSignLocation;

    /**
     *   SP长短信额外可发字数
     */
    @NotNull(message = "SP长短信额外可发字数不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private Integer longMsgExtraNum;

    /**
     *   是否ASCII支持  1：支持，0：不支持，默认为0
     */
    @NotNull(message = "是否ASCII支持不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
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
    @NotNull(message = "是否去签名发送不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private Integer isSendWithoutSign;

    /**
     *   发送去签名内容
     */
    private String contentWithoutSign;

    /**
     *   业务最低销售成本
     */
    @NotNull(message = "业务最低销售成本不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private BigDecimal minSaleCost;

    /**
     *   业务销售实际价格
     */
    @NotNull(message = "业务销售实际价格不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private BigDecimal actualSalePrice;

    /**
     *   业务销售提成比例
     */
    @NotNull(message = "业务销售提成比例不可为空，请重新填写后提交",groups = {GatewayOutConfigGroup.class,SpConfigGroup.class})
    private BigDecimal saleCommissionProp;

    /**
     * 以下为自定义字段
     */
    /**
     * 接入码
     */
    private String accessCode;

    /**
     * 企业联系人
     */
    private String enterContact;

    /**
     * 企业名称
     */
    private String customerName;

    /**
     * 批量操作的idList
     * @return
     */
    private List<Integer> idList;

    /**
     * 根据此字段区分是来自哪个页面的请求
     * @return
     */
    private Integer whichPage;

    public Integer getWhichPage() {
        return whichPage;
    }

    public void setWhichPage(Integer whichPage) {
        this.whichPage = whichPage;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public Integer getCarrierAgreeId() {
        return carrierAgreeId;
    }

    public void setCarrierAgreeId(Integer carrierAgreeId) {
        this.carrierAgreeId = carrierAgreeId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getGatewayOutConfigId() {
        return gatewayOutConfigId;
    }

    public void setGatewayOutConfigId(Integer gatewayOutConfigId) {
        this.gatewayOutConfigId = gatewayOutConfigId;
    }

    public Integer getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(Integer carrierType) {
        this.carrierType = carrierType;
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

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
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

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
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

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(BigDecimal creditRate) {
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

    public Integer getIsUsePlatformHandle() {
        return isUsePlatformHandle;
    }

    public void setIsUsePlatformHandle(Integer isUsePlatformHandle) {
        this.isUsePlatformHandle = isUsePlatformHandle;
    }

    public BigDecimal getPlatformHandleProp() {
        return platformHandleProp;
    }

    public void setPlatformHandleProp(BigDecimal platformHandleProp) {
        this.platformHandleProp = platformHandleProp;
    }

    public BigDecimal getHandleRepProp() {
        return handleRepProp;
    }

    public void setHandleRepProp(BigDecimal handleRepProp) {
        this.handleRepProp = handleRepProp;
    }

    public BigDecimal getHandleRepRealtimeProp() {
        return handleRepRealtimeProp;
    }

    public void setHandleRepRealtimeProp(BigDecimal handleRepRealtimeProp) {
        this.handleRepRealtimeProp = handleRepRealtimeProp;
    }

    public Integer getHandleRepReturnTime() {
        return handleRepReturnTime;
    }

    public void setHandleRepReturnTime(Integer handleRepReturnTime) {
        this.handleRepReturnTime = handleRepReturnTime;
    }

    public BigDecimal getPlatformHandleUnknowProp() {
        return platformHandleUnknowProp;
    }

    public void setPlatformHandleUnknowProp(BigDecimal platformHandleUnknowProp) {
        this.platformHandleUnknowProp = platformHandleUnknowProp;
    }

    public BigDecimal getWrongNumSucPorp() {
        return wrongNumSucPorp;
    }

    public void setWrongNumSucPorp(BigDecimal wrongNumSucPorp) {
        this.wrongNumSucPorp = wrongNumSucPorp;
    }

    public BigDecimal getWrongNumUnknowPorp() {
        return wrongNumUnknowPorp;
    }

    public void setWrongNumUnknowPorp(BigDecimal wrongNumUnknowPorp) {
        this.wrongNumUnknowPorp = wrongNumUnknowPorp;
    }

    public BigDecimal getWrongReportSucProp() {
        return wrongReportSucProp;
    }

    public void setWrongReportSucProp(BigDecimal wrongReportSucProp) {
        this.wrongReportSucProp = wrongReportSucProp;
    }

    public Integer getIsUseOvertimeChange() {
        return isUseOvertimeChange;
    }

    public void setIsUseOvertimeChange(Integer isUseOvertimeChange) {
        this.isUseOvertimeChange = isUseOvertimeChange;
    }

    public BigDecimal getChangeOvertimeProp() {
        return changeOvertimeProp;
    }

    public void setChangeOvertimeProp(BigDecimal changeOvertimeProp) {
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

    public Time getBalNoticeTime() {
        return balNoticeTime;
    }

    public void setBalNoticeTime(Time balNoticeTime) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
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
}
