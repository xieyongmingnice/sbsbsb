package com.xunyu.logs.service.link;

import com.xunyu.model.log.link.LinkOperLogs;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:07
 **/
public interface LinkOperLogsService {

    /**
     * 获取列表
     */
    int countLinkOperLogs(Map<String,Object> map);
    List<LinkOperLogs> listLinkOperLogs(Map<String,Object> map);

    /**
     * 删除
     */
    int delLinkOperLogs(String ids);
}
