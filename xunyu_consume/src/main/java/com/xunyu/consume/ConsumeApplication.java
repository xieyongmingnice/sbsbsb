package com.xunyu.consume;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dth
 */
@MapperScan(basePackages = "com.xunyu.**.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
//@ServletComponentScan(basePackages = {"com.xunyu.**"})
@RefreshScope  //热部署
@ComponentScan(basePackages = {"com.xunyu",})
@EnableEurekaClient
@SpringBootApplication
//@EnableCircuitBreaker//启动断路器   基于Ribbon
@EnableFeignClients  //Feign 本身集成了断路游
public class ConsumeApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        LOGGER.info("SpringApplicationBuilder configure .... ");
        return builder.sources(ConsumeApplication.class);
    }

    public static void main(String[] args) {
        LOGGER.info("SpringApplicationBuilder run .... ");
        SpringApplication.run(ConsumeApplication.class, args);
    }


}
