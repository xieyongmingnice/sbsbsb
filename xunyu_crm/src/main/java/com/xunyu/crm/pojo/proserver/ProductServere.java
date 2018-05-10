package com.xunyu.crm.pojo.proserver;

import com.xunyu.model.user.UserModel;

import java.util.Date;

/**
 * @author dth
 * @date 2018/4/26 15:18
 * 产品服务
 **/
public class ProductServere extends UserModel {

    private Long serviceId;//主键
    private String serviceName;//产品服务名称
    private Integer servicePayType;//付费模式
    private Integer isabled;//1未删除  0删除
    private String remark;//备注
    private Date createTime;//创建时间

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServicePayType() {
        return servicePayType;
    }

    public void setServicePayType(Integer servicePayType) {
        this.servicePayType = servicePayType;
    }

    public Integer getIsabled() {
        return isabled;
    }

    public void setIsabled(Integer isabled) {
        this.isabled = isabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
