package com.xunyu.sgip.config.kafka.producter;

import com.xunyu.sgip.config.kafka.admin.AdminClientLocal;
import com.xunyu.sgip.config.utils.GetProperties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消息提供者
 */
public class KafkaProducerZhe {
    private static Logger log = Logger.getLogger(KafkaProducerZhe.class);
    private Properties properties = null;
    private final int NUM = 12;
    /**
     * 消息发送
     */
    public void sendMessage(String topic,String key,byte[] msgValue,int numPartitions,int factor) throws FileNotFoundException {
        if (null == properties) {
            properties = getConfig();
        }
        AdminClient adminClient = AdminClient.create(properties);
        //创建主题并指定分区
        boolean flag = AdminClientLocal.describeTopics(adminClient,topic);
        if(!flag) {//判断主题是否已经存在
            AdminClientLocal.createTopics(adminClient, topic, numPartitions, factor);
        }
        ExecutorService ex = Executors.newFixedThreadPool(GetProperties.THREAD_NUM);
        KafkaProducer<String, byte[]> producer = null;
        try {
            producer = new KafkaProducer<String, byte[]>(properties);
            for (int i = 0; i < NUM; i++) {
                // 发送
                ProducerRecord<String, byte[]> record =
                        new ProducerRecord<String, byte[]>(topic, key + i, msgValue);
                ex.submit(new ProductThread(producer, record, topic, msgValue));
                if(i % 2 == 0) {
                    Thread.sleep(2000L); //睡眠2秒钟
                }

            }
        }catch (Exception e){
            log.info(e.getMessage());
        }finally {
            producer.flush();
            producer.close();
            ex.shutdown();

        }

    }

    private static Properties getConfig() {

        Properties props = new Properties();
        /*
         * 参数说明
         */
        props.put("bootstrap.servers", GetProperties.bootstrapServers);
        props.put("zk.connect", GetProperties.zkConnect);
        // 配置metadata.broker.list, 为了高可用, 最好配两个broker实例
        //props.put("metadata.broker.list", GetProperties.metadataBrokerList);//192.168.3.5:9092,192.168.3.6:9092,192.168.3.7:9092
        // serializer.class为消息的序列化类:
        // 可选：kafka.serializer.StringEncoder; 默认：kafka.serializer.DefaultEncoder
        props.put("serializer.class", GetProperties.serializerClass);
        // serializer详细配置
        props.put("key.serializer", GetProperties.keySerializer);
        props.put("value.serializer", GetProperties.valueSerializer);
        //“所有”设置将导致记录的完整提交阻塞，最慢的，但最持久的设置。
        props.put("acks", GetProperties.acks);
        // ACK机制, 消息发送需要kafka服务端确认
        // 0表示不等待结果返回;1表示等待至少有一个服务器返回数据接收标识;-1表示必须接收到所有的服务器返回标识，及同步写入
        props.put("request.required.acks", GetProperties.requestRequiredAcks);
        //如果请求失败，生产者也会自动重试，即使设置成０ the producer can automatically retry.
        props.put("retries", GetProperties.retries);
        //默认立即发送，这里这是延时毫秒数
        props.put("linger.ms", GetProperties.lingerMs);
        //内部发送数据是异步还是同步{sync：同步( 默认),async：异步}
        props.put("producer.type", GetProperties.producerType);
        //生产者缓冲大小，当缓冲区耗尽后，额外的发送调用将被阻塞。时间超过max.block.ms将抛出TimeoutException
        props.put("buffer.memory", GetProperties.bufferMemory);
        //The producer maintains buffers of unsent records for each partition.
        props.put("batch.size", GetProperties.batchSize);
        // 重试次数
        props.put("message.send.max.retries", GetProperties.messageSendMaxRetries);
        // 异步提交的时候(async)，并发提交的记录数
        props.put("batch.num.messages", GetProperties.batchNumMessages);
        // 设置缓冲区大小，默认10KB
        props.put("send.buffer.bytes", GetProperties.sendBufferBytes);
        props.put("auto.create.topics.enable", GetProperties.autoCreateTopicsEnable);
        /*
         * 自定义分区
         * 配置partitioner选择策略
         */
        props.put("partitioner.class", "com.xunyu.sgip.config.process.SimplePartitioner2");
        return props;
    }

    public static void main(String[] args) {
        int index = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                log.info("当前值是：" + index++);
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }
        //GetProperties.getInstance();
        /*KafkaProducerZhe kk = new KafkaProducerZhe();
        try {
          kk.sendMessage("test2","http_ding",new byte[5],4,2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);*/
    }
}