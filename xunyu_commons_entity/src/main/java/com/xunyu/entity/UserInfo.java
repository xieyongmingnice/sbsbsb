package com.xunyu.entity;

import java.io.Serializable;

/**
 * 用户资料
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -3267918083809259248L;

    /**
     * id
     */

    private Long id;

    /**
     *
     */

    private String name;

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
}
