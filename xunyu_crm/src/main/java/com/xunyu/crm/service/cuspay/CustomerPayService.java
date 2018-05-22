package com.xunyu.crm.service.cuspay;

import com.xunyu.crm.pojo.cuspay.CustomerPay;

/**
 * @author dth
 * @date 2018/5/22 9:21
 * 客户付费记录
 **/
public interface CustomerPayService {

    /**
     * 添加付费记录
     */
    int saveCustomerPay(CustomerPay c);

    /**
     * 修改付费记录
     */
    int updateCustomerPay(CustomerPay c);

    /**
     * 删除付费记录
     */
    int delCustomerPay(String ids);
}
