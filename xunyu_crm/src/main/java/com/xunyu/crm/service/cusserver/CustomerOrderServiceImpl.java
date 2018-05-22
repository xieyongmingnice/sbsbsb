package com.xunyu.crm.service.cusserver;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.crm.dao.cusserver.CustomerOrderDaoImpl;
import com.xunyu.crm.pojo.cusserver.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 9:12
 **/
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDaoImpl customerOrderDao;

    @Override
    public int saveCustomerOrder(CustomerOrder c) {
        return customerOrderDao.saveCustomerOrder(c);
    }

    @Override
    public int updateCustomerOrder(CustomerOrder c) {
        return customerOrderDao.updateCustomerOrder(c);
    }

    @Override
    public int delCustomerOrder(String ids) {
        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0) {
            map.put("isabled", 0);
            map.put("list", list);
            n = customerOrderDao.delCustomerOrder(map);
        }
        return n;
    }
}
