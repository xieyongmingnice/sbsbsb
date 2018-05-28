package com.xunyu.crm.dao.customer;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.customer.CustomerTab;
import com.xunyu.model.crm.customer.CustomerModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/24 11:39
 **/
@Repository
public class CustomerDaoImpl extends BaseDao<CustomerTab, Long> {
    public CustomerDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<CustomerTab> getClz() {
        return CustomerTab.class;
    }
    /**
     * 添加客户信息
     */
    public int addCustomer(CustomerTab customerTab){
        return super.insert("com.xunyu.crm.pojo.customer.CustomerTab.addCustomer",customerTab);
    }

    /**
     * 修改客户信息
     */
    public int updateCustomer(CustomerTab customerTab){
        return super.update("com.xunyu.crm.pojo.customer.CustomerTab.updateCustomer",customerTab);
    }

    /**
     * 获取客户列表
     */
    public int customerTabCount(Map<String,Object> map){
        return super.selectForObject("com.xunyu.crm.pojo.customer.CustomerTab.customerTabCount",map);
    }
    public List<CustomerTab> customerTabList(Map<String,Object> map){
        return super.selectForListObject("com.xunyu.crm.pojo.customer.CustomerTab.customerTabList",map);
    }

    /**
     * 获取客户详情
     */
    public CustomerTab getCustomerTabDetail(Map<String,Object> map){
       return super.selectForObject("com.xunyu.crm.pojo.customer.CustomerTab.getCustomerTabDetail",map);
    }

    public CustomerModel getCusDetailFeign(Map<String,Object> map){
      return super.selectForObject("com.xunyu.crm.pojo.customer.CustomerTab.getCusDetailFeign",map);
    }

    /**
     * 批量删除客户信息
     */
    public int delCustomer(Map<String,Object> map){

        return super.update("com.xunyu.crm.pojo.customer.CustomerTab.delCustomer",map);
    }

    /**
     * 根据客户分组id获取客户id
     */
    public Long[] getCustomerIdByGroupIds(Map<String,Object> map){

        return super.selectForObject("com.xunyu.crm.pojo.customer.CustomerTab.getCustomerIdByGroupIds",map);
    }
}
