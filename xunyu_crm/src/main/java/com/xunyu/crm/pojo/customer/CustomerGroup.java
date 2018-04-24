package com.xunyu.crm.pojo.customer;

import com.xunyu.model.user.UserModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dth
 * @date 2018/4/24 10:30
 *  客户分组表
 **/
public class CustomerGroup extends UserModel implements Serializable {
    private static final long serialVersionUID = 1452847469102503992L;
    private Long customerGroupId;//主键
    private String customerName;//名称
    private Integer isabled;//0删除 1未删除
    private String remark;//备注
    private Date createTime;//创建时间

    public Long getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
