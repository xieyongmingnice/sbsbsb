package com.xunyu.logs.dao.http;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.log.http.HttpOperationNotice;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:43
 **/
@Repository
public class HttpOperationNoticeDaoImpl extends BaseDao<HttpOperationNotice,Long> {
    public HttpOperationNoticeDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }
    /**
     * 获取列表
     */
    public int countHttpOperationNotice(Map<String,Object> map){

        return super.selectForObject("com.xunyu.model.log.http.HttpOperationNotice.countHttpOperationNotice",map);
    }
    public List<HttpOperationNotice> listHttpOperationNotice(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.model.log.http.HttpOperationNotice.listHttpOperationNotice",map);
    }

    /**
     * 删除
     */
    public  int delHttpOperationNotice(List<String> list){

        return super.delete("com.xunyu.model.log.http.HttpOperationNotice.delHttpOperationNotice",list);
    }

    @Override
    public Class<HttpOperationNotice> getClz() {
        return HttpOperationNotice.class;
    }
}
