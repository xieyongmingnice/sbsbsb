package com.xunyu.sgip.config.kafka.producter;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductThread implements Runnable {

    private Logger log = LoggerFactory.getLogger(ProductThread.class);
    private KafkaProducer<String, byte[]> producer;
    private ProducerRecord<String, byte[]> record;
    private String topic;
    private byte[] msg;

    @Override
    public void run() {
        //producer.send(record, new CallBackFuntion(topic, message));
        producer.send(record, (recordMetadata, e) -> {
            if (e != null) {
                //System.err.println("消息发送失败:"+e.getMessage());
                log.info("消息发送失败:"+e.getMessage());
            } else {
                System.err.println("分区=" + recordMetadata.partition() + "偏移量=" + recordMetadata.offset());
            }
        });
    }

    public ProductThread(KafkaProducer<String, byte[]> producer, ProducerRecord<String, byte[]> record) {
        this.producer = producer;
        this.record = record;
    }

    public ProductThread(KafkaProducer<String, byte[]> producer, ProducerRecord<String, byte[]> record, String topic, byte[] msg) {
        this.producer = producer;
        this.record = record;
        this.topic = topic;
        this.msg = msg;
    }
}
