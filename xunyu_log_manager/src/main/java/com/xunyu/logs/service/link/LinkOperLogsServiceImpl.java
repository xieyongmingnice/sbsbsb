package com.xunyu.logs.service.link;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.logs.dao.link.LinkOperLogsDaoImpl;
import com.xunyu.model.log.link.LinkOperLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:37
 **/
@Service
public class LinkOperLogsServiceImpl implements LinkOperLogsService {

    @Autowired
    private LinkOperLogsDaoImpl linkOperLogsDao;

    @Override
    public int countLinkOperLogs(Map<String, Object> map) {
        return linkOperLogsDao.countLinkOperLogs(map);
    }

    @Override
    public List<LinkOperLogs> listLinkOperLogs(Map<String, Object> map) {
        return linkOperLogsDao.listLinkOperLogs(map);
    }

    @Override
    public int delLinkOperLogs(String ids) {
        int n = 0;
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
           n = linkOperLogsDao.delLinkOperLogs(list);
        }
        return n;
    }
}
