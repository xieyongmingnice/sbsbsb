package com.xunyu.consume.utils;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dth
 * @date 2018/4/12 9:08
 **/
@Configuration
public class FeignLogger {

    @Bean
    public Logger.Level getFeignLoggerLevel() {

        return Logger.Level.FULL;

    }

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {

        return new BasicAuthRequestInterceptor("gwolf", "gwolf");

    }
}
