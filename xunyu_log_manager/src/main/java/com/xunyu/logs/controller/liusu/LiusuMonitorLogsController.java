package com.xunyu.logs.controller.liusu;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.logs.service.liusu.LiusuMonitorLogsService;
import com.xunyu.model.log.liusu.LiusuMonitorLogs;
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
 * @date 2018/5/23 13:56
 **/
@RestController
@RequestMapping("liusu/")
public class LiusuMonitorLogsController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private LiusuMonitorLogsService liusuMonitorLogsService;

    /**
     * 获取列表
     */
    @RequestMapping(value = "listLiusuMonitorLogs",method = RequestMethod.POST)
    public Result<List<LiusuMonitorLogs>> listLiusuMonitorLogsData(LiusuMonitorLogs o) throws Exception {
        Result<List<LiusuMonitorLogs>> res = new Result<List<LiusuMonitorLogs>>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        map.put("nodeStatus",o.getNodeStatus());
        map.put("nodeCode",o.getNodeCode());
        map.put("gatewayName",o.getGatewayName());
        map.put("enterpriseNode",o.getEnterpriseNode());
        map.put("enterpriseName",o.getEnterpriseName());
        map.put("startRow",o.getStartRows());
        map.put("endRow",o.getEndRows());
        int total = 0;
        total = liusuMonitorLogsService.countLiusuMonitorLogs(map);
        if(total > 0){
            List<LiusuMonitorLogs> list = liusuMonitorLogsService.listLiusuMonitorLogs(map);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(list);
            res.setTotalRows(total);
        }else{
            res.setCode("200");
            res.setMessage("notvalue");
        }
        return res;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delLiusuMonitorLogs",method = RequestMethod.POST)
    public Result<LiusuMonitorLogs> delLiusuMonitorLogsData(LiusuMonitorLogs o) throws Exception {
        Result<LiusuMonitorLogs> res = new Result<LiusuMonitorLogs>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(o.getLiusuIds())){
            liusuMonitorLogsService.delLiusuMonitorLogs(o.getLiusuIds());
            res.setCode("200");
            res.setMessage("success");
        }else{
            res.setCode("413");
            res.setMessage("liusuIds不能为空");
        }
        return res;
    }
}
