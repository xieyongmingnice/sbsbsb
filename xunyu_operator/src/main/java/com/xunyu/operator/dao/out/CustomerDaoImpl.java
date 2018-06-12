package com.xunyu.operator.dao.out;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.operator.pojo.out.Customer;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/6/12 16:48
 */
@Repository
public class CustomerDaoImpl extends BaseDao {


    public List<Customer> selectCustomerList(){
        return selectList("com.xunyu.operator.pojo.out.Customer.selectCustomerList");
    }

    public CustomerDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class getClz() {
        return null;
    }
}
