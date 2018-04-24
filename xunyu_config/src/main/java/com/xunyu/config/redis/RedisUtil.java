package com.xunyu.config.redis;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisUtil {  
  
    private Logger logger = LoggerFactory.getLogger(RedisUtil.class);  
  
    private RedisTemplate<String, Object> redisTemplate;
  
    /** 
     * 批量删除对应的value 
     *  
     * @param keys 
     */  
    public void remove(final String... keys) {  
        for (String key : keys) {  
            remove(key);  
        }  
    }  
  
    /** 
     * 批量删除key 
     *  
     * @param pattern 
     */  
    public void removePattern(final String pattern) {  
        Set<String> keys = redisTemplate.keys(pattern);  
        if (keys.size() > 0)  
            redisTemplate.delete(keys);  
    }  
  
    /** 
     * 删除对应的value 
     *  
     * @param key 
     */  
    public void remove(final String key) {  
        if (exists(key)) {  
            redisTemplate.delete(key);  
        }  
    }  
  
    /** 
     * 判断缓存中是否有对应的value 
     *  
     * @param key 
     * @return 
     */  
    public boolean exists(final String key) {  
        return redisTemplate.hasKey(key);  
    }  
  
    /** 
     * 获取所有的key 
     *  
     * @return 
     */  
    public Set<String> keys() {  
        return redisTemplate.keys("*");  
    }  
  
    /** 
     * 读取缓存 
     *  
     * @param key 
     * @return 
     */  
    public Object get(final String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate
                .opsForValue();  
        result = operations.get(key);
        return result;  
    }  
  
    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, Object value) {  
        boolean result = false;  
        try {  
            ValueOperations<String, Object> operations = redisTemplate  
                    .opsForValue();  
            operations.set(key, value);  
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, Object value, Long expireTime) {  
        boolean result = false;  
        try {  
            ValueOperations<String, Object> operations = redisTemplate  
                    .opsForValue();  
            operations.set(key, value);  
            redisTemplate.expire(key, expireTime, TimeUnit.MINUTES); //设置过期时间 expireTime * MINUTES(分钟)
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    public void setRedisTemplate(  
            RedisTemplate<String, Object> redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    }

    /**
     * 根据sessionId获取当前会话
     */
    public Session getSession(String sessionId) {
        byte[] session = (byte[]) get(sessionId);
        Session se = new SessionDao().byteToSession(session);
        return se;
    }
}  