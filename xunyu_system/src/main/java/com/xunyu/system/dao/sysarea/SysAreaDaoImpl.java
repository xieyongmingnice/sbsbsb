package com.xunyu.system.dao.sysarea;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.system.pojo.sysarea.SysArea;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/7 16:58
 **/
@Repository
public class SysAreaDaoImpl extends BaseDao<SysArea,Long> {

    /**
     * 添加区域配置
     */
    public int addSysAreaConfig(SysArea sa){

        return super.insert("com.xunyu.system.pojo.sysarea.SysArea.addSysAreaConfig",sa);
    }

    /**
     * 修改区域配置
     */
    public int updateSysAreaConfig(SysArea sa){

        return super.update("com.xunyu.system.pojo.sysarea.SysArea.updateSysAreaConfig",sa);
    }

    /**
     * 获取区域配置
     */
    public SysArea getSysAreaConfig(Map<String,Object> map){

        return super.selectForObject("com.xunyu.system.pojo.sysarea.SysArea.getSysAreaConfig",map);
    }

    /**
     * 获取区域配置列表
     */
    public int sysAreaConfigCount(Map<String,Object> map){

        return super.selectForObject("com.xunyu.system.pojo.sysarea.SysArea.sysAreaConfigCount",map);
    }
    public List<SysArea> sysAreaConfigList(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.system.pojo.sysarea.SysArea.sysAreaConfigList",map);
    }

    /**
     * 删除区域配置信息
     */
    public int delSysAreaConfig(Map<String,Object> map){

        return super.update("com.xunyu.system.pojo.sysarea.SysArea.delSysAreaConfig",map);
    }

    public SysAreaDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<SysArea> getClz() {
        return SysArea.class;
    }
}
