package com.xunyu.shiro.config;

import com.commons.core.framework.SpringContextHolder;
import com.xunyu.config.redis.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 全局监听
 */
public class MyShiroSessionListener implements SessionListener {  
  
    @Override  
    public void onStart(Session session) {  
          
    }  
  
    @Override  
    public void onStop(Session session) {  
        // TODO Auto-generated method stub  
        System.out.println("onStop==="+session.getId());  
        RedisUtil redisUtil=(RedisUtil) SpringContextHolder.getBean("redisUtil");
        redisUtil.remove(session.getId().toString());
    }  
  
    @Override  
    public void onExpiration(Session session) {  
        System.out.println("onExpiration==="+session.getId());
        RedisUtil redisUtil=(RedisUtil) SpringContextHolder.getBean("redisUtil");
        redisUtil.remove(session.getId().toString());
  
    }  
  
}  