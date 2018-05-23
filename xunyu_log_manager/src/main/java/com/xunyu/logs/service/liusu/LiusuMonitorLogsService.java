package com.xunyu.logs.service.liusu;

import com.xunyu.model.log.liusu.LiusuMonitorLogs;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 10:42
 **/
public interface LiusuMonitorLogsService {

    /**
     * 获取列表
     */
    int countLiusuMonitorLogs(Map<String,Object> map);
    List<LiusuMonitorLogs> listLiusuMonitorLogs(Map<String,Object> map);

    /**
     * 删除
     */
    int delLiusuMonitorLogs(String ids);
}
