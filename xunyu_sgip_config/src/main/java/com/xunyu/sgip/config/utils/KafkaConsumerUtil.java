package com.xunyu.sgip.config.utils;

import jersey.repackaged.com.google.common.collect.Lists;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Properties;

public class KafkaConsumerUtil { 
	private Properties props = null;
    public void consume(String topic) {
    	if(null == props)
    		props = getConfig();

    	Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(props);
    	//订阅主题列表topic
    	consumer.subscribe(Lists.newArrayList(topic));

	    //不断监听新消息
	    while (true) {
	        ConsumerRecords<String, byte[]> records = consumer.poll(100);
	        for (ConsumerRecord<String, byte[]> record : records) {
				/**
				 * 稍后处理逻辑如下：
				 * 做个线程池做消息的策略效验、入库
				 */
				//System.out.printf("offset = %d, key = %s, value = %c", record.offset(), record.key(), record.value() + "\n");
				System.out.println("offset="+record.offset()+" key="+record.key()+" value="+record.value());
	        }
	    }
    }  
    
    private static Properties getConfig() {
    	Properties props = new Properties();  
    	props.put("bootstrap.servers", "192.168.3.5:9092");
    	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  
    	props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

    	//消费者的组id
    	props.setProperty("group.id", "0");  
    	props.setProperty("enable.auto.commit", "true"); 
//    	props.put("auto.commit.interval.ms", "1000");
//    	//从poll(拉)的回话处理时长
//    	props.put("session.timeout.ms", "30000");
//    	//poll的数量限制
//    	props.put("max.poll.records", "100");
    	props.setProperty("auto.offset.reset", "earliest");
    	return props;
    }

	/**
	 * 单例
	 */
	private KafkaConsumerUtil(){}
	private static class LazyHolder {
		private static final KafkaConsumerUtil INSTANCE = new KafkaConsumerUtil();
	}
	public static final KafkaConsumerUtil getInstance() {
		return LazyHolder.INSTANCE;
	}

}  