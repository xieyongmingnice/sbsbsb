package com.xunyu.shiro.schedule;

import com.xunyu.config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 调度任务
 * @author  dth
 */
@Component
public class ScheduledTasks {

    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
    @Autowired
    RedisUtil redisUtil;

    @Scheduled(cron="0 0/30 * * * ?") //每30分钟执行一次
    public void reportCurrentTime() {
        logger.info("reportCurrentTime");
    }

    /*@Scheduled(fixedDelay=500000)//可使用多个

	public void doSomething() {
        logger.info("doSomething");
    }*/

}