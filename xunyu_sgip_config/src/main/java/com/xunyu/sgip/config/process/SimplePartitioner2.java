package com.xunyu.sgip.config.process;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 策略 、分区
 */
public class SimplePartitioner2 implements Partitioner {

    private static Logger LOG = LoggerFactory.getLogger(SimplePartitioner2.class);

    //自定义分区器算法实现
    @Override
    public int partition(String topic, Object key, byte[] keyBytes
            , Object value, byte[] valueBytes, Cluster cluster) {

        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        int partitionNum = 0;
        try {
            partitionNum = Integer.parseInt((String) key);
        } catch (Exception e) {
            partitionNum = key.hashCode();
        }
        int n = Math.abs(partitionNum % numPartitions);
        return n;
    }

    @Override
    public void close() { }

    @Override
    public void configure(Map<String, ?> map) {

    }
 
}