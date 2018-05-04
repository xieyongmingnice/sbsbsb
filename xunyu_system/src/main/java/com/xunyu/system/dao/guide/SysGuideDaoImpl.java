package com.xunyu.system.dao.guide;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.guide.SysGuide;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/3 11:29
 **/
@Repository
public class SysGuideDaoImpl extends BaseDao<SysGuide,Long> {

    /**
     * 添加
     */
    public int addSysGuide(SysGuide sg){

        return super.insert("com.xunyu.system.pojo.guide.SysGuide.addSysGuide",sg);
    }

    /**
     * 删除
     */
    public int delSysGuide(Map<String,Object> map){
        return super.update("com.xunyu.system.pojo.guide.SysGuide.delSysGuide",map);
    }

    /**
     * 列表
     */
    public  List<SysGuide> sysGuideList(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.system.pojo.guide.SysGuide.sysGuideList",map);
    }

    public SysGuideDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SysGuide> getClz() {
        return SysGuide.class;
    }
}
