package com.xunyu.system.dao.syspay;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.syspay.SysPayState;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SysPayStateDaoImpl extends BaseDao<SysPayState,Long> {

    /**
     * 添加系统支付配置状态
     */
   public int addSysPayState(SysPayState s){

       return super.insert("com.xunyu.system.pojo.syspay.SysPayState.addSysPayState",s);
    }

    /**
     * 修改系统支付配置状态
     */
    public int updateSysPayState(SysPayState s){

        return super.update("com.xunyu.system.pojo.syspay.SysPayState.updateSysPayState",s);
    }

    /**
     * 获取详情
     */
    public SysPayState getSysPayStateDetail(Map<String,Object> map){

        return super.selectForObject("com.xunyu.system.pojo.syspay.SysPayState.getSysPayStateDetail",map);
    }

    public SysPayStateDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SysPayState> getClz() {
        return SysPayState.class;
    }
}
