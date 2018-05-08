package com.xunyu.system.controller.sysarea;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.config.utils.AreaUtils;
import com.xunyu.model.system.sysarea.AreaModel;
import com.xunyu.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/8 10:12
 * 获取地区控制层
 **/
@RestController
@RequestMapping("/area")
public class AreaController {
    private Logger log = LoggerFactory.getLogger(SysAreaController.class);
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 获取中国所有的省
     */
    @RequestMapping(value = "areaProvincesList",method = RequestMethod.POST)
    public Result<List<String>> areaProvincesListData(HttpServletRequest request, AreaModel am) {
        Result<List<String>> res = new Result<List<String>>();
        User us = redisUtil.getCurrUser(am.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        AreaUtils lu =  AreaUtils.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(StringUtils2.isNotEmpty(am.getCountry())) {
                List<String> list = lu.getProvinces(am.getCountry());
                res.setCode("200");
                res.setMessage("success");
                res.setTotalRows(list.size());
                res.setRes(list);
            }else{
                res.setCode("413");
                res.setMessage("country不能为空");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.error(e.getMessage());
        }
        return res;
    }

    /**
     * 获取省下面所有的市
     */
    @RequestMapping(value = "areaCityList",method = RequestMethod.POST)
    public Result<List<String>> areaCityListData(HttpServletRequest request, AreaModel am) {
        Result<List<String>> res = new Result<List<String>>();
        User us = redisUtil.getCurrUser(am.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        AreaUtils lu = AreaUtils.getInstance();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(StringUtils2.isNotEmpty(am.getProvinces()) && StringUtils2.isNotEmpty(am.getCountry())){
                List<String> list = lu.getCities(am.getCountry(),am.getProvinces());
                res.setCode("200");
                res.setMessage("success");
                res.setTotalRows(list.size());
                res.setRes(list);
            }else{
                res.setCode("413");
                res.setMessage("country和provinces不能为空");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            log.error(e.getMessage());
        }
        return res;
    }

}
