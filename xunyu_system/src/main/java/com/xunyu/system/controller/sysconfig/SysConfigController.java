package com.xunyu.system.controller.sysconfig;

import com.commons.core.message.Result;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.sysconfig.SysConfigModel;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.sysconfig.SystemConfig;
import com.xunyu.system.service.sysconfig.SysConfigService;
import com.xunyu.system.utils.syslog.CrmService;
import com.xunyu.system.utils.syslog.LogService2;
import com.xunyu.system.utils.syslog.SysLogsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2018/4/26 17:28
 **/
@RestController
@RequestMapping("/config")
public class SysConfigController {

    private Logger log = LoggerFactory.getLogger(SysConfigController.class);
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private LogService2 logService;
    @Resource
    private CrmService crmService;
    /**
     * 添加全局配置信息
     * @param //response
     * @param sc
     * @return
     */
    @RequestMapping(value = "addSysConfig",method = RequestMethod.POST)
    public Result<SystemConfig> addSysConfigData(SystemConfig sc,HttpServletRequest request){

        Result<SystemConfig> res = new Result<SystemConfig>();
        User us = redisUtil.getCurrUser(sc.getSessionId());
        int n = 0;
        SysLogsUtil su = SysLogsUtil.getInstance();
        if(us == null){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try {
            sc.setIsabled(1);
            sc.setCreateTime(new Date());
            sc.setUserId(us.getUserId());
            n = sysConfigService.addSysConfig(sc);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(sc);
            if (n > 0) {
                //异步添加日志
                su.addSysLogs(logService, us, sc.getSysIp()
                        , "添加", request, "成功添加全局配置信息", crmService, 1);
            }
        }catch (Exception e){
            log.info(e.getMessage());
            su.addSysLogs(logService, us, sc.getSysIp()
                    , "添加", request, e.getMessage(), crmService, 2);
        }
        return res;
    }

    /**
     * 修改全局配置信息
     */
    @RequestMapping(value = "updateSysConfig",method = RequestMethod.POST)
    public Result<SystemConfig> updateSysConfigData(SystemConfig sc,HttpServletRequest request){

        Result<SystemConfig> res = new Result<SystemConfig>();
        User us = redisUtil.getCurrUser(sc.getSessionId());
        SysLogsUtil su = SysLogsUtil.getInstance();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            if(sc.getSysId() != null){
                try {
                    n = sysConfigService.updateSysConfig(sc);
                    res.setCode("200");
                    res.setMessage("success");
                    res.setRes(sc);
                    if (n > 0) {
                        //异步添加日志
                        su.addSysLogs(logService, us, "修改全局配置信息"
                                , "修改", request, "成功修改全局配置信息", crmService, 1);
                    }
                }catch (Exception e){
                    log.info(e.getMessage());
                    su.addSysLogs(logService, us, "修改全局配置信息"
                            , "修改", request, e.getMessage(), crmService, 2);
                }
            }else{
                res.setCode("413");
                res.setMessage("SysId不能为空");
                res.setRes(sc);
            }

        return res;
    }

    /**
     * 查询全局配置信息实例
     * org.springframework.cloud.sleuth.zipkin.RestTemplateSender
     */
    @RequestMapping(value = "getSysConfigDetail",method = RequestMethod.POST)
    public Result<SystemConfig> getSysConfigDetail(SysConfigModel sm) throws Exception{

        Result<SystemConfig> res = new Result<SystemConfig>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            map.put("userId",us.getUserId());
            SystemConfig sys = sysConfigService.getSysConfigDetail(map);
            res.setRes(sys);
            res.setMessage("success");
            res.setCode("200");

        return res;
    }

    /**
     * 删除全局配置信息
     */
    @RequestMapping(value = "delSysConfig",method = RequestMethod.POST)
    public Result<SystemConfig> delSysConfigData(SysConfigModel sm,HttpServletRequest request){

        Result<SystemConfig> res = new Result<SystemConfig>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        SysLogsUtil su = SysLogsUtil.getInstance();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(sm.getSysId() != null || sm.getUserId() != null){
                map.put("sysId",sm.getSysId());
                map.put("userId",us.getUserId());
                n = sysConfigService.delSysConfig(map);
                if(n > 0) {
                    res.setCode("200");
                    res.setMessage("success");
                    //异步添加日志
                    su.addSysLogs(logService, us, "删除全局配置信息 ID=" + sm.getSysId()
                            , "删除", request, "成功删除本用户的全局配置信息", crmService, 1);
                }else{
                    res.setCode("204");
                    res.setMessage("当前登录用户没有配置该系统信息,不需要删除");
                }
            }else{
                res.setCode("413");
                res.setMessage("sysId或者userId不能为空");
            }
        }catch (Exception e){
            log.info(e.getMessage());
            su.addSysLogs(logService, us, "删除本用户的全局配置信息"
                    , "删除", request, e.getMessage(), crmService, 2);
        }
        return res;
    }
}
