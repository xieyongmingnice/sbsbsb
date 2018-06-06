package com.xunyu.sgip.config.utils;

import jersey.repackaged.com.google.common.collect.Lists;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.List;
import java.util.Properties;

public class KafkaConsumerUtil { 
	private Properties props = null;
    public void consume(List<String> topics) {
    	if(null == props)
    		props = getConfig();

    	Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(props);
    	//订阅主题列表topic
    	consumer.subscribe(Lists.newArrayList("b1"));

	    //不断监听新消息
	    while (true) {
	        ConsumerRecords<String, byte[]> records = consumer.poll(100);
	        for (ConsumerRecord<String, byte[]> record : records) {
				/**
				 * 稍后处理逻辑如下：
				 * 做个线程池做消息的策略效验、入库
				 */
				//System.out.printf("offset = %d, key = %s, value = %c", record.offset(), record.key(), record.value() + "\n");
				System.out.println("offset="+record.offset()+" key="+record.key()
						+" value="+record.value()+" partiton="+record.partition());
	        }
	    }
    }  
    
    private static Properties getConfig() {
    	Properties props = new Properties();  
    	props.put("bootstrap.servers", GetProperties.bootstrapServers);
    	props.put("key.deserializer", GetProperties.keyDeserializer);
    	props.put("value.deserializer", GetProperties.valueDeserializer);

    	//消费者的组id
    	props.setProperty("group.id", GetProperties.groupId);
    	props.setProperty("enable.auto.commit", GetProperties.enableAutoCommit);
//    	props.put("auto.commit.interval.ms", "1000");
//    	//从poll(拉)的回话处理时长
//    	props.put("session.timeout.ms", "30000");
//    	//poll的数量限制
//    	props.put("max.poll.records", "100");
		//默认值为largest，代表最新的消息，smallest代表从最早的消息开始读取
    	props.setProperty("auto.offset.reset", GetProperties.autoOffsetReset);
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