package com.xunyu.crm.dao.cuspay;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.cuspay.CustomerPay;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 9:23
 **/
@Repository
public class CustomerPayDaoImpl extends BaseDao<CustomerPay,Long> {

    /**
     * 添加付费记录
     */
    public int saveCustomerPay(CustomerPay c){

        return super.insert("com.xunyu.crm.pojo.cuspay.CustomerPay.saveCustomerPay",c);
    }

    /**
     * 修改付费记录
     */
    public int updateCustomerPay(CustomerPay c){

        return super.update("com.xunyu.crm.pojo.cuspay.CustomerPay.updateCustomerPay",c);
    }

    /**
     * 删除付费记录
     */
    public int delCustomerPay(Map<String,Object> map){

        return super.update("com.xunyu.crm.pojo.cuspay.CustomerPay.delCustomerPay",map);
    }

    public CustomerPayDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<CustomerPay> getClz() {
        return CustomerPay.class;
    }
}
