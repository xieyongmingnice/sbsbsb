package com.xunyu.crm.dao.customer;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.customer.CustomerGroup;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/24 11:41
 **/
@Repository
public class CustomerGroupDaoImpl extends BaseDao<CustomerGroup, Long> {
    public CustomerGroupDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<CustomerGroup> getClz() {
        return CustomerGroup.class;
    }

    /**
     * 添加客户分组
     */
    public int addCustomerGroup(CustomerGroup customerGroup){

        return super.insert("com.xunyu.crm.pojo.customer.CustomerGroup.addCustomerGroup",customerGroup);
    }

    /**
     * 修改分组信息
     */
    public int updateCustomerGroup(CustomerGroup cg){
        return super.update("com.xunyu.crm.pojo.customer.CustomerGroup.updateCustomerGroup",cg);
    }

    /**
     * 获取客户分组列表
     */
    public int customerGroupCount(Map<String,Object> map){
       return super.selectForObject("com.xunyu.crm.pojo.customer.CustomerGroup.customerGroupCount",map);
    }
    public List<CustomerGroup> customerGroupList(Map<String,Object> map){
        return super.selectForListObject("com.xunyu.crm.pojo.customer.CustomerGroup.customerGroupList",map);
    }
    /**
     * 获取分组详情
     */
    public CustomerGroup getCustomerGroup(Map<String,Object> map){
        return super.selectForObject("com.xunyu.crm.pojo.customer.CustomerGroup.getCustomerGroup",map);
    }
}
