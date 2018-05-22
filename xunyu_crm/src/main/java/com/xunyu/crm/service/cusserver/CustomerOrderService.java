package com.xunyu.crm.service.cusserver;

import com.xunyu.crm.pojo.cusserver.CustomerOrder;

/**
 * @author dth
 * @date 2018/5/22 9:06
 * 客户订购服务业务层
 **/
public interface CustomerOrderService {

    /**
     * 添加订购服务
     */
    int saveCustomerOrder(CustomerOrder c);

    /**
     * 修改订购服务
     */
    int updateCustomerOrder(CustomerOrder c);

    /**
     * 删除订购服务
     */
    int delCustomerOrder(String ids);
}
