package com.xunyu.logs.service.liusu;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.logs.dao.liusu.LiusuMonitorLogsDaoImpl;
import com.xunyu.model.log.liusu.LiusuMonitorLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:04
 **/
@Service
public class LiusuMonitorLogsServiceImpl implements LiusuMonitorLogsService {

    @Autowired
    private LiusuMonitorLogsDaoImpl liusuMonitorLogsDao;

    @Override
    public int countLiusuMonitorLogs(Map<String, Object> map) {
        return liusuMonitorLogsDao.countLiusuMonitorLogs(map);
    }

    @Override
    public List<LiusuMonitorLogs> listLiusuMonitorLogs(Map<String, Object> map) {
        return liusuMonitorLogsDao.listLiusuMonitorLogs(map);
    }

    @Override
    public int delLiusuMonitorLogs(String ids) {
        int n = 0;
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
           n = liusuMonitorLogsDao.delLiusuMonitorLogs(list);
        }
        return n;
    }
}
