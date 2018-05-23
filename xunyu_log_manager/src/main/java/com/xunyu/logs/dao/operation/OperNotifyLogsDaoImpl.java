package com.xunyu.logs.dao.operation;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.log.operation.OperNotifyLogs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 10:21
 **/
@Repository
public class OperNotifyLogsDaoImpl extends BaseDao<OperNotifyLogs,Long> {

    public OperNotifyLogsDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    /**
     * 获取操作通知列表
     */
    public  int countOperNotifyLogs(Map<String,Object> map){

        return super.selectForObject("com.xunyu.model.log.operation.OperNotifyLogs.countOperNotifyLogs",map);
    }
    public List<OperNotifyLogs> listOperNotifyLogs(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.model.log.operation.OperNotifyLogs.listOperNotifyLogs",map);
    }

    /**
     * 删除操作通知
     */
    public int delOperNotifyLogs(List<String> list){

       return super.delete("com.xunyu.model.log.operation.OperNotifyLogs.delOperNotifyLogs",list);
    }

    @Override
    public Class<OperNotifyLogs> getClz() {
        return OperNotifyLogs.class;
    }
}
