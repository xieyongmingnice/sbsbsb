package com.xunyu.crm.controller.custom;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.crm.dao.customer.user.UserDaoImpl;
import com.xunyu.crm.pojo.customer.CustomerTab;
import com.xunyu.crm.service.customer.CustomerService;
import com.xunyu.crm.utils.syslog.LogService2;
import com.xunyu.crm.utils.syslog.SysLogsUtil;
import com.xunyu.model.crm.customer.CustomerModel;
import com.xunyu.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserDaoImpl userDaoImpl;
    @Resource
    private LogService2 logService2;

    /**
     * 添加客户信息
     */
    @RequestMapping(value = "addCustomer",method = RequestMethod.POST)
    public Result<CustomerTab> addCustomerData(HttpServletRequest request, CustomerTab ct) throws Exception{

        //验证session是否失效
        Result<CustomerTab> res = new Result<CustomerTab>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        ct.setCreateTime(new Date());
        ct.setIsabled(1);//默认有效
        map.put("account",ct.getCustomerAccount());
        User us2 = userDaoImpl.getUserByAccount(map);
        if(us2 == null) {
            flag = customerService.addCustomer(ct);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(ct);
            if(flag > 0){
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService2,us,"添加客户信息","添加"
                ,request,"成功添加客户信息",customerService,1);
            }
        }else{
            res.setCode("412");
            res.setMessage("该账号已存在");
        }

        return res;
    }

    /**
     * 修改客户信息
     */
    @RequestMapping(value = "updateCustomer",method = RequestMethod.POST)
    public Result<CustomerTab> updateCustomerData(HttpServletRequest request,CustomerTab ct) throws Exception{

        Result<CustomerTab> res = new Result<CustomerTab>();
        User us = redisUtil.getCurrUser(ct.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        if(ct.getCustomerId() != null){
            flag = customerService.updateCustomer(ct);
            res.setCode("200");
            res.setMessage("success");
            res.setRes(ct);
            if(flag > 0){
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService2,us,"修改客户信息","修改"
                        ,request,"成功修改客户信息",customerService,1);
            }
        }else{
            res.setCode("413");
            res.setMessage("CustomerId 不能为空");
            res.setRes(ct);
        }

        return res;
    }

    /**
     * 获取客户详情
     */
    @RequestMapping(value = "getCustomerDetail",method = RequestMethod.POST)
    public Result<CustomerTab> getCustomerGroupDetailData(CustomerModel cm) throws Exception{

        Result<CustomerTab> res = new Result<CustomerTab>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(cm.getCustomerId() != null){

                Map<String,Object> map = new HashMap<String,Object>();
                map.put("customerId",cm.getCustomerId());
                CustomerTab cg = customerService.getCustomerTabDetail(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(cg);

        }else{
            res.setCode("413");
            res.setMessage("CustomerId 不能为空");
        }
        return res;
    }

    /**
     * 获取客户信息列表
     */
    @RequestMapping(value = "customerList",method = RequestMethod.POST)
    public Result<List<CustomerTab>> customerListData(CustomerModel cm) throws Exception{

        Result<List<CustomerTab>> res = new Result<List<CustomerTab>>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            List<CustomerTab> list = null;
            if(cm.getCurrPage() != 0){
                int total = 0;
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("startRow", cm.getStartRows());
                map.put("endRow", cm.getEndRows());
                map.put("customerName",cm.getCustomerName());
                map.put("customerAccount",cm.getCustomerAccount());
                map.put("enterContact",cm.getEnterContact());//联系人
                map.put("business",cm.getBusiness());
                total = customerService.customerTabCount(map);
                if(total > 0){
                    list = customerService.customerTabList(map);

                }res.setCode("200");
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
     * 删除客户信息
     */
    @RequestMapping(value = "delCustomer",method = RequestMethod.POST)
    public Result<CustomerTab> delCustomerData(HttpServletRequest request,CustomerModel cm) throws Exception{

        Result<CustomerTab> res = new Result<CustomerTab>();
        User us = redisUtil.getCurrUser(cm.getSessionId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (us == null) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        if(StringUtils2.isNotEmpty(cm.getCustomerIds())){
            flag = customerService.updateCustomerAll(cm.getCustomerIds());
            res.setCode("200");
            res.setMessage("success");
            if(flag > 0){
                SysLogsUtil su = SysLogsUtil.getInstance();
                su.addSysLogs(logService2,us,"删除客户信息","删除"
                        ,request,"成功删除客户信息",customerService,1);
            }
        }else{
            res.setCode("413");
            res.setMessage("CustomerIds 不能为空");
        }

        return res;
    }

    /**
     * 获取客户详情
     */
    @RequestMapping(value = "getCusDetailFeign",method = RequestMethod.POST)
    public CustomerModel getCusDetailFeignData(@RequestParam(value = "customerAccount",required = false)
                       String customerAccount) throws Exception{

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("customerAccount",customerAccount);
        CustomerModel cg = customerService.getCusDetailFeign(map);
        return cg;
    }
}
