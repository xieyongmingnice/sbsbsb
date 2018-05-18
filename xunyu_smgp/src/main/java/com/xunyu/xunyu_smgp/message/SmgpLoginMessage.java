package com.xunyu.xunyu_smgp.message;

import com.xunyu.xunyu_smgp.head.Header;
import com.xunyu.xunyu_smgp.packet.SmgpPacketType;

/**
 * @author xym
 * @description smgp登录消息体
 * @date 2018/5/18 18:01
 */
public class SmgpLoginMessage extends SmgpDefaultMessage{


    private static final long serialVersionUID = -205851080430813164L;
    /**
     * 客户端用来登录服务器端的用户账号
     */
    private String clientId;

    /**
     * 客户端认证码，用来鉴别客户端的合法性
     */
    private String authenticatorClient;

    /**
     * 客户端用来登录服务器端的登录类型
     */
    private Integer loginMode;

    /**
     * 时间戳
     */
    private long timeStamp;

    /**
     * 客户端支持的协议版本号
     */
    private Integer clientVersion;

    public SmgpLoginMessage(Header header){
        super(SmgpPacketType.LOGIN,header);
    }

    public SmgpLoginMessage(long sequenceId){
        super(SmgpPacketType.LOGIN,sequenceId);
    }

    public SmgpLoginMessage(){
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
