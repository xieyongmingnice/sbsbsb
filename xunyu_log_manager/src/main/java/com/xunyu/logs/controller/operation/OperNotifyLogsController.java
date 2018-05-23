package com.xunyu.logs.controller.operation;

import com.commons.core.message.Result;
import com.commons.core.util.DateUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.logs.service.operation.OperNotifyLogsService;
import com.xunyu.model.log.operation.OperNotifyLogs;
import com.xunyu.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 13:32
 **/
@RestController
@RequestMapping("notify/")
public class OperNotifyLogsController {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private OperNotifyLogsService operNotifyLogsService;

    /**
     * 获取列表
     */
    @RequestMapping(value = "listOperNotifyLogs",method = RequestMethod.POST)
    public Result<List<OperNotifyLogs>> listOperNotifyLogsData(OperNotifyLogs o) throws Exception{
        Result<List<OperNotifyLogs>> res = new Result<List<OperNotifyLogs>>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(o.getBeginTime())) {
            map.put("beginTime", DateUtils.string2Date(o.getBeginTime()));
            map.put("endTime", DateUtils.getUpDate(o.getBeginTime(), o.getEndTime()));
        }
        map.put("nodeType",o.getNodeType());
        map.put("notifyCode",o.getNotifyCode());
        map.put("notifyStatus",o.getNotifyStatus());
        map.put("operUser",o.getOperUser());
        map.put("handleStatus",o.getHandleStatus());
        map.put("startRow",o.getStartRows());
        map.put("endRow",o.getEndRows());
        int total = 0;
        total = operNotifyLogsService.countOperNotifyLogs(map);
        if(total > 0){
           List<OperNotifyLogs> list = operNotifyLogsService.listOperNotifyLogs(map);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(list);
            res.setTotalRows(total);
        }else{
            res.setCode("412");
            res.setMessage("notvalue");
        }
        return res;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delOperNotifyLogs",method = RequestMethod.POST)
    public Result<OperNotifyLogs> delOperNotifyLogsData(OperNotifyLogs o) throws Exception {
        Result<OperNotifyLogs> res = new Result<OperNotifyLogs>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(o.getNotifyIds())){
            operNotifyLogsService.delOperNotifyLogs(o.getNotifyIds());
            res.setCode("200");
            res.setMessage("success");
        }else{
            res.setCode("413");
            res.setMessage("notifyIds不能为空");
        }
        return res;
    }
}
