package com.xunyu.logs.controller.syslog;

import com.commons.core.message.Result;
import com.commons.core.util.DateUtils;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.logs.service.syslog.SysLogsService;
import com.xunyu.model.log.syslog.SysLogs;
import com.xunyu.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取系统日志列表
     */
    @RequestMapping(value = "sysLogsList",method = RequestMethod.POST)
    public Result<List<SysLogs>> sysLogListData(SysLogs sl) throws Exception{
        Result<List<SysLogs>> res = new Result<List<SysLogs>>();
        User us = redisUtil.getCurrUser(sl.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        map.put("beginTime",DateUtils.string2Date(sl.getBeginTime()));
        map.put("endTime",DateUtils.getUpDate(sl.getBeginTime(),sl.getEndTime()));
        map.put("logsId",sl.getLogsId());
        map.put("operName",sl.getOperName());
        map.put("operObj",sl.getOperObj());
        map.put("startRow",sl.getStartRows());
        map.put("endRow",sl.getEndRows());
        int total = 0;
        total = logsService.sysLogsCount(map);
        if(total > 0){
            List<SysLogs> list = logsService.sysLogsList(map);
            res.setRes(list);
            res.setMessage("success");
            res.setCode("200");
            res.setTotalRows(total);

        }else{
            res.setCode("412");
            res.setMessage("notvalue");
        }
        return res;
    }

    /**
     * 获取详情
     */
    @RequestMapping(value = "getSysLogsDetail",method = RequestMethod.POST)
    public Result<SysLogs> getSysLogsDetailData(SysLogs sl) throws Exception {
        Result<SysLogs> res = new Result<SysLogs>();
        User us = redisUtil.getCurrUser(sl.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(sl.getLogsId() != null){
            map.put("logsId",sl.getLogsId());
            sl = logsService.getSysLogsDetail(map);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(sl);
        }else{
            res.setCode("413");
            res.setMessage("logsId不能为空");
        }
        return res;
    }
}
