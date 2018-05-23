package com.xunyu.logs.dao.liusu;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.log.liusu.LiusuMonitorLogs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 10:51
 **/
@Repository
public class LiusuMonitorLogsDaoImpl extends BaseDao<LiusuMonitorLogs,Long> {

    public LiusuMonitorLogsDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    /**
     * 获取列表
     */
    public int countLiusuMonitorLogs(Map<String,Object> map){

        return super.selectForObject("com.xunyu.model.log.liusu.LiusuMonitorLogs.countLiusuMonitorLogs",map);
    }
    public List<LiusuMonitorLogs> listLiusuMonitorLogs(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.model.log.liusu.LiusuMonitorLogs.listLiusuMonitorLogs",map);
    }

    /**
     * 删除
     */
    public int delLiusuMonitorLogs(List<String> list){

        return super.delete("com.xunyu.model.log.liusu.LiusuMonitorLogs.delLiusuMonitorLogs",list);
    }

    @Override
    public Class<LiusuMonitorLogs> getClz() {
        return LiusuMonitorLogs.class;
    }
}
