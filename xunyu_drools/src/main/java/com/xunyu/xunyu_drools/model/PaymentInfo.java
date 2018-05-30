package com.xunyu.xunyu_drools.model;

import java.io.Serializable;

public class PaymentInfo implements Serializable{

    private static final long serialVersionUID = -2640890039217782819L;

    private Integer moneyAmount = 0;
    private String decisionPath = "";

    public Integer getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Integer moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getDecisionPath() {
        return decisionPath;
    }

    public void setDecisionPath(String decisionPath) {
        this.decisionPath = decisionPath;
    }
}
