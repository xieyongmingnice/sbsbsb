package com.xunyu.system.controller.errcode;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.errcode.ErrorCodeModel;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.errcode.ErrorCode;
import com.xunyu.system.service.errcode.ErrorCodeService;
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
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/2 16:27
 * 错误码配置
 **/
@RestController
@RequestMapping("code/")
public class ErrCodeController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ErrorCodeService errorCodeService;
    @Resource
    private LogService2 logService;

    /**
     * 添加错误码配置
     */
    @RequestMapping(value = "addErrCode",method = RequestMethod.POST)
    public Result<ErrorCode> addErrCodeData(ErrorCode ec, HttpServletRequest request) throws Exception{
        Result<ErrorCode> res = new Result<ErrorCode>();
        User us = redisUtil.getCurrUser(ec.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            ec.setIsabled(1);
            ec.setCreateTime(new Date());
            n = errorCodeService.addErrCodeConfig(ec);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(ec);
        if(n > 0) {
            //异步添加日志
            SysLogsUtil su = SysLogsUtil.getInstance();
            su.addSysLogs(logService,us,"添加错误码配置","添加",request);

        }
        return res;
    }

    /**
     * 修改错误码配置
     */
    @RequestMapping(value = "updateErrCode",method = RequestMethod.POST)
    public Result<ErrorCode> updateErrCodeData(ErrorCode ec,HttpServletRequest request) throws Exception{
        Result<ErrorCode> res = new Result<ErrorCode>();
        User us = redisUtil.getCurrUser(ec.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int n = 0;
            if(ec.getErrId() != null){
                n = errorCodeService.updateErrCodeConfig(ec);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(ec);
                if(n > 0) {
                    //异步添加日志
                    SysLogsUtil su = SysLogsUtil.getInstance();
                    su.addSysLogs(logService,us,"修改错误码配置","修改",request);

                }
            }else{
                res.setCode("413");
                res.setMessage("errId不能为空");
                res.setRes(ec);
            }

        return res;
    }

    /**
     * 获取错误码配置详情
     */
    @RequestMapping(value = "getErrCodeDetail",method = RequestMethod.POST)
    public Result<ErrorCode> getErrCodeDetailData(ErrorCodeModel ec) throws Exception{
        Result<ErrorCode> res = new Result<ErrorCode>();
        User us = redisUtil.getCurrUser(ec.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }

            ErrorCode errc = null;
            if(ec.getErrId() != null){
                map.put("errId",ec.getErrId());
                errc = errorCodeService.getErrCodeConfigDetail(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(errc);
            }else{
                res.setCode("413");
                res.setMessage("errId不能为空");
                res.setRes(errc);
            }
        return res;
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "errCodeConfigList",method = RequestMethod.POST)
    public Result<List<ErrorCode>> errCodeConfigListData(ErrorCodeModel ec) throws Exception{
        Result<List<ErrorCode>> res = new Result<List<ErrorCode>>();
        User us = redisUtil.getCurrUser(ec.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            int total = 0;
            map.put("agreeType",ec.getAgreeType());
            map.put("errType",ec.getErrType());
            map.put("errCode",ec.getErrCode());
            map.put("errText",ec.getErrText());
            map.put("startRow",ec.getStartRows());
            map.put("endRow",ec.getEndRows());
            total = errorCodeService.errCodeConfigCount(map);
            if(total > 0){
                List<ErrorCode> list = errorCodeService.errCodeConfigList(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(list);
                res.setTotalRows(total);
            }else{
                res.setMessage("notvalue");
                res.setCode("412");
            }

        return res;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delErrCodeConfig",method = RequestMethod.POST)
    public Result<ErrorCodeModel> delErrCodeConfigData(ErrorCodeModel ec,HttpServletRequest request) throws Exception{
        Result<ErrorCodeModel> res = new Result<ErrorCodeModel>();
        User us = redisUtil.getCurrUser(ec.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            int n = 0;
            if(StringUtils2.isNotEmpty(ec.getErrIds())) {
                n = errorCodeService.delErrCodeConfig(ec.getErrIds());
                res.setCode("200");
                res.setMessage("success");
                if(n > 0) {
                    //异步添加日志
                    SysLogsUtil su = SysLogsUtil.getInstance();
                    su.addSysLogs(logService,us,"删除错误码配置","删除",request);

                }
            }else {
                res.setCode("413");
                res.setMessage("errIds不能为空");
                res.setRes(ec);
            }

        return res;
    }
}
