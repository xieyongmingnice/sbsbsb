package com.xunyu.system.utils.syslog;

import com.xunyu.model.log.syslog.SysLogs;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dth
 * @date 2018/5/3 18:04
 **/
@Component
@FeignClient(value = "xunyu-log-manager")
public interface LogService2 {

    /**
     * 添加系统日志
     */
    @RequestMapping(value = "/syslog/addSysLogs",method = RequestMethod.POST ,consumes={"application/json"})
    int addSysLog(@RequestBody SysLogs sl);

}
