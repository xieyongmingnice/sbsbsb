package com.xunyu.crm.service.cusinvo;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.crm.dao.cusinvo.CustomerInvoiceDaoImpl;
import com.xunyu.crm.pojo.cusinvo.CoustomerInvoiceinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 9:37
 **/
@Service
public class CustomerInvoServiceImpl implements  CustomerInvoiceService {

    @Autowired
    private CustomerInvoiceDaoImpl customerInvoiceDao;

    @Override
    public int saveCustomerInvoice(CoustomerInvoiceinfo c) {
        return customerInvoiceDao.saveCustomerInvoice(c);
    }

    @Override
    public int updateCustomerInvoice(CoustomerInvoiceinfo c) {
        return customerInvoiceDao.updateCustomerInvoice(c);
    }

    @Override
    public int delCustomerInvoice(String ids) {
        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> list =  JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
           n = customerInvoiceDao.delCustomerInvoice(map);
        }
        return n;
    }
}
