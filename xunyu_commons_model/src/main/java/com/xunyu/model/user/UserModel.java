package com.xunyu.model.user;

import com.xunyu.model.page.MysqlPage;

/**
 * @author dth
 * @date 2018/4/12 14:58'
 * 通过sessionId判断当前会话是否失效
 **/
public class UserModel extends MysqlPage {

   private String sessionId;

   private Long uid;//当前登录用户id

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
