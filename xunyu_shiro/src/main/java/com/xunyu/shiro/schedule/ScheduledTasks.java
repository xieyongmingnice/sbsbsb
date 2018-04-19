package com.xunyu.shiro.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 调度任务
 */
@Component
public class ScheduledTasks {
  //  private static final Logger log = (Logger) LoggerFactory.getLogger(ScheduledTasks.class);
    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
    @Scheduled(fixedRate = 400000) //用于设置任务间隔
    public void reportCurrentTime() {
        logger.info("reportCurrentTime");
    }

    @Scheduled(fixedDelay=500000)//可使用多个

	public void doSomething() {
        logger.info("doSomething");
    }

}