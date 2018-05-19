package com.xunyu.system.service.syspay;

import com.xunyu.system.pojo.syspay.SysPay;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/27 10:51
 **/
public interface SysPayService {

    /**
     *添加支付配置
     */
    int addSysPay(SysPay sysPay);

    /**
     * 修改支付配置
     */
    int updateSysPay(SysPay syaPay);

    /**
     * 查询当前登录用户支付配置信息
     */
    List<SysPay> getSysPayDetail(Map<String,Object> map);
}
