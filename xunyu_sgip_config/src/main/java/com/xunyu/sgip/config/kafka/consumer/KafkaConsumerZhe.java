package com.xunyu.sgip.config.kafka.consumer;

import com.xunyu.sgip.config.utils.GetProperties;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author dth
 * @date 2018/6/8 11:13
 **/
public class KafkaConsumerZhe {
    private Properties properties = null;
    /**
     * 自动提交offset
     */
    public void commitAuto(List<String> topics) throws FileNotFoundException {
        if(null == properties) {
            properties = getConfig();
        }
        Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(properties);
        consumer.subscribe(topics); //订阅主题
        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(100);
            for (ConsumerRecord<String, byte[]> record : records)
                //System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                System.err.println("offset="+record.offset()+" key="+record.key()
                        +" value="+record.value()+" partiton="+record.partition());
        }
    }

    /**
     * 手动提交offset
     *
     * @throws FileNotFoundException
     */
    public void commitControl(List<String> topics) throws FileNotFoundException {
        if(null == properties) {
            properties = getConfig();
        }
        Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(properties);
        consumer.subscribe(topics);
        final int minBatchSize = 2;
        List<ConsumerRecord<String, byte[]>> buffer = new ArrayList<ConsumerRecord<String, byte[]>>();
        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(1000);
            for (ConsumerRecord<String, byte[]> record : records) {
                buffer.add(record);
            }
            if (buffer.size() >= minBatchSize) {
                insertIntoDb(buffer);
                // 阻塞同步提交
                consumer.commitSync();
                buffer.clear();
            }
        }
    }

    /**
     * 手动设置分区
     */
    public void setOffSet(List<String> topics) throws FileNotFoundException {
        if(null == properties) {
            properties = getConfig();
        }
        Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(properties);
        consumer.subscribe(topics);

        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(Long.MAX_VALUE);
            // 处理每个分区消息后, 提交偏移量
            for (TopicPartition partition : records.partitions()) {
                List<ConsumerRecord<String, byte[]>> partitionRecords = records.records(partition);

                for (ConsumerRecord<String, byte[]> record : partitionRecords) {
                    System.out.println(record.offset() + ": " + record.value());
                }
                long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
                consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
            }
        }
    }

    /**
     * 手动设置消息offset
     */
    public void setSeek(List<String> topics) throws FileNotFoundException {
        if(null == properties) {
            properties = getConfig();
        }
        Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(properties);
        //consumer.subscribe(topics);
        TopicPartition p = new TopicPartition("http_zhixin",0);
        consumer.assign(Arrays.asList(p));
        consumer.seek(p,5);
        ConsumerRecords<String, byte[]> records = consumer.poll(100);

        for (ConsumerRecord<String, byte[]> record : records) {
            //System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            System.out.println("offset="+record.offset()+" key="+record.key()
                    +" value="+record.value()+" partiton="+record.partition());
            consumer.commitSync();
        }

    }

    /**
     * doSomethings
     */
    private void insertIntoDb(List<ConsumerRecord<String, byte[]>> buffer) {
        buffer.stream().map(x -> x.value()).forEach(System.err::println);
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
        props.put("auto.commit.interval.ms", GetProperties.autoCommitIntervalMs);
        return props;
    }

    public static void main(String[] args) {
        GetProperties.getInstance();
        KafkaConsumerZhe kk = new KafkaConsumerZhe();
        ArrayList<String> topics = new ArrayList<>();
        try {
            topics.add("ding9");
            kk.commitAuto(topics);
           // kk.commitControl(topics);
            //kk.setOffSet(topics);
            //kk.setSeek(topics);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}
