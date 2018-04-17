package com.xunyu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dth
 * @date 2018/4/17 17:34
 * spring cloud 集成kafka
 * https://blog.csdn.net/ldy1016/article/details/72852179
 */

@EnableEurekaServer
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EurekaServer {
        public static void main(String[] args) {
            SpringApplication.run(EurekaServer.class, args);
            System.out.println("启动discovery ServerDiscoveryStarter 成功！");
        }
}
