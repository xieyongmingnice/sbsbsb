package com.xunyu.sgip.config.log4j;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
* @project:     flume-log4j-test
* @Title:       FailoverLog4jAppender.java
* @Package:     org.apache
*/
public class FailoverLog4jAppender extends DailyRollingFileAppender {


    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {
        return this.getThreshold().equals(priority);
    }
}