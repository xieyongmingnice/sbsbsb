package com.xunyu.xunyu_tactics;

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
 * @author
 * @description
 * @date 2018/4/27 15:45
 */
//热部署
@RefreshScope
@ComponentScan(basePackages = {"com.xunyu"})
@EnableEurekaClient
@SpringBootApplication
//@EnableCircuitBreaker//启动断路器   基于Ribbon
//Feign  本身集成了断路游
@EnableFeignClients
public class XunyuTacticsApplication extends SpringBootServletInitializer {

	private final Logger logger = LoggerFactory.getLogger(XunyuTacticsApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		logger.info("SpringApplicationBuilder configure .... ");
		return builder.sources(XunyuTacticsApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(XunyuTacticsApplication.class, args);
	}
}
