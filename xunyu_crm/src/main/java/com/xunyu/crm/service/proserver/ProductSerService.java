package com.xunyu.crm.service.proserver;

import com.xunyu.crm.pojo.proserver.ProductServere;

/**
 * @author dth
 * @date 2018/4/26 15:29
 *
 * 产品服务
 **/
public interface ProductSerService {

    /**
     *添加产品
     */
    int saveProduct(ProductServere p);

    /**
     * 修改产品
     */
    int updateProduct(ProductServere p);

    /**
     * 删除产品
     */
    int delProduct(String ids);
}
