package com.xunyu.crm.controller.custom;

import com.commons.core.message.Result;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.crm.pojo.customer.CustomerTab;
import com.xunyu.crm.service.customer.CustomerService;
import com.xunyu.model.crm.customer.CustomerModel;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CustomerService customerService;

    /**
     * 添加客户信息
     */
    @RequestMapping(value = "addCustomer",method = RequestMethod.POST)
    public Result<CustomerTab> addCustomerData(HttpServletResponse response,CustomerTab ct){

        //验证session是否失效
        Result<CustomerTab> res = new Result<CustomerTab>();
        boolean status = redisUtil.sessionStatus(ct.getSessionId());
        if(!status){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        int flag = 0;
        try{
            ct.setCreateTime(new Date());
            ct.setIsabled(1);//默认有效
            flag = customerService.addCustomer(ct);
            if(flag > 0){
                res.setCode("200");
                res.setMessage("success");
                res.setRes(ct);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 修改客户信息
     */
    @RequestMapping(value = "updateCustomer",method = RequestMethod.POST)
    public Result<CustomerTab> updateCustomerData(HttpServletResponse response,CustomerTab ct){

        Result<CustomerTab> res = new Result<CustomerTab>();
        boolean status = redisUtil.sessionStatus(ct.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            int flag = 0;
            if(ct.getCustomerId() != null){
                flag = customerService.updateCustomer(ct);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(ct);
            }else{
                res.setCode("413");
                res.setMessage("CustomerId 不能为空");
                res.setRes(ct);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 获取客户详情
     */
    @RequestMapping(value = "getCustomerDetail",method = RequestMethod.POST)
    public Result<CustomerTab> getCustomerGroupDetailData(HttpServletResponse response, CustomerModel cm){

        Result<CustomerTab> res = new Result<CustomerTab>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(cm.getCustomerId() != null){
            try{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("customerId",cm.getCustomerId());
                CustomerTab cg = customerService.getCustomerTabDetail(map);
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
            res.setMessage("CustomerId 不能为空");
        }
        return res;
    }

    /**
     * 获取客户信息列表
     */
    @RequestMapping(value = "customerList",method = RequestMethod.POST)
    public Result<List<CustomerTab>> customerListData(HttpServletResponse response, CustomerModel cm){

        Result<List<CustomerTab>> res = new Result<List<CustomerTab>>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if(!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
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
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
       return res;
    }

    /**
     * 删除客户信息
     */
    @RequestMapping(value = "delCustomer",method = RequestMethod.POST)
    public Result<CustomerTab> delCustomerData(HttpServletResponse response, CustomerModel cm) {

        Result<CustomerTab> res = new Result<CustomerTab>();
        boolean status = redisUtil.sessionStatus(cm.getSessionId());
        if (!status) {
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        try{
            if(StringUtils2.isNotEmpty(cm.getCustomerIds())){
                customerService.updateCustomerAll(cm.getCustomerIds());
                res.setCode("200");
                res.setMessage("success");
            }else{
                res.setCode("413");
                res.setMessage("CustomerIds 不能为空");
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }


}
