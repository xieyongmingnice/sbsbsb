package com.xunyu.sgip.config.kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.errors.UnknownTopicOrPartitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class AdminClientLocal {
    private static Logger log = LoggerFactory.getLogger(AdminClientLocal.class);

   /* public static void main(String[] args) throws Exception {
        GetProperties.getInstance();
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, GetProperties.bootstrapServers);
        try  {
            AdminClient client = AdminClient.create(props);
            *//*describeCluster(client);
            createTopics(client);
            listAllTopics(client);

            alterConfigs(client);
            describeConfig(client);
            deleteTopics(client);*//*
            System.out.println(describeTopics(client,"http_ding88"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    /**
     * 查询 kafka 集群节点信息
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static boolean describeCluster(AdminClient client){
        boolean flag = false;
        try{
            DescribeClusterResult ret = client.describeCluster();
            System.out.println(String.format("Cluster id: %s, controller: %s", ret.clusterId().get(), ret.controller().get()));
            System.out.println("Current cluster nodes info: ");
            for (Node node : ret.nodes().get()) {
                System.out.println(node);
            }
            flag = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * describe topic‘s config
     * @param client
     */
    public static boolean describeConfig(AdminClient client,String topic){
        boolean flag = false;
        try {
            DescribeConfigsResult ret = client.describeConfigs(Collections.singleton(new ConfigResource(ConfigResource.Type.TOPIC, topic)));
            Map<ConfigResource, Config> configs = ret.all().get();
            for (Map.Entry<ConfigResource, Config> entry : configs.entrySet()) {
                ConfigResource key = entry.getKey();
                Config value = entry.getValue();
                System.out.println(String.format("Resource type: %s, resource name: %s", key.type(), key.name()));
                Collection<ConfigEntry> configEntries = value.entries();
                for (ConfigEntry each : configEntries) {
                    System.out.println(each.name() + " = " + each.value());
                }
            }
            flag = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * alter config for topics
     * @param client
     */
    public static boolean alterConfigs(AdminClient client,String topic){
        boolean flag = false;
        try {
            Config topicConfig = new Config(Arrays.asList(new ConfigEntry("cleanup.policy", "compact")));
            client.alterConfigs(Collections.singletonMap(
                    new ConfigResource(ConfigResource.Type.TOPIC, topic), topicConfig)).all().get();
            flag = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * delete the given topics
     * @param client
     */
    public static boolean deleteTopics(AdminClient client,String topic) {
        boolean flag = false;
        try {
            KafkaFuture<Void> futures = client.deleteTopics(Arrays.asList(topic)).all();
            futures.get();
            flag = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * describe the given topics
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static boolean describeTopics(AdminClient client,String topic) {
        boolean flag = false;
        try {
            DescribeTopicsResult ret = client.describeTopics(Arrays.asList(topic, "__consumer_offsets"));
            Map<String, TopicDescription> topics = ret.all().get();//同步等待消息的返回
            /*for (Map.Entry<String, TopicDescription> entry : topics.entrySet()) {
               // System.err.println(entry.getKey() + " ===> " + entry.getValue());
            }*/
        }catch (UnknownTopicOrPartitionException e){
            log.info("该主题不存在---------------------------");
            flag = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * create multiple sample topics
     * @param client
     */
    public static boolean createTopics(AdminClient client,String topic,int numPartition,int fu){
        boolean flag = false;
        try {
            NewTopic newTopic = new NewTopic(topic, numPartition, (short) fu);
            CreateTopicsResult ret = client.createTopics(Arrays.asList(newTopic));
            ret.all().get();
            flag = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * print all topics in the cluster
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void listAllTopics(AdminClient client) throws ExecutionException, InterruptedException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true); // 也查询内部主题
        ListTopicsResult topics = client.listTopics(options);
        Set<String> topicNames = topics.names().get();
        System.out.println("Current topics in this cluster: " + topicNames);
    }
}