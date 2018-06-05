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

    	Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);  
    	//订阅主题列表topic
    	consumer.subscribe(Lists.newArrayList(topic));   

	    //不断监听新消息
	    while (true) {
	        ConsumerRecords<String, String> records = consumer.poll(100);
	        for (ConsumerRecord<String, String> record : records) {
				//　正常这里应该使用线程池处理，不应该在这里处理
				System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value() + "\n");
			}
	    }
    }  
    
    private static Properties getConfig() {
    	Properties props = new Properties();  
    	props.put("bootstrap.servers", "localhost:9092");  
    	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  
    	props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  

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

	public static void main(String[]args) {
		KafkaConsumerUtil consumer = KafkaConsumerUtil.getInstance();
		consumer.consume("dingtonghao2");
	}
}  