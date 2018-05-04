package com.xunyu.logs.dao.syslog;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.log.syslog.SysLogs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author dth
 * @date 2018/5/3 17:23
 **/
@Repository
public class SysLogsDaoImpl extends BaseDao<SysLogs,Long> {

    /**
     * 添加日志
     * @param //sqlSessionFactory
     */
    public int addSysLog(SysLogs sl){

        return super.insert("com.xunyu.model.log.syslog.SysLogs.addSysLog",sl);
    }

    public SysLogsDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SysLogs> getClz() {
        return SysLogs.class;
    }
}
