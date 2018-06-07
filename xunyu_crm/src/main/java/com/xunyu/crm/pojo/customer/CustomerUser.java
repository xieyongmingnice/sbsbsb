package com.xunyu.crm.pojo.customer;

import com.xunyu.model.user.User;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/6/7 15:38
 **/
public class CustomerUser implements Serializable {

    private static final long serialVersionUID = 2621692621452027259L;
    private User us;//当前登录用户
    private String enterContact;//联系人

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }

    public String getEnterContact() {
        return enterContact;
    }

    public void setEnterContact(String enterContact) {
        this.enterContact = enterContact;
    }
}
