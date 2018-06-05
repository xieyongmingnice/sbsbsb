package com.xunyu.sgip.config.utils;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class KafkaProducerUtil {
	private Properties props = null;
	public void produce(String topic,String key,String msgValue) {
		if(null == props)
			props = getConfig();

		//创建kafka的生产者
		Producer<String, String> producer = new KafkaProducer<String, String>(props);  
		//producer.send(new ProducerRecord<String, String>(topic, "Hello5"));
		producer.send(new ProducerRecord<String, String>(topic,key, msgValue), new Callback() {
		    @Override  
		    public void onCompletion(RecordMetadata metadata, Exception e) {  
		        if (e != null) {  
		            e.printStackTrace();
		        } else {  
		            System.out.println("主题 = "+metadata.toString());//org.apache.kafka.clients.producer.RecordMetadata@1d89e2b5
		            System.out.println("偏移量 = "+metadata.offset());//1
		        }  
		    }  
		});
		
		//生产者的主要方法
        // close(long timeout, TimeUnit timeUnit);
		// This method waits up to timeout for the producer to complete the sending of all incomplete requests.
		producer.flush();//所有缓存记录被立刻发送
		producer.close();//Close this producer.
	}
	
	private static Properties getConfig() {
		Properties props = new Properties();
		/*
		 * 参数说明
		 * */
		props.put("bootstrap.servers", "192.168.3.5:9092");
		props.put("zk.connect", "192.168.3.5:2181");
		// 配置metadata.broker.list, 为了高可用, 最好配两个broker实例
		props.put("metadata.broker.list", "192.168.3.5:9092");
		
		// serializer.class为消息的序列化类:
		// 可选：kafka.serializer.StringEncoder; 默认：kafka.serializer.DefaultEncoder
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		// serializer详细配置
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");  
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		//“所有”设置将导致记录的完整提交阻塞，最慢的，但最持久的设置。
		props.put("acks", "all"); 
		// ACK机制, 消息发送需要kafka服务端确认
		// 0表示不等待结果返回;1表示等待至少有一个服务器返回数据接收标识;-1表示必须接收到所有的服务器返回标识，及同步写入
		props.put("request.required.acks", "1");
		//如果请求失败，生产者也会自动重试，即使设置成０ the producer can automatically retry.
		props.put("retries", 1); 
		//默认立即发送，这里这是延时毫秒数
		props.put("linger.ms", 1);
		//内部发送数据是异步还是同步{sync：同步( 默认),async：异步}
        props.put("producer.type", "async");
		//生产者缓冲大小，当缓冲区耗尽后，额外的发送调用将被阻塞。时间超过max.block.ms将抛出TimeoutException
		props.put("buffer.memory", 33554432);
		//The producer maintains buffers of unsent records for each partition. 
        props.put("batch.size", 16384);
        // 重试次数
        props.put("message.send.max.retries", "3");
        // 异步提交的时候(async)，并发提交的记录数
        props.put("batch.num.messages", "200");
        // 设置缓冲区大小，默认10KB
        props.put("send.buffer.bytes", "102400");
		props.put("num.partitions", "10");
		/**/
		return props;
	}

	/**
	 * 单例
	 */
	private KafkaProducerUtil(){}
	private static class LazyHolder {
		private static final KafkaProducerUtil INSTANCE = new KafkaProducerUtil();
	}
	public static final KafkaProducerUtil getInstance() {
		return LazyHolder.INSTANCE;
	}
    public static void main(String[]args) {

    	KafkaProducerUtil producer = KafkaProducerUtil.getInstance();
    	producer.produce("dingtonghao2","This is key","This is value");
    }
}
