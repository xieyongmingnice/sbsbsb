package com.xunyu.zuul;

import com.xunyu.zuul.filter.AccessFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayStarter {
    private static final Logger log = LoggerFactory.getLogger(ZuulApiGatewayStarter.class);
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayStarter.class, args);
        log.info("zuul启动成功...");
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


