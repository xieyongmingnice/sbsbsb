package com.xunyu.logs.controller.link;

import com.commons.core.message.Result;
import com.commons.core.util.DateUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.logs.service.link.LinkOperLogsService;
import com.xunyu.model.log.link.LinkOperLogs;
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
 * @date 2018/5/23 13:45
 **/
@RestController
@RequestMapping("link/")
public class LinkOperLogsController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private LinkOperLogsService linkOperLogsService;

    /**
     * 获取列表
     */
    @RequestMapping(value = "listLinkOperLogs",method = RequestMethod.POST)
    public Result<List<LinkOperLogs>> listLinkOperLogsData(LinkOperLogs o) throws Exception {
        Result<List<LinkOperLogs>> res = new Result<List<LinkOperLogs>>();
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
        map.put("startRow",o.getStartRows());
        map.put("endRow",o.getEndRows());
        map.put("gatewayNode",o.getGatewayNode());
        map.put("duiduanIp",o.getDuiduanIp());
        map.put("agreement",o.getAgreement());
        map.put("linkStatus",o.getLinkStatus());
        map.put("gatewayNode",o.getGatewayNode());
        int total = 0;
        total = linkOperLogsService.countLinkOperLogs(map);
        if(total > 0){
           List<LinkOperLogs> list = linkOperLogsService.listLinkOperLogs(map);
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
    @RequestMapping(value = "delLinkOperLogs",method = RequestMethod.POST)
    public Result<LinkOperLogs> delLinkOperLogsData(LinkOperLogs o) throws Exception {
        Result<LinkOperLogs> res = new Result<LinkOperLogs>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(o.getLinkIds())){
            linkOperLogsService.delLinkOperLogs(o.getLinkIds());
            res.setCode("200");
            res.setMessage("success");
        }else{
            res.setCode("413");
            res.setMessage("linkIds不能为空");
        }
        return res;
    }
}
