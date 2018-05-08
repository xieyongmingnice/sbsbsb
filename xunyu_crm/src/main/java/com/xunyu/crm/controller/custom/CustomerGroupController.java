package com.xunyu.crm.controller.custom;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.crm.pojo.customer.CustomerGroup;
import com.xunyu.crm.service.customer.CustomerService;
import com.xunyu.crm.utils.syslog.LogService2;
import com.xunyu.crm.utils.syslog.SysLogsUtil;
import com.xunyu.model.crm.customer.CustomerGroupModel;
import com.xunyu.model.user.User;
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
 * @date 2018/4/24 14:36
 **/
@RestController
@RequestMapping("/customer/group/")
public class CustomerGroupController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CustomerService customerService;
    @Resource
    private LogService2 logService2;

    /**
     * 添加客户分组
     */
    @RequestMapping(value = "addCustomerGroup",method = RequestMethod.POST)
    public Result<CustomerGroup> addCustomerGroupData(HttpServletRequest request, CustomerGroup cg) throws Exception{

        //验证session是否失效
        Result<CustomerGroup> res = new Result<CustomerGroup>();
        User us = redisUtil.getCurrUser(cg.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        cg.setCreateTime(new Date());
        cg.setIsabled(1);//默认有效
        flag = customerService.addCustomerGroup(cg);
        res.setCode("200");
        res.setMessage("success");
        res.setRes(cg);
        if(flag > 0){
            SysLogsUtil su = SysLogsUtil.getInstance();
            su.addSysLogs(logService2,us,"添加客户分组","添加"
                    ,request,"成功添加客户分组",customerService,1);
        }

        return res;
    }

    /**
     * 修改客户分组
     */
    @RequestMapping(value = "updateCustomerGroup",method = RequestMethod.POST)
    public Result<CustomerGroup> updateCustomerGroupData(HttpServletRequest request,CustomerGroup cg) throws Exception{

        Result<CustomerGroup> res = new Result<CustomerGroup>();
        User us = redisUtil.getCurrUser(cg.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        if(cg.getCustomerGroupId() != null){
            flag = customerService.updateCustomerGroup(cg);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(cg);
            if(flag > 0){
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService2,us,"修改客户分组","修改"
                        ,request,"成功修改客户分组",customerService,1);
            }
        }else{
            res.setCode("413");
            res.setMessage("CustomerGroupId 不能为空");
            res.setRes(cg);
        }
        return res;
    }

    /**
     * 获取分组详情
     */
    @RequestMapping(value = "getCustomerGroupDetail",method = RequestMethod.POST)
    public Result<CustomerGroup> getCustomerGroupDetailData(CustomerGroupModel cm) throws Exception{

        Result<CustomerGroup> res = new Result<CustomerGroup>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(cm.getCustomerGroupId() != null) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("customerGroupId", cm.getCustomerGroupId());
            CustomerGroup cg = customerService.getCustomerGroup(map);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(cg);
        }

        return res;
    }

    /**
     * 获取分组列表
     */
    @RequestMapping(value = "customerGroupList",method = RequestMethod.POST)
    public Result<List<CustomerGroup>> customerGroupListData(CustomerGroupModel cm) throws Exception{

        Result<List<CustomerGroup>> res = new Result<List<CustomerGroup>>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        List<CustomerGroup> list = null;
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }

            if(cm.getCurrPage() != 0){
                int total = 0;
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("startRow", cm.getStartRows());
                map.put("endRow", cm.getEndRows());
                map.put("customerName",cm.getCustomerName());
                map.put("remark",cm.getRemark());
                total = customerService.customerGroupCount(map);
                if(total > 0){
                    list = customerService.customerGroupList(map);
                }
                res.setCode("200");
                if(list != null && list.size() > 0) {
                    res.setMessage("success");
                }else {
                    res.setMessage("notvalue");
                }
                res.setRes(list);
                res.setTotalRows(total);
            }else{
                res.setCode("413");
                res.setMessage("currPage不能为空或0");
            }
       return res;
    }

    /**
     * 删除分组
     */
    @RequestMapping(value = "delCustomerGroup",method = RequestMethod.POST)
    public Result<CustomerGroup> updateCustomerGroupData(HttpServletRequest request,CustomerGroupModel cm) throws Exception{

        Result<CustomerGroup> res = new Result<CustomerGroup>();
        User us = redisUtil.getCurrUser(cm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 0;
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(cm.getCustomerGroupIds())){
            flag = customerService.updateCustomerGroupAll(cm.getCustomerGroupIds());
            res.setCode("200");
            res.setMessage("success");
            if(flag > 0){
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService2,us,"删除客户分组","删除"
                        ,request,"成功删除客户分组",customerService,1);
            }
        }
        return res;
    }

}
