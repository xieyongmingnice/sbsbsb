package com.xunyu.crm.service.customer;

import com.xunyu.crm.dao.CustomerDaoImpl;
import com.xunyu.crm.dao.CustomerGroupDaoImpl;
import com.xunyu.crm.pojo.customer.CustomerGroup;
import com.xunyu.crm.pojo.customer.CustomerTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/24 11:48
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDaoImpl customerDaoImpl;
    @Autowired
    private CustomerGroupDaoImpl customerGroupDaoImpl;

    @Override
    public int addCustomerGroup(CustomerGroup cg) {
        return customerGroupDaoImpl.addCustomerGroup(cg);
    }

    @Override
    public int updateCustomerGroup(CustomerGroup cg) {
        return customerGroupDaoImpl.updateCustomerGroup(cg);
    }

    @Override
    public int customerGroupCount(Map<String, Object> map) {
        return customerGroupDaoImpl.customerGroupCount(map);
    }

    @Override
    public List<CustomerGroup> customerGroupList(Map<String, Object> map) {
        return customerGroupDaoImpl.customerGroupList(map);
    }

    @Override
    public CustomerGroup getCustomerGroup(Map<String, Object> map) {
        return customerGroupDaoImpl.getCustomerGroup(map);
    }

    @Override
    public int addCustomer(CustomerTab customerTab) {
        return customerDaoImpl.addCustomer(customerTab);
    }

    @Override
    public int updateCustomer(CustomerTab customerTab) {
        return customerDaoImpl.updateCustomer(customerTab);
    }

    @Override
    public int customerTabCount(Map<String, Object> map) {
        return customerDaoImpl.customerTabCount(map);
    }

    @Override
    public List<CustomerTab> customerTabList(Map<String, Object> map) {
        return customerDaoImpl.customerTabList(map);
    }

    @Override
    public CustomerTab getCustomerTabDetail(Map<String, Object> map) {
        return customerDaoImpl.getCustomerTabDetail(map);
    }
}
