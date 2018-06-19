package com.xunyu.operator.service.access;

import com.xunyu.operator.pojo.access.OperAccessCoreConfig;

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

    /**
     * 修改网关接入配置
     */
    int updateOperAccess(OperAccessCoreConfig occ);

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
     *修改状态
     */
    int delOperAccessCoreConfig(String ids,int isabled);

    /**
     * 删除、恢复
     */
    int delOperAccessConfigDelState(String ids,int delState);
}
