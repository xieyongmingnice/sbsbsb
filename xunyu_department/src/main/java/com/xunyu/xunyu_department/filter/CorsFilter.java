package com.xunyu.xunyu_department.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @description 
 * @date 2018/4/27 13:26
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,PUT");
        response.setHeader("Access-Control-Max-Age", "1800");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }

}
