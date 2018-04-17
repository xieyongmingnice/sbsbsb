package com.xunyu.model.user;

import com.xunyu.model.page.MysqlPage;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/12 14:58
 **/
public class UserModel extends MysqlPage implements Serializable {
    private static final long serialVersionUID = 1233577594582916728L;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
