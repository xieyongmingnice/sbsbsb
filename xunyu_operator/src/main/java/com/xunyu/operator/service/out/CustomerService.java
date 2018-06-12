package com.xunyu.operator.service.out;

import com.xunyu.operator.pojo.out.Customer;

import java.util.List;
/**
 * @author
 * @description 客户service
 * @date 2018/6/12 17:13
 */
public interface CustomerService {

    List<Customer> selectCustomerList();
}
