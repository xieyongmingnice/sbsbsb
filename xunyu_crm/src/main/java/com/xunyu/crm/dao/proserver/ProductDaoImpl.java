package com.xunyu.crm.dao.proserver;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.proserver.ProductServere;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 8:38
 **/
@Repository
public class ProductDaoImpl extends BaseDao<ProductServere,Long> {


    /**
     *添加产品
     */
    public int saveProduct(ProductServere p){

        return super.insert("com.xunyu.crm.pojo.proserver.ProductServere.saveProduct",p);
    }

    /**
     * 修改产品
     */
    public int updateProduct(ProductServere p){

        return super.update("com.xunyu.crm.pojo.proserver.ProductServere.updateProduct",p);
    }

    /**
     * 删除产品
     */
    public int delProduct(Map<String,Object> map){

        return super.update("com.xunyu.crm.pojo.proserver.ProductServere.com.xunyu.crm.dao.proserver.ProductDaoImpl.delProduct",map);
    }

    public ProductDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<ProductServere> getClz() {
        return ProductServere.class;
    }
}
