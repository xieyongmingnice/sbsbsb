package com.xunyu.operator.service.out;

import com.xunyu.operator.dao.out.CustomerDaoImpl;
import com.xunyu.operator.pojo.out.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description
 * @date 2018/6/12 17:14
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDaoImpl dao;

    @Override
    public List<Customer> selectCustomerList() {
        return dao.selectCustomerList();
    }
}
