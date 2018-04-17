package com.xunyu.xunyueureka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class XunyuEurekaApplication {
    private static final Logger log = LoggerFactory.getLogger(XunyuEurekaApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(XunyuEurekaApplication.class, args);
        log.info("Eureka服务启动成功...");
    }
}
