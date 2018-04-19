package com.xunyu.shiro.pojo;

import java.io.Serializable;

/**
 * 用户资料
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -3267918083809259248L;

    private Long id;

    private String name;

    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
