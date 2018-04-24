package com.xunyu.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dth
 * @date 2018/4/11 14:58
 **/
@ComponentScan(basePackages = {"com.xunyu",})
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients  //Feign 本身集成了断路游
public class XunyuCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(XunyuCrmApplication.class, args);
	}
}
