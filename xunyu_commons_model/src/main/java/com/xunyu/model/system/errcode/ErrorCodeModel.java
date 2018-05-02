package com.xunyu.model.system.errcode;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/5/2 16:47
 **/
public class ErrorCodeModel extends UserModel {

    private Long errId;//主键
    private Integer agreeType; //协议类型 1三网统一  2、移动  3、联通 4、电信 5、第三方
    private Integer errType;//错误类型 1 网关定义  2自定义
    private String errCode;//错误代码
    private String errText;//错误说明
    private String errIds;//id组成的字符串

    public String getErrIds() {
        return errIds;
    }

    public void setErrIds(String errIds) {
        this.errIds = errIds;
    }

    public Long getErrId() {
        return errId;
    }

    public void setErrId(Long errId) {
        this.errId = errId;
    }

    public Integer getAgreeType() {
        return agreeType;
    }

    public void setAgreeType(Integer agreeType) {
        this.agreeType = agreeType;
    }

    public Integer getErrType() {
        return errType;
    }

    public void setErrType(Integer errType) {
        this.errType = errType;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrText() {
        return errText;
    }

    public void setErrText(String errText) {
        this.errText = errText;
    }
}
