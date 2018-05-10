package com.xunyu.logs.service.syslog;

import com.xunyu.model.log.syslog.SysLogs;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/3 17:37
 **/
public interface SysLogsService {

    int addSysLog(SysLogs sl);

    /**
     * 获取日志列表
     */
    int sysLogsCount(Map<String,Object> map);
    List<SysLogs> sysLogsList(Map<String,Object> map);

    /**
     * 获取日志详情
     */
    SysLogs getSysLogsDetail(Map<String,Object> map);

    /**
     * 批量删除
     */
    int delSysLogs(String ids);
}
