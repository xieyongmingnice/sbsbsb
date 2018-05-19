package com.xunyu.system.controller.syspay;

import com.commons.core.exception.ExceptionCatch;
import com.commons.core.message.Result;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.syspay.SysPay;
import com.xunyu.system.pojo.syspay.SysPayState;
import com.xunyu.system.service.syspay.SysPayService;
import com.xunyu.system.service.syspay.SysPayStateService;
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

@RestController
@RequestMapping(value = "/paystate/")
public class SysPayStateController {

   private Logger log = LoggerFactory.getLogger(SysPayStateController.class);
    /**
     * 注入
     */
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysPayStateService sysPayStateService;
    @Resource
    private LogService2 logService;
    @Resource
    private CrmService crmService;

    /**
     * 添加支付配置状态
     */
    @RequestMapping(value = "addSysPayState",method = RequestMethod.POST)
    public Result<SysPayState> addSysPayData(SysPayState s,HttpServletRequest request){

        User us = redisUtil.getCurrUser(s.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        Result<SysPayState> res = new Result<SysPayState>();
        int n = 0;
        if(us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }try {
            s.setUserId(us.getUserId());
            n = sysPayStateService.addSysPayState(s);
            res.setCode("200");
            res.setRes(s);
            res.setMessage("success");
            if (n > 0) {
                //异步添加日志
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService, us, "添加支付配置状态"
                        , "添加", request, "成功添加支付配置状态", crmService, 1);
            }
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
            //异步添加日志
            SysLogsUtil su = SysLogsUtil.getInstance();
            su.addSysLogs(logService, us, "添加支付配置状态"
                    , "添加", request, "添加支付配置状态失败", crmService, 2);
        }

        return res;
    }

    /**
     * 修改支付配置状态
     */
    @RequestMapping(value = "updateSysPayState",method = RequestMethod.POST)
    public Result<SysPayState> updateSysPayData(SysPayState s,HttpServletRequest request){

        User us = redisUtil.getCurrUser(s.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        Result<SysPayState> res = new Result<SysPayState>();
        int n = 0;
        if(us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }try {
            if(s.getPayState() != null) {
                s.setUserId(us.getUserId());
                n = sysPayStateService.updateSysPayState(s);
                res.setCode("200");
                res.setRes(s);
                res.setMessage("success");
                if (n > 0) {
                    //异步添加日志
                    SysLogsUtil su = SysLogsUtil.getInstance();
                    su.addSysLogs(logService, us, "修改支付配置状态"
                            , "添加", request, "成功修改支付配置状态", crmService, 1);
                }
            }else{
                res.setCode("413");
                res.setMessage("payState不能为空");
            }
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
            //异步添加日志
            SysLogsUtil su = SysLogsUtil.getInstance();
            su.addSysLogs(logService, us, "修改支付配置状态"
                    , "添加", request, "修改支付配置状态失败", crmService, 2);
        }

        return res;
    }

    /**
     * 获取支付配置状态
     */
    /**
     * 添加支付配置状态
     */
    @RequestMapping(value = "getSysPayStateDetail",method = RequestMethod.POST)
    public Result<SysPayState>getSysPayStateDetailData(SysPayState s){

        User us = redisUtil.getCurrUser(s.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        Result<SysPayState> res = new Result<SysPayState>();
        int n = 0;
        if(us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }try {
            map.put("userId",us.getUserId());
            s = sysPayStateService.getSysPayStateDetail(map);
            res.setCode("200");
            res.setRes(s);
            res.setMessage("success");

        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
        }
        return res;
    }


}
