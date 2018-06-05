package com.xunyu.xunyu_drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.xunyu",})
@SpringBootApplication
public class XunyuDroolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(XunyuDroolsApplication.class, args);
	}

}
