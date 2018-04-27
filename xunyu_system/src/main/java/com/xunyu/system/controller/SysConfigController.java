package com.xunyu.system.controller;

import com.commons.core.message.Result;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.sysconfig.SysConfigModel;
import com.xunyu.system.pojo.sysconfig.SystemConfig;
import com.xunyu.system.service.sysconfig.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 添加全局配置信息
     * @param response
     * @param sc
     * @return
     */
    @RequestMapping(value = "addSysConfig",method = RequestMethod.POST)
    public Result<SystemConfig> addSysConfigData(HttpServletResponse response,SystemConfig sc){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<SystemConfig> res = new Result<SystemConfig>();
        boolean status = redisUtil.sessionStatus(sc.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        int flag = 0;
        if(!status){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            sc.setIsabled(1);
            sc.setCreateTime(new Date());
            flag = sysConfigService.addSysConfig(sc);

            if(flag > 0){
                res.setCode("200");
                res.setMessage("success");
                res.setRes(sc);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 修改全局配置信息
     */
    @RequestMapping(value = "updateSysConfig",method = RequestMethod.POST)
    public Result<SystemConfig> updateSysConfigData(HttpServletResponse response,SystemConfig sc) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<SystemConfig> res = new Result<SystemConfig>();
        boolean status = redisUtil.sessionStatus(sc.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(sc.getSysId() != null){
                flag = sysConfigService.updateSysConfig(sc);
                if(flag > 0){
                    res.setCode("200");
                    res.setMessage("success");
                    res.setRes(sc);
                }
            }else{
                res.setCode("413");
                res.setMessage("SysId不能为空");
                res.setRes(sc);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 查询全局配置信息实例
     */
    @RequestMapping(value = "getSysConfigDetail",method = RequestMethod.POST)
    public Result<SystemConfig> getSysConfigDetail(HttpServletResponse response, SysConfigModel sm) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<SystemConfig> res = new Result<SystemConfig>();
        boolean status = redisUtil.sessionStatus(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            SystemConfig sys = sysConfigService.getSysConfigDetail(map);
            res.setRes(sys);
            res.setMessage("success");
            res.setCode("200");
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }


}
