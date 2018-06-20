package com.xunyu.operator.controller;

import com.commons.core.exception.ExceptionCatch;
import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.operator.access.OperAccessModel;
import com.xunyu.model.user.User;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.service.access.OperAccessService;
import com.xunyu.operator.utils.syslog.CrmService;
import com.xunyu.operator.utils.syslog.LogService2;
import com.xunyu.operator.utils.syslog.SysLogsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @date 2018/6/11 14:53
 **/
@RestController
@RequestMapping("access/")
public class OperAccessController {

    private Logger log = LoggerFactory.getLogger(OperAccessController.class);
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private OperAccessService operAccessService;
    @Resource
    private LogService2 logService;
    @Resource
    private CrmService crmService;

    /**
     * 添加接入配置
     */
    @RequestMapping(value = "saveOperAccess",method = RequestMethod.POST)
    public Result<OperAccessCoreConfig> saveOperAccessData(HttpServletRequest request
            ,@RequestBody  OperAccessCoreConfig ct) {
        //验证session是否失效
        Result<OperAccessCoreConfig> res = new Result<OperAccessCoreConfig>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        SysLogsUtil su = SysLogsUtil.getInstance();
        StringBuilder strBuff = new StringBuilder();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        String content = getAgreeType(ct);
        try {
            ct.setIsable(1);//默认有效
            ct.setCreateTime(new Date());
            n = operAccessService.saveOperAccess(ct);
            if(n > 0) {
                res.setCode("200");
                res.setMessage("success");
                strBuff.append("成功添加运营商《 ").append(content);
                su.addSysLogs(logService,us,"运营商接入配置"
                        ,"添加",request,strBuff.toString(),crmService,1);
            }
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
            strBuff.append("添加运营商《 ").append(content);
            su.addSysLogs(logService,us,"运营商接入配置"
                    ,"添加",request,strBuff.toString(),crmService,2);
        }
        return res;
    }

    /**
     * 修改接入配置
     */
    @RequestMapping(value = "updateOperAccess",method = RequestMethod.POST)
    public Result<OperAccessCoreConfig> updateOperAccessData(HttpServletRequest request
            ,@RequestBody OperAccessCoreConfig ct) {
        //验证session是否失效
        Result<OperAccessCoreConfig> res = new Result<OperAccessCoreConfig>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        SysLogsUtil su = SysLogsUtil.getInstance();
        StringBuilder strBuff = new StringBuilder();
        int n = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        String content = getAgreeType(ct);
        try{
            if(ct.getConfigId() != null){
                operAccessService.updateOperAccess(ct);
                res.setCode("200");
                res.setMessage("success");
                strBuff.append("成功修改运营商《 ").append(content);
                su.addSysLogs(logService,us,"运营商接入配置"
                        ,"修改",request,strBuff.toString(),crmService,1);
            }else{
                res.setCode("413");
                res.setMessage("configId 不能为空");
            }
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
            strBuff.append("修改运营商《 ").append(content);
            su.addSysLogs(logService,us,"运营商接入配置"
                    ,"修改",request,strBuff.toString(),crmService,2);
        }
        return res;
    }

    /**
     * 获取详情
     */
    @RequestMapping(value = "getOperAccessDetail",method = RequestMethod.POST)
    public Result<OperAccessCoreConfig> getOperAccessDetail(HttpServletRequest request, OperAccessModel ct) {
        //验证session是否失效
        Result<OperAccessCoreConfig> res = new Result<OperAccessCoreConfig>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        //SysLogsUtil su = SysLogsUtil.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try {
            if (ct.getConfigId() != null) {
                map.put("configId", ct.getConfigId());
                OperAccessCoreConfig oac = operAccessService.getOperAccessCoreConfig(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(oac);
            } else {
                res.setCode("413");
                res.setMessage("configId 不能为空");
            }
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
        }
        return res;
    }

    /**
     * 获取接入配置列表
     */
    @RequestMapping(value = "listOperAccess",method = RequestMethod.POST)
    public Result<List<OperAccessCoreConfig>> listOperAccessData(HttpServletRequest request, OperAccessModel ct) {
        //验证session是否失效
        Result<List<OperAccessCoreConfig>> res = new Result<List<OperAccessCoreConfig>>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        //SysLogsUtil su = SysLogsUtil.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int total = 0;
        try{
            map.put("startRow", ct.getStartRows());
            map.put("endRow", ct.getEndRows());
            map.put("serviceIp",ct.getServiceIp());
            map.put("enterpriseCode",ct.getEnterpriseCode());
            map.put("accessCode",ct.getAccessCode());
            map.put("isable",ct.getIsable());
            map.put("gatewayNumber",ct.getGatewayNumber());
            map.put("agreeType",ct.getAgreeType());
            map.put("channelName",ct.getChannelName());
            total = operAccessService.countOperAccessCoreConfig(map);
            List<OperAccessCoreConfig> list = null;
            if(total > 0){
                list = operAccessService.listOperAccessCoreConfig(map);
            }
            res.setCode("200");
            if(list != null && list.size() > 0) {
                res.setMessage("success");
            }else {
                res.setMessage("notvalue");
            }
            res.setRes(list);
            res.setTotalRows(total);
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
        }
        return res;
    }

    /**
     * 修改状态
     */
    @RequestMapping(value = "delOperAccess",method = RequestMethod.POST)
    public Result<OperAccessCoreConfig> delOperAccessData(HttpServletRequest request, OperAccessModel ct) {
        //验证session是否失效
        Result<OperAccessCoreConfig> res = new Result<OperAccessCoreConfig>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        SysLogsUtil su = SysLogsUtil.getInstance();
        StringBuilder strBuff = new StringBuilder();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(StringUtils2.isNotEmpty(ct.getConfigIds()) && ct.getIsable() != null){
                operAccessService.delOperAccessCoreConfig(ct.getConfigIds(),ct.getIsable());
                res.setCode("200");
                res.setMessage("success");
                String content = getIsableState(ct.getConfigIds(),ct.getIsable());
                strBuff.append("修改运营商接入配置状态， ").append(content);
                su.addSysLogs(logService,us,"运营商接入配置"
                        ,"修改",request,strBuff.toString(),crmService,1);
            }
        }catch (Exception e){
            ExceptionCatch.exceptionCatch(res,log,e);
            String content = getIsableState(ct.getConfigIds(),ct.getIsable());
            strBuff.append("修改运营商接入配置状态， ").append(content);
            su.addSysLogs(logService,us,"运营商接入配置"
                    ,"修改",request,strBuff.toString(),crmService,2);
        }
        return res;
    }

    private String getAgreeType(OperAccessCoreConfig ct){

        StringBuilder sb = new StringBuilder();
        if(ct != null){
            if(ct.getAgreeType() == 1){
                sb.append("移动");
            }else if(ct.getAgreeType() == 2){
                sb.append("联通");
            }else if(ct.getAgreeType() == 3){
                sb.append("电信");
            }
        }else{
            sb.append("类型不明确");
        }
        sb.append(" 》接入配置,《").append(ct.getChannelName()).append("》");
        return sb.toString();
    }

    private String getIsableState(String ids ,int isable){

        StringBuilder strBuff = new StringBuilder();
        if(isable == 3){
            strBuff.append("作废接入配置 IDS=").append(ids);
        }else if(isable == 4){
            strBuff.append("删除接入配置 IDS=").append(ids);
        }else if(isable == 2){
            strBuff.append("恢复或停用接入配置 IDS=").append(ids);
        }else if(isable == 1){
            strBuff.append("启用接入配置 IDS=").append(ids);
        }

        return strBuff.toString();
    }
}
