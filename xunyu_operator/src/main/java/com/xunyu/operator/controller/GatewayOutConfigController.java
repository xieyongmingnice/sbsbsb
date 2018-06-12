package com.xunyu.operator.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Maps;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.operator.out.GatewayOutConfigModel;
import com.xunyu.model.user.User;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.out.CarrierAgree;
import com.xunyu.operator.pojo.out.Customer;
import com.xunyu.operator.service.access.OperAccessService;
import com.xunyu.operator.service.out.CarrierAgreeService;
import com.xunyu.operator.service.out.CustomerService;
import com.xunyu.operator.vo.GatewayOutConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xym
 * @description 网关接出配置（SP接入到运营商） 控制器
 * @date 2018/6/12 11:58
 */
@RestController
@RequestMapping("/outConfig")
public class GatewayOutConfigController {

    private Logger logger = LoggerFactory.getLogger(GatewayOutConfigController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private OperAccessService operAccessService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarrierAgreeService carrierAgreeService;

    /**
     * 提供进入页面时需要的信息
     * 1、提供企业用户的选择项
     * 2、网关节点的选择项
     * 3、协议类型的选择项
     *
     * 需要参数：选择的运营商id
     */
    @RequestMapping(value = "/firstComeIn")
    @ResponseBody
    public Result<GatewayOutConfigVO> firstComeIn(GatewayOutConfigModel model){
        User user = redisUtil.getCurrUser(model.getSessionId());
        Result<GatewayOutConfigVO> result = checkLogin(new Result(),user);
        if (result.getMessage() != null){
            return result;
        }
        GatewayOutConfigVO config = new GatewayOutConfigVO();
        Map map = Maps.newHashMap();
        map.put("startRow", 0);
        map.put("endRow", Long.MAX_VALUE);
        List<OperAccessCoreConfig> operAccessCoreConfigList = operAccessService.listOperAccessCoreConfig(map) ;
        if (operAccessCoreConfigList != null && operAccessCoreConfigList.size() > 0){
            config.setOperAccessCoreConfigList(operAccessCoreConfigList);
        }
        List<Customer> customerList = customerService.selectCustomerList();
        if (customerList != null && customerList.size() > 0) {
            config.setCustomerList(customerList);
        }
        List<CarrierAgree> carrierAgreeList = carrierAgreeService.selectCarrierAgree();
        if (carrierAgreeList != null && carrierAgreeList.size() > 0){
            config.setCarrierAgreeList(carrierAgreeList);
        }
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
        result.setRes(config);
        return result;
    }

    private Result checkLogin(Result result,User user){
        if(user == null){
            result.setCode(ResultMessage.Code.NOT_FOUND);
            result.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return result;
    }
}
