package com.xunyu.logs.controller.http;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.logs.service.http.HttpOperationNoticeService;
import com.xunyu.model.log.http.HttpOperationNotice;
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
 * @date 2018/5/23 14:05
 **/
@RestController
@RequestMapping("httpOper/")
public class HttpOperationNotController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private HttpOperationNoticeService httpOperationNoticeService;

    /**
     * 获取列表
     */
    @RequestMapping(value = "listHttpOperationNotice",method = RequestMethod.POST)
    public Result<List<HttpOperationNotice>> listHttpOperationNoticeData(HttpOperationNotice o) throws Exception {
        Result<List<HttpOperationNotice>> res = new Result<List<HttpOperationNotice>>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        map.put("noticeCode",o.getNoticeCode());
        map.put("nodeType",o.getNodeType());
        map.put("noticeState",o.getNoticeState());
        map.put("handleState",o.getHandleState());
        map.put("operaUser",o.getOperaUser());
        map.put("startRow",o.getStartRows());
        map.put("endRow",o.getEndRows());
        int total = 0;
        total = httpOperationNoticeService.countHttpOperationNotice(map);
        if(total > 0){
          List<HttpOperationNotice> list = httpOperationNoticeService.listHttpOperationNotice(map);
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
    @RequestMapping(value = "delHttpOperationNotice",method = RequestMethod.POST)
    public Result<HttpOperationNotice> delHttpOperationNoticeData(HttpOperationNotice o) throws Exception {
        Result<HttpOperationNotice> res = new Result<HttpOperationNotice>();
        User us = redisUtil.getCurrUser(o.getSessionId());
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(o.getNoticeIds())){
            httpOperationNoticeService.delHttpOperationNotice(o.getNoticeIds());
            res.setCode("200");
            res.setMessage("success");
        }else{
            res.setCode("412");
            res.setMessage("noticeIds不能为空");
        }
        return res;
    }
}
