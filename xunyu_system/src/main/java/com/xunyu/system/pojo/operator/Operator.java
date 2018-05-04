package com.xunyu.system.pojo.operator;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/4/28 9:26
 **/
public class Operator extends UserModel {

    private Long operId;//主键
    private Integer isabled;//1未删除  0删除
    private Date createTime;//创建时间
    private Integer operType;//运营商类型 1移动  2联通 3电信 4其它
    private String operName;//运营商名称
    private String operCharge;//运营商负责人
    private String operTelphone;//运营商联系电话
    private String operRemark;//运营商备注

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
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

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperCharge() {
        return operCharge;
    }

    public void setOperCharge(String operCharge) {
        this.operCharge = operCharge;
    }

    public String getOperTelphone() {
        return operTelphone;
    }

    public void setOperTelphone(String operTelphone) {
        this.operTelphone = operTelphone;
    }

    public String getOperRemark() {
        return operRemark;
    }

    public void setOperRemark(String operRemark) {
        this.operRemark = operRemark;
    }
}
