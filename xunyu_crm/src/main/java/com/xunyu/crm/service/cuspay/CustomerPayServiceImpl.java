package com.xunyu.crm.service.cuspay;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.crm.dao.cuspay.CustomerPayDaoImpl;
import com.xunyu.crm.pojo.cuspay.CustomerPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 9:26
 **/
@Service
public class CustomerPayServiceImpl implements CustomerPayService {

    @Autowired
    private CustomerPayDaoImpl customerPayDao;

    @Override
    public int saveCustomerPay(CustomerPay c) {
        return customerPayDao.saveCustomerPay(c);
    }

    @Override
    public int updateCustomerPay(CustomerPay c) {
        return customerPayDao.updateCustomerPay(c);
    }

    @Override
    public int delCustomerPay(String ids) {
        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        //获取集合
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
            map.put("isabled",0);
            map.put("list",list);
            n = customerPayDao.delCustomerPay(map);
        }
        return n;
    }
}
