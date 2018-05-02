package com.xunyu.system.pojo.errcode;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/5/2 15:56
 **/
public class ErrorCode extends UserModel {

    private Long errId;//主键
    private Integer isabled;//1未删除  0删除
    private Date createTime;//创建时间
    private Integer agreeType; //协议类型 1三网统一  2、移动  3、联通 4、电信 5、第三方
    private Integer errType;//错误类型 1 网关定义  2自定义
    private String errCode;//错误代码
    private String errText;//错误说明
    private String errContent;//错误描述

    public Long getErrId() {
        return errId;
    }

    public void setErrId(Long errId) {
        this.errId = errId;
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

    public String getErrContent() {
        return errContent;
    }

    public void setErrContent(String errContent) {
        this.errContent = errContent;
    }
}
