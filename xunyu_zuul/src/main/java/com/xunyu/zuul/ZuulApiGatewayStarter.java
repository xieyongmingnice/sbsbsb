package com.xunyu.zuul;

import com.xunyu.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayStarter {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayStarter.class, args);
    }

    /**
     * @return
     * @autor dth
     * 注入网关拦截 过滤器
     */
    @Bean
    public AccessFilter preRequestLogFilter() {
        return new AccessFilter();
    }
}


