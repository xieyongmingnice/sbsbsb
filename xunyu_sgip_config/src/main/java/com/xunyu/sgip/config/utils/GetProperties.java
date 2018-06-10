package com.xunyu.sgip.config.utils;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * @ClassName: GetProperties
 * @Description: 获取配置文件信息
 * @version: 1.0.0
 */
public class GetProperties {

    public static int THREAD_NUM = 10;//线程数目
    private final static String FILEPATH = "sgip-config.properties";
    public static String bootstrapServers;
    public static String zkConnect;
    public static String metadataBrokerList;
    public static String serializerClass;
    public static String keySerializer;
    public static String valueSerializer;
    public static String acks;
    public static String requestRequiredAcks;
    public static String retries;
    public static String lingerMs;
    public static String producerType;
    public static String bufferMemory;
    public static String batchSize;
    public static String messageSendMaxRetries;
    public static String batchNumMessages;
    public static String sendBufferBytes;
    public static String numPartitions;
    public static String partitionerClass;
    public static String keyDeserializer;
    public static String valueDeserializer;
    public static String groupId;
    public static String enableAutoCommit;
    public static String autoOffsetReset;
    public static String autoCommitIntervalMs;
    public static String autoCreateTopicsEnable;


    /**
     *
     * @Title: printAllProperty
     * @Description: 输出所有配置信息
     * @param props
     * @return void
     * @throws
     */
    private static void printAllProperty(Properties props) {
        @SuppressWarnings("rawtypes")
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();

            if("auto.offset.reset".equals(key)){
                autoOffsetReset = props.getProperty(key);
            }else if("enable.auto.commit".equals(key)){
                enableAutoCommit = props.getProperty(key);
            }else if("group.id".equals(key)){
                groupId = props.getProperty(key);
            }else if("value.deserializer".equals(key)){
                valueDeserializer = props.getProperty(key);
            }else if("key.deserializer".equals(key)){
                keyDeserializer = props.getProperty(key);
            }else if("partitioner.class".equals(key)){
                partitionerClass = props.getProperty(key);
            }else if("num.partitions".equals(key)){
                numPartitions = props.getProperty(key);
            }else if("send.buffer.bytes".equals(key)){
                sendBufferBytes = props.getProperty(key);
            }else if("batch.num.messages".equals(key)){
                batchNumMessages = props.getProperty(key);
            }else if("message.send.max.retries".equals(key)){
                messageSendMaxRetries = props.getProperty(key);
            }else if("batch.size".equals(key)){
                batchSize = props.getProperty(key);
            }else if("buffer.memory".equals(key)){
                bufferMemory = props.getProperty(key);
            }else if("producer.type".equals(key)){
                producerType = props.getProperty(key);
            }else if("linger.ms".equals(key)){
                lingerMs = props.getProperty(key);
            }else if("retries".equals(key)){
                retries = props.getProperty(key);
            }else if("request.required.acks".equals(key)){
                requestRequiredAcks = props.getProperty(key);
            }else if("acks".equals(key)){
                acks = props.getProperty(key);
            }else if("value.serializer".equals(key)){
                valueSerializer = props.getProperty(key);
            }else if("key.serializer".equals(key)){
                keySerializer = props.getProperty(key);
            }else if("serializer.class".equals(key)){
                serializerClass = props.getProperty(key);
            }else if("metadata.broker.list".equals(key)){
                metadataBrokerList = props.getProperty(key);
            }else if("zk.connect".equals(key)){
                zkConnect = props.getProperty(key);
            }else if("bootstrap.servers".equals(key)){
                bootstrapServers = props.getProperty(key);
            }else if("auto.commit.interval.ms".equals(key)){
                autoCommitIntervalMs = props.getProperty(key);
            }else if("auto.create.topics.enable".equals(key)){
                autoCreateTopicsEnable = props.getProperty(key);
            }
        }
    }
    /**
     * 根据key读取value
     * 
     * @Title: getProperties_1   
     * @Description: 第一种方式：根据文件名使用spring中的工具类进行解析  
     *                  filePath是相对路劲，文件需在classpath目录下
     *                   比如：config.properties在包com.test.config下， 
     *                路径就是com/test/config/config.properties    
     *
     * @param keyWord      
     * @return
     * @return String  
     * @throws
     */
    public static String getProperties_1(String keyWord){
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties(FILEPATH);
            // 根据关键字查询相应的值
            value = prop.getProperty(keyWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 读取配置文件所有信息
     *
     * @Title: getProperties_1
     * @Description: 第一种方式：根据文件名使用Spring中的工具类进行解析
     *                  filePath是相对路劲，文件需在classpath目录下
     *                   比如：config.properties在包com.test.config下，
     *                路径就是com/test/config/config.properties
     *
     * @return void
     * @throws
     */
    public static void getProperties_1(){
        Properties prop = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties(FILEPATH);
            printAllProperty(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private GetProperties(){
        getProperties_1();
        System.out.println("kafka config complete......");
    }

    private static class LazyHolder {
        private static final GetProperties INSTANCE = new GetProperties();
    }
    public static final GetProperties getInstance() {
        return LazyHolder.INSTANCE;
    }

}