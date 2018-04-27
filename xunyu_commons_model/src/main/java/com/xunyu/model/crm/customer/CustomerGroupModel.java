package com.xunyu.model.crm.customer;

import com.xunyu.model.user.UserModel;
import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/24 15:13
 **/
public class CustomerGroupModel extends UserModel implements Serializable {
    private static final long serialVersionUID = 1054679497927963049L;

    private Long customerGroupId;//主键
    private String customerName;//名称
    private String remark;//备注

    private String customerGroupIds;//ids

    public String getCustomerGroupIds() {
        return customerGroupIds;
    }

    public void setCustomerGroupIds(String customerGroupIds) {
        this.customerGroupIds = customerGroupIds;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
