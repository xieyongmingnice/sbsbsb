package com.xunyu.sgip;


import com.xunyu.sgip.config.utils.SGIPUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dth
 * @date 2018/6/5 14:58
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class SGIPServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SGIPServerApplication.class, args);
		SGIPServer.getServerSingle().SGIPSer(SGIPUtils.port);
	}
}
