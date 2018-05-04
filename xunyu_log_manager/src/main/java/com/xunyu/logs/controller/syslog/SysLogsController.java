package com.xunyu.logs.controller.syslog;

import com.xunyu.config.redis.RedisUtil;
import com.xunyu.logs.service.syslog.SysLogsService;
import com.xunyu.model.log.syslog.SysLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dth
 * @date 2018/5/3 17:53
 **/
@RestController
@RequestMapping("/syslog")
public class SysLogsController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysLogsService logsService;

    /**
     * 添加系统日志
     */
    @RequestMapping(value = "addSysLogs",method = RequestMethod.POST)
    public int addSysLogsData(@RequestBody  SysLogs logs) throws Exception{

        int n = logsService.addSysLog(logs);
        return n;
    }
}
