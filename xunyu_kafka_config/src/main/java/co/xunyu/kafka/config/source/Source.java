package co.xunyu.kafka.config.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *  Source用于有单个输出（outbound）通道的应用，通道名称为output
 */
public interface Source {
    //发送队列1
    String OUTPUT_1 = "customOutput1";
    @Output(Source.OUTPUT_1)
    MessageChannel output1();

}