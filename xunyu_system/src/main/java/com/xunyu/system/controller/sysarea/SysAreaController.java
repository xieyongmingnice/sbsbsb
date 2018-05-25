package com.xunyu.system.controller.sysarea;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.system.sysarea.SysAreaModel;
import com.xunyu.model.user.User;
import com.xunyu.system.pojo.sysarea.SysArea;
import com.xunyu.system.service.sysarea.SysAreaService;
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
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/8 9:27
 **/
@RestController
@RequestMapping(value = "/sysArea")
public class SysAreaController {

    private Logger log = LoggerFactory.getLogger(SysAreaController.class);
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SysAreaService sysAreaService;
    @Resource
    private LogService2 logService;
    @Resource
    private CrmService crmService;

    /**
     * 添加区域配置
     */
    @RequestMapping(value = "addSysAreaConfig",method = RequestMethod.POST)
    public Result<SysArea> addSysAreaConfigData(HttpServletRequest request,SysArea sa){
        Result<SysArea> res = new Result<SysArea>();
        User us = redisUtil.getCurrUser(sa.getSessionId());
        StringBuilder cen = new StringBuilder();
        cen.append(sa.getAreaName()).append("-").append(sa.getAreaId());
        int flag = 0;
        //异步添加日志
        SysLogsUtil su = SysLogsUtil.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            sa.setIsabled(1);
            sa.setCreateTime(new Date());
            flag = sysAreaService.addSysAreaConfig(sa);
            res.setCode("200");
            res.setMessage("success");
            if(flag > 0){
                su.addSysLogs(logService,us,"添加地理区域配置《"+cen.toString()+"》"
                        ,"添加",request,"成功添加地理区域配置信息"
                        ,crmService,1);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.info(e.getMessage());
            su.addSysLogs(logService,us,"添加地理区域配置《"+cen.toString()+"》"
                    ,"添加",request,"添加地理区域配置信息失败，报系统异常"
                    ,crmService,2);
        }
        return res;
    }

    /**
     * 修改地理区域配置
     */
    @RequestMapping(value = "updateSysAreaConfig",method = RequestMethod.POST)
    public Result<SysArea> updateSysAreaConfigData(HttpServletRequest request,SysArea sa) {
        Result<SysArea> res = new Result<SysArea>();
        User us = redisUtil.getCurrUser(sa.getSessionId());
        StringBuilder cen = new StringBuilder();
        cen.append(sa.getAreaName()).append("-").append(sa.getAreaId());
        int flag = 0;
        //异步添加日志
        SysLogsUtil su = SysLogsUtil.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(sa.getAreaId() != null){
                flag = sysAreaService.updateSysAreaConfig(sa);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(sa);
                if(flag > 0){
                    su.addSysLogs(logService,us,"修改地理区域配置《"+cen.toString()+"》"
                            ,"修改",request,"成功修改地理区域配置信息"
                            ,crmService,1);
                }
            }else{
                res.setCode("413");
                res.setMessage("areaId不能为空");
                res.setRes(sa);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.info(e.getMessage());
            su.addSysLogs(logService,us,"修改地理区域配置《"+cen.toString()+"》"
                    ,"修改",request,"修改地理区域配置信息失败，报系统异常"
                    ,crmService,2);
        }

        return res;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delSysAreaConfig",method = RequestMethod.POST)
    public Result<SysArea> updateSysAreaConfigData(HttpServletRequest request, SysAreaModel sm) {
        Result<SysArea> res = new Result<SysArea>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        //异步添加日志
        SysLogsUtil su = SysLogsUtil.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(StringUtils2.isNotEmpty(sm.getAreaIds())){
                flag = sysAreaService.delSysAreaConfig(sm.getAreaIds());
                res.setCode("200");
                res.setMessage("success");
                if(flag > 0){
                    su.addSysLogs(logService,us,"删除地理区域配置 ID="+sm.getAreaIds()
                            ,"删除",request,"成功删除地理区域配置信息"
                            ,crmService,1);
                }
            }else{
                res.setCode("413");
                res.setMessage("areaIds不能为空");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.info(e.getMessage());
            su.addSysLogs(logService,us,"删除地理区域配置《"+sm.getAreaIds()+"》"
                    ,"删除",request,"删除地理区域配置信息失败，报系统异常"
                    ,crmService,2);
        }
        return res;
    }

    /**
     * 获取地理区域配置详情
     */
    @RequestMapping(value = "getSysAreaConfigDetail",method = RequestMethod.POST)
    public Result<SysArea> getSysAreaConfigDetailData(HttpServletRequest request, SysAreaModel sm) {
        Result<SysArea> res = new Result<SysArea>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(sm.getAreaId() != null){
                map.put("areaId",sm.getAreaId());
                SysArea sa = sysAreaService.getSysAreaConfig(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(sa);
            }else{
                res.setCode("413");
                res.setMessage("areaId不能为空");
            }

        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.info(e.getMessage());
        }
        return res;
    }

    /**
     * 获取地理区域配置列表
     */
    @RequestMapping(value = "sysAreaConfigList",method = RequestMethod.POST)
    public Result<List<SysArea>> sysAreaConfigListData(HttpServletRequest request, SysAreaModel sm) {
        Result<List<SysArea>> res = new Result<List<SysArea>>();
        User us = redisUtil.getCurrUser(sm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int total = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            map.put("areaCode",sm.getAreaCode());
            map.put("areaName",sm.getAreaName());
            map.put("startRow",sm.getStartRows());
            map.put("endRow",sm.getEndRows());
            total = sysAreaService.sysAreaConfigCount(map);
            if(total > 0){
                List<SysArea> list = sysAreaService.sysAreaConfigList(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(list);
                res.setTotalRows(total);
            }else{
                res.setCode("412");
                res.setMessage("notvalue");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.info(e.getMessage());
        }
        return res;
    }
}
