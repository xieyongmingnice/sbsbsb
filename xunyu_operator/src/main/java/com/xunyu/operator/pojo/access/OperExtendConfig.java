package com.xunyu.operator.pojo.access;

/**
 * @author dth
 * @date 2018/6/11 11:12
 * 网关入口 扩展配置
 **/
public class OperExtendConfig{

    private Long extendId;//扩展id
    private Long configId;//核心配置id
    /**
     * 计费用户
     * 1、目的号码2、源发号码
     * 3、sp 4、无效
     */
    private int chargUser;
    /**
     * 计费类型
     * 1、免费；2、按条；
     * 3、包月；4、封顶;
     * 5、sp ;-1、中讯专用；
     */
    private int chargType;
    private String localPort;//本地网关端口
    private int codeFormat;//编码格式1、8-UCS2； 2、15-GBK; 3、25-UCS2B25
    private int unsignaFormat;//去签名格式 1、正常 2、去前置 3、去后置
    private int ascllSupport;//ASCLL支持 1支持 2不支持
    private int ascllLength;//ASCII长度限制
    private int lenMsgCode;//长短信额外编码 1、8-UCS2； 2、15-GBK; 3、25-UCS2B25
    private int maxLength;//下发最大号长度
    private int isDef;//号码是否需要86
    private String pushLoginUser;//推送登录用户名

    public Long getExtendId() {
        return extendId;
    }

    public void setExtendId(Long extendId) {
        this.extendId = extendId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public int getChargUser() {
        return chargUser;
    }

    public void setChargUser(int chargUser) {
        this.chargUser = chargUser;
    }

    public int getChargType() {
        return chargType;
    }

    public void setChargType(int chargType) {
        this.chargType = chargType;
    }

    public String getLocalPort() {
        return localPort;
    }

    public void setLocalPort(String localPort) {
        this.localPort = localPort;
    }

    public int getCodeFormat() {
        return codeFormat;
    }

    public void setCodeFormat(int codeFormat) {
        this.codeFormat = codeFormat;
    }

    public int getUnsignaFormat() {
        return unsignaFormat;
    }

    public void setUnsignaFormat(int unsignaFormat) {
        this.unsignaFormat = unsignaFormat;
    }

    public int getAscllSupport() {
        return ascllSupport;
    }

    public void setAscllSupport(int ascllSupport) {
        this.ascllSupport = ascllSupport;
    }

    public int getAscllLength() {
        return ascllLength;
    }

    public void setAscllLength(int ascllLength) {
        this.ascllLength = ascllLength;
    }

    public int getLenMsgCode() {
        return lenMsgCode;
    }

    public void setLenMsgCode(int lenMsgCode) {
        this.lenMsgCode = lenMsgCode;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getIsDef() {
        return isDef;
    }

    public void setIsDef(int isDef) {
        this.isDef = isDef;
    }

    public String getPushLoginUser() {
        return pushLoginUser;
    }

    public void setPushLoginUser(String pushLoginUser) {
        this.pushLoginUser = pushLoginUser;
    }
}
