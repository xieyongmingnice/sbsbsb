package com.xunyu.logs.service.syslog;

import com.xunyu.model.log.syslog.SysLogs;

/**
 * @author dth
 * @date 2018/5/3 17:37
 **/
public interface SysLogsService {

    int addSysLog(SysLogs sl);
}
