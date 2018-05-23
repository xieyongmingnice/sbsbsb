package com.xunyu.xunyu_smgp.message;

import com.xunyu.xunyu_smgp.head.Header;
import com.xunyu.xunyu_smgp.packet.SmgpPacketType;

/**
 * @author xym
 * @description smgp登录消息体
 * @date 2018/5/18 18:01
 */
public class SmgpLoginRequestMessage extends SmgpDefaultMessage{


    private static final long serialVersionUID = -205851080430813164L;
    /**
     * 客户端用来登录服务器端的用户账号
     */
    private String clientId ="";

    /**
     * 客户端认证码，用来鉴别客户端的合法性
     * AuthenticatorClient =MD5 （ ClientID+7 字节的二进制 0 （ 0x00 ） + Shared secret+Timestamp）
     */
    private String authenticatorClient = "";

    /**
     * 客户端用来登录服务器端的登录类型
     * 0＝发送短消息 ,1＝接收短消息 ,2＝收发短消息 ,其它保留
     */
    private Integer loginMode = 0;

    /**
     * 时间戳, 此处 Timestamp 格式为：MMDDHHMMSS（月日时分秒），经 TimeStamp 字段值转换
     */
    private long timeStamp = 0L;

    /**
     * 客户端支持的协议版本号, 高 4bit 表示主版本号，低 4bit 表示次版本号
     */
    private Integer clientVersion = 0x30;

    public SmgpLoginRequestMessage(Header header){
        super(SmgpPacketType.LOGIN,header);
    }

    public SmgpLoginRequestMessage(long sequenceId){
        super(SmgpPacketType.LOGIN,sequenceId);
    }

    public SmgpLoginRequestMessage(){
        super(SmgpPacketType.LOGIN);
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAuthenticatorClient() {
        return authenticatorClient;
    }

    public void setAuthenticatorClient(String authenticatorClient) {
        this.authenticatorClient = authenticatorClient;
    }

    public Integer getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(Integer loginMode) {
        this.loginMode = loginMode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(Integer clientVersion) {
        this.clientVersion = clientVersion;
    }
}
