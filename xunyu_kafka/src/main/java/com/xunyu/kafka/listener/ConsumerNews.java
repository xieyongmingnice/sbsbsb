package com.xunyu.kafka.listener;

import com.xunyu.kafka.config.sink.Sink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * 消费消息
 * @author dth
 * @date 2018/5/15 14:05
 **/
//@EnableBinding(Sink.class)
public class ConsumerNews {

   /* @StreamListener(Sink.INPUT_1)
    public void receive(Message<String> message) {
        System.out.println(message.getPayload());
    }*/
}
