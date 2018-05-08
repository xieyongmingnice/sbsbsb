package com.xunyu.system.service.sysarea;

import com.xunyu.system.pojo.sysarea.SysArea;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/7 16:54
 **/
public interface SysAreaService {

    /**
     * 添加区域配置
     */
    int addSysAreaConfig(SysArea sa);

    /**
     * 修改区域配置
     */
    int updateSysAreaConfig(SysArea sa);

    /**
     * 获取区域配置
     */
    SysArea getSysAreaConfig(Map<String,Object> map);

    /**
     * 获取区域配置列表
     */
    int sysAreaConfigCount(Map<String,Object> map);
    List<SysArea> sysAreaConfigList(Map<String,Object> map);

    /**
     * 删除区域配置信息
     */
    int delSysAreaConfig(String ids);
}
