package com.xunyu.sgip.config.kafka.producter.collback;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * 回调函数
 */
public class CallBackFuntion implements Callback {

    private String topic;
    private byte[] message;

    public CallBackFuntion(String topic, byte[] message) {
        this.topic = topic;
        this.message = message;
    }

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            System.out.println(topic + ": " + message + "--消息发送失败");
        }else {
            System.out.println("主题 = "+recordMetadata.toString());
            System.out.println("偏移量 = "+recordMetadata.offset());//1
            System.out.println("分区 = "+recordMetadata.partition());//1
        }
    }
}