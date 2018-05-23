package com.xunyu.logs.service.http;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.logs.dao.http.HttpOperationNoticeDaoImpl;
import com.xunyu.model.log.http.HttpOperationNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:52
 **/
@Service
public class HttpOperationNoticeServImpl implements HttpOperationNoticeService {

    @Autowired
    private HttpOperationNoticeDaoImpl httpOperationNoticeDao;

    @Override
    public int countHttpOperationNotice(Map<String, Object> map) {
        return httpOperationNoticeDao.countHttpOperationNotice(map);
    }

    @Override
    public List<HttpOperationNotice> listHttpOperationNotice(Map<String, Object> map) {
        return httpOperationNoticeDao.listHttpOperationNotice(map);
    }

    @Override
    public int delHttpOperationNotice(String ids) {
        int n = 0;
        List<String> list = JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
          n = httpOperationNoticeDao.delHttpOperationNotice(list);
        }
        return n;
    }
}
