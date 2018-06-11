package com.xunyu.operator.service.access;

import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.access.OperExtendConfig;
import com.xunyu.operator.pojo.access.OperMarkConfig;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/6/11 11:33
 **/
public interface OperAccessService {

    /**
     * 添加网关接入配置
     */
    int saveOperAccess(OperAccessCoreConfig occ);
    int saveOperExtend(OperExtendConfig oec);
    int saveOperMark(OperMarkConfig omc);

    /**
     * 修改网关接入配置
     */
    int updateOperAccess(OperAccessCoreConfig occ);
    int updateOperExtend(OperExtendConfig oec);
    int updateOperMark(OperMarkConfig omc);

    /**
     * 获取网关接入配置详情
     */
    OperAccessCoreConfig getOperAccessCoreConfig(Map<String,Object> map);

    /**
     * 获取网关接入配置列表
     */
    int countOperAccessCoreConfig(Map<String,Object> map);
    List<OperAccessCoreConfig> listOperAccessCoreConfig(Map<String,Object> map);

    /**
     *
     */
}
