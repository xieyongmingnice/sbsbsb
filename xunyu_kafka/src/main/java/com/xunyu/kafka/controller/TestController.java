package com.xunyu.kafka.controller;

import com.xunyu.kafka.config.source.Source;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableBinding(Source.class)
public class TestController {

    @Resource
    private MessageChannel customOutput1;

    @GetMapping("/sendMsg")
    public String sendShopMessage(String content) {
        boolean isSendSuccess = customOutput1.
                send(MessageBuilder.withPayload(content).build());
        return isSendSuccess ? content : "发送失败";
    }


}