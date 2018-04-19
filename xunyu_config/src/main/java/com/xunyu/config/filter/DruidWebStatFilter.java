package com.xunyu.config.filter;

import com.alibaba.druid.support.http.WebStatFilter;

//@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")})
public class DruidWebStatFilter extends WebStatFilter {

}
