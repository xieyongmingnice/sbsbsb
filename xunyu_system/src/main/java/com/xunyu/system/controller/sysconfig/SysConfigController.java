package com.xunyu.system.controller.sysconfig;

import com.commons.core.message.Result;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.sysconfig.SysConfigModel;
import com.xunyu.model.user.User;
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
    public Result<SystemConfig> addSysConfigData(SystemConfig sc) throws Exception{

        Result<SystemConfig> res = new Result<SystemConfig>();
        User us = redisUtil.getCurrUser(sc.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        int flag = 0;
        if(us == null){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            sc.setIsabled(1);
            sc.setCreateTime(new Date());
            sc.setUserId(us.getUserId());
            flag = sysConfigService.addSysConfig(sc);

            if(flag > 0){
                res.setCode("200");
                res.setMessage("success");
                res.setRes(sc);
            }

        return res;
    }

    /**
     * 修改全局配置信息
     */
    @RequestMapping(value = "updateSysConfig",method = RequestMethod.POST)
    public Result<SystemConfig> updateSysConfigData(SystemConfig sc) throws Exception{

        Result<SystemConfig> res = new Result<SystemConfig>();
        boolean status = redisUtil.sessionStatus(sc.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
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

        return res;
    }

    /**
     * 查询全局配置信息实例
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


}
