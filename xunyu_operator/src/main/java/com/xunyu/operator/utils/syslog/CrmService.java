package com.xunyu.operator.utils.syslog;

import com.xunyu.model.crm.customer.CustomerModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dth
 * @date 2018/5/7 9:45
 **/
@FeignClient(value = "xunyu-crm")
public interface CrmService {

    /**
     * 获取客户详情
     */
    @RequestMapping(value = "/customer/getCusDetailFeign",method = RequestMethod.POST ,consumes={"application/json"})
    CustomerModel getCusDetailFeign(@RequestParam(value = "customerAccount") String customerAccount);
}
