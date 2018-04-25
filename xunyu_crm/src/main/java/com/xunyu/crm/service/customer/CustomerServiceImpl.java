package com.xunyu.crm.service.customer;

import com.commons.core.util.StringUtils2;
import com.xunyu.crm.dao.CustomerDaoImpl;
import com.xunyu.crm.dao.CustomerGroupDaoImpl;
import com.xunyu.crm.pojo.customer.CustomerGroup;
import com.xunyu.crm.pojo.customer.CustomerTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        int n = 0;
        n = customerDaoImpl.addCustomer(customerTab);
        if(n > 0){
            //异步往tbl_users表中添加一条账号信息记录
            //注册完之后启动线程为用户增加免费的礼物
            ExecutorService pool = Executors.newCachedThreadPool();
            Runnable run = new Runnable(){//创建一个线程匿名内部类
                @Override
                public void run() {

                }
            };
            pool.submit(run);
            pool.shutdown();//执行完之后释放该线程
        }
        return n;
    }

    @Override
    public int updateCustomer(CustomerTab customerTab) {
        return customerDaoImpl.updateCustomer(customerTab);
    }

    @Override
    public int updateCustomerAll(String customerIds) {
        int n = 0;
        String[] idsLon = customerIds.split(",");
        for (int i = 0; i < idsLon.length; i++) {
            if (StringUtils2.isNotEmpty(idsLon[i])) { //再一次判断字符串末尾是不是有逗号
                CustomerTab cu = new CustomerTab();
                cu.setIsabled(0);
                cu.setCustomerId(Long.parseLong(idsLon[i]));
                n = customerDaoImpl.updateCustomer(cu);
            } else {
                continue;
            }
        }
        return n;
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
