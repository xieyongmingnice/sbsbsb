package com.xunyu.system.service.syspay;

import com.xunyu.system.pojo.syspay.SysPayState;

import java.util.Map;

public interface SysPayStateService {

    /**
     * 添加系统支付配置状态
     */
    int addSysPayState(SysPayState s);

    /**
     * 修改系统支付配置状态
     */
    int updateSysPayState(SysPayState s);

    /**
     * 获取详情
     */
    SysPayState getSysPayStateDetail(Map<String,Object> map);
}
