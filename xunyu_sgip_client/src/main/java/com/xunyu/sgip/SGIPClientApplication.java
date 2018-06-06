package com.xunyu.sgip;


import com.xunyu.sgip.config.utils.GetProperties;
import com.xunyu.sgip.config.utils.KafkaConsumerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dth
 * @date 2018/6/5 14:58
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class SGIPClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SGIPClientApplication.class, args);
		GetProperties.getInstance();//加载配置
		//SGIPClient.getClientSingle().sgipCli(SGIPUtils.host, SGIPUtils.port);
		//消费
		KafkaConsumerUtil consumer = KafkaConsumerUtil.getInstance();
		List<String> list = new ArrayList<String>();
		list.add("b1");
		consumer.consume(list);
	}
}
