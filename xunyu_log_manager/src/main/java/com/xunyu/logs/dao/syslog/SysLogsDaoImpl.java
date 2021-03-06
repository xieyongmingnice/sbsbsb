package com.xunyu.logs.dao.syslog;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.log.syslog.SysLogs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取日志列表
     */
    public int sysLogsCount(Map<String,Object> map){
        return super.selectForObject("com.xunyu.model.log.syslog.SysLogs.sysLogsCount",map);
    }
    public List<SysLogs> sysLogsList(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.model.log.syslog.SysLogs.sysLogsList",map);
    }

    /**
     * 获取日志详情
     */
    public SysLogs getSysLogsDetail(Map<String,Object> map){

        return super.selectForObject("com.xunyu.model.log.syslog.SysLogs.getSysLogsDetail",map);
    }

    /**
     * 批量删除
     */
    public int delSysLogs(List<String> idsList){

        return super.delete("com.xunyu.model.log.syslog.SysLogs.delSysLogs",idsList);
    }

    public SysLogsDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SysLogs> getClz() {
        return SysLogs.class;
    }
}
