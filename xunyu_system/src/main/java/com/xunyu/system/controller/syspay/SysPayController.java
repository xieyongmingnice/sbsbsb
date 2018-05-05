package com.xunyu.system.controller.syspay;

import com.commons.core.message.Result;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.syspay.SysPayModel;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.syspay.SysPay;
import com.xunyu.system.service.syspay.SysPayService;
import com.xunyu.system.utils.syslog.LogService2;
import com.xunyu.system.utils.syslog.SysLogsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/27 11:24
 **/
@RestController
@RequestMapping(value = "/payconfig/")
public class SysPayController {
    /**
     * 注入
     */
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysPayService sysPayService;
    @Resource
    private LogService2 logService;

    /**
     * 添加支付配置信息
     */
    @RequestMapping(value = "addSysPay",method = RequestMethod.POST)
    public Result<SysPay> addSysPayData(SysPay sysPay,HttpServletRequest request) throws Exception{

        User us = redisUtil.getCurrUser(sysPay.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        Result<SysPay> res = new Result<SysPay>();
        int n = 0;
        if(us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            sysPay.setIsabled(1);
            sysPay.setCreateTime(new Date());
            sysPay.setUserId(us.getUserId());
            sysPay.setPayState(4);//默认全部不启用
            n = sysPayService.addSysPay(sysPay);
            res.setCode("200");
            res.setRes(sysPay);
            res.setMessage("success");
            if(n > 0) {
                //异步添加日志
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService,us,"添加支付配置信息","添加",request);
            }

        return res;
    }

    /**
     * 修改支付配置信息
     */
    @RequestMapping(value = "updateSysPay",method = RequestMethod.POST)
    public Result<SysPay> updateSysPayData(SysPay sysPay,HttpServletRequest request) throws Exception{

        User us = redisUtil.getCurrUser(sysPay.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        Result<SysPay> res = new Result<SysPay>();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            if(sysPay.getPayId() != null){
                n = sysPayService.updateSysPay(sysPay);
                res.setCode("200");
                res.setRes(sysPay);
                res.setMessage("success");
                if(n > 0) {
                    //异步添加日志
                    SysLogsUtil su = SysLogsUtil.getInstance();
                    su.addSysLogs(logService,us,"修改支付配置信息","修改",request);
                }
            }else{
                res.setCode("413");
                res.setRes(sysPay);
                res.setMessage("payId不能为空");
            }

        return res;
    }

    /**
     * 获取当前用户的支付配置信息
     */
    @RequestMapping(value = "getSysPayDetail",method = RequestMethod.POST)
    public Result<SysPay> getSysPayDetailData(SysPayModel sm) throws Exception{

        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        Result<SysPay> res = new Result<SysPay>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            if(us.getUserId() != null){
                map.put("userId",us.getUserId());
                SysPay sy = sysPayService.getSysPayDetail(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(sy);
            }

        return res;
    }
}
