package com.xunyu.crm.service.proserver;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.crm.dao.proserver.ProductDaoImpl;
import com.xunyu.crm.pojo.proserver.ProductServere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/26 15:29
 **/
@Service
public class ProductSerServiceImpl implements ProductSerService {
    @Autowired
    private ProductDaoImpl productDao;

    @Override
    public int saveProduct(ProductServere p) {
        return productDao.saveProduct(p);
    }

    @Override
    public int updateProduct(ProductServere p) {
        return productDao.updateProduct(p);
    }

    @Override
    public int delProduct(String ids) {
        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0) {
            map.put("isabled", 0);
            map.put("list", list);
            n = productDao.delProduct(map);
        }
        return n;
    }
}
