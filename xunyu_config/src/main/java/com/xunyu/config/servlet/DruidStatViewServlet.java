package com.xunyu.config.servlet;

import com.alibaba.druid.support.http.StatViewServlet;


/*@WebServlet(urlPatterns = {"/druid/*"},
        initParams = {
                @WebInitParam(name = "loginUsername", value = "xunyu-db"),
                @WebInitParam(name = "loginPassword", value = "XunYu@DEV-DB")
        })*/
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = 1L;

    public void init() {
        System.out.println("init DruidStatViewServlet...");
    }
}

