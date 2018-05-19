package com.xunyu.system.dao.syspay;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.syspay.SysPay;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/27 11:11
 **/
@Repository
public class SysPayDaoImpl extends BaseDao<SysPay,Long> {

    /**
     *添加支付配置
     */
    public int addSysPay(SysPay sysPay){
        return super.insert("com.xunyu.system.pojo.syspay.SysPay.addSysPay",sysPay);
    }

    /**
     * 修改支付配置
     */
    public int updateSysPay(SysPay syaPay){
        return super.update("com.xunyu.system.pojo.syspay.SysPay.updateSysPay",syaPay);
    }
    /**
     * 查询当前登录用户支付配置信息
     */
    public List<SysPay> getSysPayDetail(Map<String,Object> map){
        return super.selectForListObject("com.xunyu.system.pojo.syspay.SysPay.getSysPayDetail",map);
    }

    public SysPayDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SysPay> getClz() {
        return SysPay.class;
    }
}
