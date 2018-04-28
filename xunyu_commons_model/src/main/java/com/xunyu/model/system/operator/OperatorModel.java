package com.xunyu.model.system.operator;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/4/28 10:43
 **/
public class OperatorModel extends UserModel {

    private Long operId;//主键
    private String operName;//运营商名称
    private String operIds;//批量时所用的id字符串

    public String getOperIds() {
        return operIds;
    }

    public void setOperIds(String operIds) {
        this.operIds = operIds;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }
}
