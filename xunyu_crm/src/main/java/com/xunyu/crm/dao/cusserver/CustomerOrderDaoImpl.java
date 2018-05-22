package com.xunyu.crm.dao.cusserver;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.cusserver.CustomerOrder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 9:09
 **/
@Repository
public class CustomerOrderDaoImpl extends BaseDao<CustomerOrder,Long> {

    /**
     * 添加订购服务
     */
    public int saveCustomerOrder(CustomerOrder c){

        return super.insert("com.xunyu.crm.pojo.cusserver.CustomerOrder.saveCustomerOrder",c);
    }

    /**
     * 修改订购服务
     */
    public int updateCustomerOrder(CustomerOrder c){

        return super.update("com.xunyu.crm.pojo.cusserver.CustomerOrder.updateCustomerOrder",c);
    }

    /**
     * 删除订购服务
     */
    public int delCustomerOrder(Map<String,Object> map){

        return super.update("com.xunyu.crm.pojo.cusserver.CustomerOrder.delCustomerOrder",map);
    }

    public CustomerOrderDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<CustomerOrder> getClz() {
        return CustomerOrder.class;
    }
}
