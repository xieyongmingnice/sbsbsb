package com.xunyu.shiro.redis;

import com.commons.core.util.StringUtils2;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
  
@Configuration  
@EnableCaching  
public class RedisConfig extends CachingConfigurerSupport {  
  
    @Value("${spring.redis.hostName}")  
    private String hostName;  
    @Value("${spring.redis.port}")  
    private int port;  
    @Value("${spring.redis.timeOut}")  
    private int timeOut;  
    @Value("${spring.redis.maxIdle}")  
    private int maxIdle;// 最大空闲连接数, 默认8个  
    @Value("${spring.redis.maxWaitMillis}")  
    private int maxWaitMillis;// 获取连接时的最大等待毫秒数  
    @Value("${spring.redis.testOnBorrow}")  
    private boolean testOnBorrow;// 在获取连接的时候检查有效性, 默认false  
    @Value("${spring.redis.testWhileIdle}")  
    private boolean testWhileIdle;// 空闲是否检查是否有效，默认为false  
    @Value("${spring.redis.redisPassWord}")
    private String redisPassWord;

    @Bean("jedisPoolConfig")  
    public JedisPoolConfig jedisPoolConfig() {  
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();  
        jedisPoolConfig.setMaxIdle(maxIdle);  
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);  
        jedisPoolConfig.setTestOnBorrow(true);  
        jedisPoolConfig.setTestWhileIdle(false);  
        return jedisPoolConfig;  
    }  
  
    @Bean  
    public JedisConnectionFactory redisConnectionFactory(  
            JedisPoolConfig jedisPoolConfig) {  
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();  
        redisConnectionFactory.setPoolConfig(jedisPoolConfig);  
        redisConnectionFactory.setHostName(hostName);  
        redisConnectionFactory.setPort(port);  
        redisConnectionFactory.setTimeout(timeOut);
        if(StringUtils2.isNotEmpty(redisPassWord)) {
            redisConnectionFactory.setPassword(redisPassWord);
        }
        //redisConnectionFactory.getConnection().select(15);//设置链接哪个库默认是0
        return redisConnectionFactory;  
    }  
  
    /** 
     * RedisTemplate配置 
     *  
     * @param //factory
     * @return 
     */  
    @Bean  
    public RedisTemplate<String, Object> redisTemplate(  
            JedisConnectionFactory redisConnectionFactory) {  
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();  
        redisTemplate.setConnectionFactory(redisConnectionFactory);  
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();  
        redisTemplate.setKeySerializer(redisSerializer);
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jdkSerializationRedisSerializer.serialize(om);
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        return redisTemplate;  
    }  
  
    @Bean  
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {  
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);  
        // Number of seconds before expiration. Defaults to unlimited (0)  
        // cacheManager.setDefaultExpiration(10); //设置key-value超时时间  
        return cacheManager;  
    }  
  
}  