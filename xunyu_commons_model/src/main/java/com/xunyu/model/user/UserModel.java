package com.xunyu.model.user;

import com.xunyu.model.page.MysqlPage;

import java.io.Serializable;

/**
 * @author dth
 * @date 2018/4/12 14:58'
 * 通过sessionId判断当前会话是否失效
 **/
public class UserModel extends MysqlPage implements Serializable {
    private static final long serialVersionUID = 1233577594582916728L;

   private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
