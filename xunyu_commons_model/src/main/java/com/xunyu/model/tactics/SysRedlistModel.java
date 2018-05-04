package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.util.Date;
import java.util.List;

/**
 * @author xym
 * @description 系统红名单  请求参数model
 * @date 2018/4/28 14:17
 */
public class SysRedlistModel extends UserModel{
    private static final long serialVersionUID = -353652518206452870L;

    /**
     * 主键id
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
     * 可用状态标志
     */
    private Integer isabled;

    /**
     *   加入时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 批量操作时用的主键集合
     */
    private List<Long> idList;


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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
