package com.xunyu.crm.service.customer;

import com.xunyu.crm.pojo.customer.CustomerGroup;
import com.xunyu.crm.pojo.customer.CustomerTab;
import com.xunyu.model.crm.customer.CustomerModel;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/24 11:00
 **/
public interface CustomerService {

    /**
     * 添加客户分组信息
     */
    int addCustomerGroup(CustomerGroup cg);
    /**
     * 修改分组信息
     */
    int updateCustomerGroup(CustomerGroup cg);
    int updateCustomerGroupAll(String ids);
    /**
     * 获取客户分组列表
     */
    int customerGroupCount(Map<String,Object> map);
    List<CustomerGroup> customerGroupList(Map<String,Object> map);
    /**
     * 获取分组详情
     */
    CustomerGroup getCustomerGroup(Map<String,Object> map);
    /**
     * 添加客户信息
     */
    int addCustomer(CustomerTab customerTab);

    /**
     * 修改客户信息
     */
    int updateCustomer(CustomerTab customerTab);
    int updateCustomerAll(String customerIds);

    /**
     * 获取客户列表
     */
    int customerTabCount(Map<String,Object> map);
    List<CustomerTab> customerTabList(Map<String,Object> map);

    /**
     * 获取客户详情
     */
    CustomerTab getCustomerTabDetail(Map<String,Object> map);
    CustomerModel getCusDetailFeign(Map<String,Object> map);

}
