package com.xunyu.kafka.config.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 *  Sink用于有单个输入（inbound）通道的应用，通道名称为input
 */
public interface Sink {
    //接收队列1
    String INPUT_1 = "customInput1";

    @Input(Sink.INPUT_1)
    SubscribableChannel input1();

}