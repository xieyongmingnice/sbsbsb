package com.xunyu.shiro;

import com.commons.core.framework.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author dth
 * @date 2018/4/11 14:58
 **/
@ComponentScan(basePackages = {"com.xunyu",})
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker//启动断路器   基于Ribbon
@EnableFeignClients  //Feign 本身集成了断路游
@EnableScheduling
public class ShiroApplication {

    public static void main(String[] args) {
        ApplicationContext app =  SpringApplication.run(ShiroApplication.class, args);
        //设置全局环境
        SpringContextHolder.setApplicationContext(app);
    }
}
