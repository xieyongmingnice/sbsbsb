package com.xunyu.crm.service.cusinvo;

import com.xunyu.crm.pojo.cusinvo.CoustomerInvoiceinfo;

/**
 * @author dth
 * @date 2018/5/22 9:30
 * 客户发票信息抬头
 **/
public interface CustomerInvoiceService {

    /**
     * 添加客户信息发票抬头
     */
    int saveCustomerInvoice(CoustomerInvoiceinfo c);

    /**
     * 修改客户信息发票抬头
     */
    int updateCustomerInvoice(CoustomerInvoiceinfo c);

    /**
     * 删除客户信息发票抬头
     */
    int delCustomerInvoice(String ids);

}
