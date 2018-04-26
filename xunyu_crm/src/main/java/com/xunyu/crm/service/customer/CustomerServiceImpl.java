package com.xunyu.crm.service.customer;

import com.commons.core.util.MD5Utils;
import com.commons.core.util.StringUtils2;
import com.xunyu.crm.dao.customer.CustomerDaoImpl;
import com.xunyu.crm.dao.customer.CustomerGroupDaoImpl;
import com.xunyu.crm.dao.customer.user.UserDaoImpl;
import com.xunyu.crm.pojo.customer.CustomerGroup;
import com.xunyu.crm.pojo.customer.CustomerTab;
import com.xunyu.crm.pojo.customer.CustomerUseraccount;
import com.xunyu.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public int addCustomerGroup(CustomerGroup cg) {
        return customerGroupDaoImpl.addCustomerGroup(cg);
    }

    @Override
    public int updateCustomerGroup(CustomerGroup cg) {
        return customerGroupDaoImpl.updateCustomerGroup(cg);
    }

    @Override
    public int updateCustomerGroupAll(String ids) {
        int n = 0;
        String[] idsLon = ids.split(",");
        for (int i = 0; i < idsLon.length; i++) {
            if (StringUtils2.isNotEmpty(idsLon[i])) { //再一次判断字符串末尾是不是有逗号
                CustomerGroup cu = new CustomerGroup();
                cu.setIsabled(0);
                cu.setCustomerGroupId(Long.parseLong(idsLon[i]));
                n = customerGroupDaoImpl.updateCustomerGroup(cu);
                /**
                 * 起线程异步做级联删除该分组下的客户信息
                 */
                delJilian(ids);
            } else {
                continue;
            }
        }
        return n;
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
        if (n > 0) {
            //异步往tbl_users表中添加一条账号信息记录
            ExecutorService pool = Executors.newCachedThreadPool();
            Runnable run = new Runnable() {//创建一个线程匿名内部类
                @Override
                public void run() {
                    try {
                        User user = new User();
                        user.setAccount(customerTab.getCustomerAccount());
                        user.setPassWord(MD5Utils.getMD5(customerTab.getCustomerPsw()));
                        user.setIsabled(1);//未删除
                        user.setUserType(2);//2是客户
                        user.setUserCreateTime(new Date());
                        int n = userDaoImpl.addUser(user);
                        if (n > 0) {
                            CustomerUseraccount cu = new CustomerUseraccount();
                            cu.setAccountType(1);//默认主账户
                            cu.setCustomerId(customerTab.getCustomerId());
                            cu.setUserId(user.getUserId());
                            userDaoImpl.addCustomerUseraccount(cu);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            pool.submit(run);
            pool.shutdown();//执行完之后释放该线程
        }
        return n;
    }

    @Override
    public int updateCustomer(CustomerTab customerTab) {
        int n = 0;
        n = customerDaoImpl.updateCustomer(customerTab);
        if (n > 0) {
            //异步往tbl_users表中添加一条账号信息记录
            ExecutorService pool = Executors.newCachedThreadPool();
            Runnable run = new Runnable() { //创建一个线程匿名内部类
                @Override
                public void run() {
                    try {
                        User user = new User();
                        user.setAccount(customerTab.getCustomerAccount());
                        user.setPassWord(MD5Utils.getMD5(customerTab.getCustomerPsw()));
                        int n = userDaoImpl.updateUser(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            pool.submit(run);
            pool.shutdown();//执行完之后释放该线程
        }
        return n;
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

    //级联删除
    private int delJilian(String ids) {
        int n = 1;
        //异步往tbl_users表中添加一条账号信息记录
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable run = new Runnable() {//创建一个线程匿名内部类
            @Override
            public void run() {
                try {
                    String[] idsLon = ids.split(",");
                    for (int i = 0; i < idsLon.length; i++) {
                        if (StringUtils2.isNotEmpty(idsLon[i])) { //再一次判断字符串末尾是不是有逗号
                            CustomerTab cu = new CustomerTab();
                            cu.setIsabled(0);
                            cu.setCustomerGroupId(Long.parseLong(idsLon[i]));
                            customerDaoImpl.updateCustomer(cu);
                        } else {
                            continue;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
             }
            };
            pool.submit(run);
            pool.shutdown();//执行完之后释放该线程
        return n;
    }
}
