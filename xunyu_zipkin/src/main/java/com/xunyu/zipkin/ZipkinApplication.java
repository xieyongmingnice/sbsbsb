package com.xunyu.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;


@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplication {
    private static final Logger log = LoggerFactory.getLogger(ZipkinApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

}


