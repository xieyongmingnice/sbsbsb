package com.xunyu.zuul;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.xunyu.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApiGatewayStarter {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayStarter.class, args);
    }

    /**
     * @return
     * @autor dth
     * 注入网关拦截 过滤器
     */
    @Bean
    public AccessFilter preRequestLogFilter() {
        return new AccessFilter();
    }

    /**
     * 开启ribbon 负载均衡的权重策略
     * 其它策略请参考https://blog.csdn.net/rickiyeat/article/details/64918756
     */
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();//这里配置策略，和配置文件对应
    }
}


