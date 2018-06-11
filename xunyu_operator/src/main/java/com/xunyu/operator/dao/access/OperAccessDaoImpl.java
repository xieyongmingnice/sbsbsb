package com.xunyu.operator.dao.access;

import com.commons.core.dao.impl.BaseDao;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.access.OperExtendConfig;
import com.xunyu.operator.pojo.access.OperMarkConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/6/11 11:43
 **/
@Repository
public class OperAccessDaoImpl extends BaseDao<OperAccessCoreConfig,Long> {

    /**
     * 添加网关接入配置
     */
    public int saveOperAccess(OperAccessCoreConfig occ){

        return super.insert("com.xunyu.operator.pojo.access.OperAccessCoreConfig.saveOperAccess",occ);
    }
    public int saveOperExtend(OperExtendConfig oec){

        return super.insert("com.xunyu.operator.pojo.access.OperExtendConfig.saveOperExtend",oec);
    }
    public int saveOperMark(OperMarkConfig omc){

        return super.insert("com.xunyu.operator.pojo.access.OperMarkConfig.saveOperMark",omc);
    }

    /**
     * 修改网关接入配置
     */
    public int updateOperAccess(OperAccessCoreConfig occ){

        return super.update("com.xunyu.operator.pojo.access.OperAccessCoreConfig.updateOperAccess",occ);
    }
    public int updateOperExtend(OperExtendConfig oec){

        return super.update("com.xunyu.operator.pojo.access.OperExtendConfig.updateOperExtend",oec);
    }
    public int updateOperMark(OperMarkConfig omc){

        return super.update("com.xunyu.operator.pojo.access.OperMarkConfig.updateOperMark",omc);
    }

    /**
     * 获取网关接入配置详情
     */
    public OperAccessCoreConfig getOperAccessCoreConfig(Map<String,Object> map){

        return super.selectForObject("com.xunyu.operator.pojo.access.OperAccessCoreConfig.getOperAccessCoreConfig",map);
    }

    /**
     * 获取网关接入配置列表
     */
    public int countOperAccessCoreConfig(Map<String,Object> map){

        return super.selectForObject("com.xunyu.operator.pojo.access.OperAccessCoreConfig.countOperAccessCoreConfig",map);
    }
    public  List<OperAccessCoreConfig> listOperAccessCoreConfig(Map<String,Object> map){

        return super.selectForListObject("com.xunyu.operator.pojo.access.OperAccessCoreConfig.listOperAccessCoreConfig",map);
    }

    public OperAccessDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public Class<OperAccessCoreConfig> getClz() {
        return OperAccessCoreConfig.class;
    }
}
