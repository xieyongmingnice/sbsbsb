package com.xunyu.xunyu_tactics.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xym
 * @description 系统红名单VO
 * @date 2018/4/28 15:14
 */
public class SysRedlistVO implements Serializable{

    private static final long serialVersionUID = 6436478054641537467L;
    /**
     * id
     */
    private Integer sysRedlistId;

    /**
     *   手机号
     */
    private String phoneNumber;

    /**
     *   红名单来源
     */
    private Integer redlistSource;

    /**
     *   加入时间
     */
    private Date joinTime;

    /**
     *   备注
     */
    private String remarks;
    /**
     * 是否可用标志 1可用 ，0不可用
     */
    private Integer isabled;
    /**
     *  红名单来源字符串
     */
    private String redlistSourceStr;

    public Integer getSysRedlistId() {
        return sysRedlistId;
    }

    public void setSysRedlistId(Integer sysRedlistId) {
        this.sysRedlistId = sysRedlistId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRedlistSource() {
        return redlistSource;
    }

    public void setRedlistSource(Integer redlistSource) {
        this.redlistSource = redlistSource;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRedlistSourceStr() {
        return redlistSourceStr;
    }

    public void setRedlistSourceStr(String redlistSourceStr) {
        this.redlistSourceStr = redlistSourceStr;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }
}
