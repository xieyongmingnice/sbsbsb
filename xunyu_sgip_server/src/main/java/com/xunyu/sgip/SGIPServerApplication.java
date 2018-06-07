package com.xunyu.sgip;


import com.xunyu.sgip.config.utils.GetProperties;
import com.xunyu.sgip.config.utils.KafkaProducerUtil;
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
		GetProperties.getInstance();//加载配置
		//SGIPServer.getServerSingle().SGIPSer(SGIPUtils.port);

		//生产
		KafkaProducerUtil producer = KafkaProducerUtil.getInstance();
		producer.produce("send016","loginType",SGIPUtils.IntToByteArray2(1));
	}
}
