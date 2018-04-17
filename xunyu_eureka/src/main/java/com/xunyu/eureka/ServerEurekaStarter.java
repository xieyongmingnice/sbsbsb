package com.xunyu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * spring cloud 集成kafka
 * https://blog.csdn.net/ldy1016/article/details/72852179
 */

@EnableEurekaServer
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ServerEurekaStarter {
    public static void main(String[] args) {
        SpringApplication.run(ServerEurekaStarter.class, args);

        System.out.println("启动discovery ServerDiscoveryStarter 成功！");
    }
}
