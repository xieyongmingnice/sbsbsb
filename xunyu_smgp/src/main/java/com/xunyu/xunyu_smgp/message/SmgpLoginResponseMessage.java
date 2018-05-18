package com.xunyu.xunyu_smgp.message;

/**
 * @author xym
 * @description smpg登录响应消息体
 * @date 2018/5/18 18:00
 */
public class SmgpLoginResponseMessage extends SmgpDefaultMessage {

    private static final long serialVersionUID = 5382227140213284941L;
    /**
     *请求返回结果
     */
    private Integer status;

    /**
     *服务器端返回给客户端的认证码
     */
    private String authenticatorServer;

    /**
     *服务器端支持的最高版本号
     */
    private Integer ServerVersion;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthenticatorServer() {
        return authenticatorServer;
    }

    public void setAuthenticatorServer(String authenticatorServer) {
        this.authenticatorServer = authenticatorServer;
    }

    public Integer getServerVersion() {
        return ServerVersion;
    }

    public void setServerVersion(Integer serverVersion) {
        ServerVersion = serverVersion;
    }
}
