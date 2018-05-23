package com.xunyu.logs.dao.link;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.model.log.link.LinkOperLogs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/23 11:10
 **/
@Repository
public class LinkOperLogsDaoImpl extends BaseDao<LinkOperLogs,Long> {

    public LinkOperLogsDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    /**
     * 获取列表
     */
   public int countLinkOperLogs(Map<String,Object> map){

       return super.selectForObject("com.xunyu.model.log.link.LinkOperLogs.countLinkOperLogs",map);
    }
    public List<LinkOperLogs> listLinkOperLogs(Map<String,Object> map){

       return super.selectForListObject("com.xunyu.model.log.link.LinkOperLogs.listLinkOperLogs",map);
    }

    /**
     * 删除
     */
    public int delLinkOperLogs(List<String> list){

        return super.delete("com.xunyu.model.log.link.LinkOperLogs.delLinkOperLogs",list);
    }

    @Override
    public Class<LinkOperLogs> getClz() {
        return LinkOperLogs.class;
    }
}
