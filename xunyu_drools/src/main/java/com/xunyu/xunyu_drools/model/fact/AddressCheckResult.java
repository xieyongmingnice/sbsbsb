package com.xunyu.xunyu_drools.model.fact;


import java.io.Serializable;

/**
 * @author 13017
 */
public class AddressCheckResult implements Serializable{

    private static final long serialVersionUID = 593344581432085934L;

    // true:通过校验；false：未通过校验

    private boolean postCodeResult = false;

    public boolean isPostCodeResult() {
        return postCodeResult;
    }

    public void setPostCodeResult(boolean postCodeResult) {
        this.postCodeResult = postCodeResult;
    }
}
