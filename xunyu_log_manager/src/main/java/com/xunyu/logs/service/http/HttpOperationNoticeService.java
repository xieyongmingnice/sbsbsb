package com.xunyu.logs.service.http;

import com.xunyu.model.log.http.HttpOperationNotice;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:40
 **/
public interface HttpOperationNoticeService {

    /**
     * 获取列表
     */
    int countHttpOperationNotice(Map<String,Object> map);
    List<HttpOperationNotice> listHttpOperationNotice(Map<String,Object> map);

    /**
     * 删除
     */
    int delHttpOperationNotice(String ids);
}
