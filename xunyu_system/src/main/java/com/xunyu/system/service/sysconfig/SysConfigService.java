package com.xunyu.system.service.sysconfig;

import com.xunyu.system.pojo.sysconfig.SystemConfig;

import java.util.Map;

/**
 * @author dth
 * @date 2018/4/26 16:25
 **/
public interface SysConfigService {

    /**
     * 添加系统全局配置信息
     */
    int addSysConfig(SystemConfig sc);

    /**
     * 修改系统全局配置
     */
    int updateSysConfig(SystemConfig sc);

    /**
     * 获取系统全局配置详情
     */
    SystemConfig getSysConfigDetail(Map<String,Object> map);



}
