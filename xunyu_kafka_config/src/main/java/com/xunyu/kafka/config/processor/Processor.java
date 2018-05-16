package com.xunyu.kafka.config.processor;

import com.xunyu.kafka.config.sink.Sink;
import com.xunyu.kafka.config.source.Source;

/**
 * 用于单个应用同时包含输入和输出通道的情况，通道名称分别为output和input
 */
public interface Processor extends Source, Sink {
}