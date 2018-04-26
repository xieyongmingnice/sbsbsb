package com.xunyu.crm.controller.custom;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.crm.pojo.customer.CustomerGroup;
import com.xunyu.crm.service.customer.CustomerService;
import com.xunyu.model.customer.CustomerGroupModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/24 14:36
 **/
@RestController
@RequestMapping("/customer/group/")
public class CustomerGroupController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CustomerService customerService;

    /**
     * 添加客户分组
     */
    @RequestMapping(value = "addCustomerGroup",method = RequestMethod.POST)
    public Result<CustomerGroup> addCustomerGroupData(HttpServletResponse response,CustomerGroup cg){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //验证session是否失效
        Result<CustomerGroup> res = new Result<CustomerGroup>();
        boolean status = redisUtil.sessionStatus(cg.getSessionId());
        if(!status){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        try{
            cg.setCreateTime(new Date());
            cg.setIsabled(1);//默认有效
            flag = customerService.addCustomerGroup(cg);
            if(flag > 0){
                res.setCode("200");
                res.setMessage("success");
                res.setRes(cg);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 修改客户分组
     */
    @RequestMapping(value = "updateCustomerGroup",method = RequestMethod.POST)
    public Result<CustomerGroup> updateCustomerGroupData(HttpServletResponse response,CustomerGroup cg){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<CustomerGroup> res = new Result<CustomerGroup>();
        boolean status = redisUtil.sessionStatus(cg.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            int flag = 0;
            if(cg.getCustomerGroupId() != null){
                flag = customerService.updateCustomerGroup(cg);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(cg);
            }else{
                res.setCode("413");
                res.setMessage("CustomerGroupId 不能为空");
                res.setRes(cg);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 获取分组详情
     */
    @RequestMapping(value = "getCustomerGroupDetail",method = RequestMethod.POST)
    public Result<CustomerGroup> getCustomerGroupDetailData(HttpServletResponse response, CustomerGroupModel cm){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<CustomerGroup> res = new Result<CustomerGroup>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(cm.getCustomerGroupId() != null){
            try{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("customerGroupId",cm.getCustomerGroupId());
                CustomerGroup cg = customerService.getCustomerGroup(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(cg);
            }catch (Exception e){
                res.setCode("500");
                res.setMessage("系统异常");
                e.printStackTrace();
            }
        }else{
            res.setCode("413");
            res.setMessage("CustomerGroupId 不能为空");
        }
        return res;
    }

    /**
     * 获取分组列表
     */
    @RequestMapping(value = "customerGroupList",method = RequestMethod.POST)
    public Result<List<CustomerGroup>> customerGroupListData(HttpServletResponse response, CustomerGroupModel cm){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<List<CustomerGroup>> res = new Result<List<CustomerGroup>>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(cm.getCurrPage() != 0){
                int total = 0;
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("startRow", cm.getStartRows());
                map.put("endRow", cm.getEndRows());
                map.put("customerName",cm.getCustomerName());
                map.put("remark",cm.getRemark());
                total = customerService.customerGroupCount(map);
                if(total > 0){
                    List<CustomerGroup> list = customerService.customerGroupList(map);
                    res.setCode("200");
                    res.setMessage("success");
                    res.setRes(list);
                    res.setTotalRows(total);
                }
            }else{
                res.setCode("413");
                res.setMessage("currPage不能为空或0");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
       return res;
    }

    /**
     * 删除分组
     */
    @RequestMapping(value = "delCustomerGroup",method = RequestMethod.POST)
    public Result<CustomerGroup> updateCustomerGroupData(HttpServletResponse response,CustomerGroupModel cm){

        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<CustomerGroup> res = new Result<CustomerGroup>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(StringUtils2.isNotEmpty(cm.getCustomerGroupIds())){
                customerService.updateCustomerGroupAll(cm.getCustomerGroupIds());
                res.setCode("200");
                res.setMessage("success");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

}
