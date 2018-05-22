package com.xunyu.crm.dao.cusinvo;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.crm.pojo.cusinvo.CoustomerInvoiceinfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author dth
 * @date 2018/5/22 9:34
 **/
@Repository
public class CustomerInvoiceDaoImpl extends BaseDao<CoustomerInvoiceinfo,Long> {

    /**
     * 添加客户信息发票抬头
     */
    public int saveCustomerInvoice(CoustomerInvoiceinfo c){

        return super.insert("com.xunyu.crm.pojo.cusinvo.CoustomerInvoiceinfo.saveCustomerInvoice",c);
    }

    /**
     * 修改客户信息发票抬头
     */
    public int updateCustomerInvoice(CoustomerInvoiceinfo c){

        return super.update("com.xunyu.crm.pojo.cusinvo.CoustomerInvoiceinfo.updateCustomerInvoice",c);
    }

    /**
     * 删除客户信息发票抬头
     */
    public int delCustomerInvoice(Map<String,Object> map){

        return super.update("com.xunyu.crm.pojo.cusinvo.CoustomerInvoiceinfo.delCustomerInvoice",map);
    }

    public CustomerInvoiceDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<CoustomerInvoiceinfo> getClz() {
        return CoustomerInvoiceinfo.class;
    }
}
