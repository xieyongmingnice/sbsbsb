package com.xunyu.logs.service.operation;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.logs.dao.operation.OperNotifyLogsDaoImpl;
import com.xunyu.model.log.operation.OperNotifyLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 10:25
 **/
@Service
public class OperNotifyLogsServiceImpl implements OperNotifyLogsService{

    @Autowired
    private OperNotifyLogsDaoImpl operNotifyLogsDao;

    @Override
    public int countOperNotifyLogs(Map<String, Object> map) {
        return operNotifyLogsDao.countOperNotifyLogs(map);
    }

    @Override
    public List<OperNotifyLogs> listOperNotifyLogs(Map<String, Object> map) {
        return operNotifyLogsDao.listOperNotifyLogs(map);
    }

    @Override
    public int delOperNotifyLogs(String ids) {
        int n = 0;
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
           n = operNotifyLogsDao.delOperNotifyLogs(list);
        }
        return n;
    }
}
