package com.xunyu.system.dao.sysconfig;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.sysconfig.SystemConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author dth
 * @date 2018/4/26 16:37
 **/
@Repository
public class SysConfigDaoImpl extends BaseDao<SystemConfig, Long> {
    public SysConfigDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SystemConfig> getClz() {
        return SystemConfig.class;
    }

    /**
     * 添加系统全局配置信息
     */
    public int addSysConfig(SystemConfig sc){
        return super.insert("com.xunyu.system.pojo.sysconfig.SystemConfig.addSysConfig",sc);
    }

    /**
     * 修改系统全局配置
     */
    public int updateSysConfig(SystemConfig sc){
        return super.update("com.xunyu.system.pojo.sysconfig.SystemConfig.updateSysConfig",sc);
    }

    /**
     * 获取系统全局配置详情
     */
    public SystemConfig getSysConfigDetail(Map<String,Object> map){
        return super.selectForObject("com.xunyu.system.pojo.sysconfig.SystemConfig.getSysConfigDetail",map);
    }


}
