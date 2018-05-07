package com.xunyu.logs.service.syslog;

import com.xunyu.logs.dao.syslog.SysLogsDaoImpl;
import com.xunyu.model.log.syslog.SysLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/3 17:37
 **/
@Service
public class SysLogsServiceImpl implements SysLogsService {

    @Autowired
    private SysLogsDaoImpl sysLogsDaoImpl;

    /**
     * 增加系统日志
     * @param sl
     * @return
     */
    @Override
    public int addSysLog(SysLogs sl) {
        int n = 0;
        n = sysLogsDaoImpl.addSysLog(sl);
        return n;
    }

    @Override
    public int sysLogsCount(Map<String, Object> map) {
        return sysLogsDaoImpl.sysLogsCount(map);
    }

    @Override
    public List<SysLogs> sysLogsList(Map<String, Object> map) {
        return sysLogsDaoImpl.sysLogsList(map);
    }

    @Override
    public SysLogs getSysLogsDetail(Map<String, Object> map) {
        return sysLogsDaoImpl.getSysLogsDetail(map);
    }
}
