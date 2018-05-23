package com.xunyu.logs.service.operation;

import com.xunyu.model.log.operation.OperNotifyLogs;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 10:18
 **/
public interface OperNotifyLogsService {

    /**
     * 获取操作通知列表
     */
    int countOperNotifyLogs(Map<String,Object> map);
    List<OperNotifyLogs> listOperNotifyLogs(Map<String,Object> map);

    /**
     * 删除操作通知
     */
    int delOperNotifyLogs(String ids);
}
