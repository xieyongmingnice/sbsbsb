package com.xunyu.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionFilter implements Filter {

    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();


    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");  //此优先级高于@CrossOrigin配置
        // Access-Control-Allow-Methods: 授权请求的方法（GET, POST, PUT, DELETE，OPTIONS等)
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type, token");
        httpResponse.addHeader("Access-Control-Max-Age", "1800");//30 min

    }

    @Override
    public void destroy() {

    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

}