package com.xunyu.system.service.guide;

import com.xunyu.system.pojo.guide.SysGuide;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/3 11:24
 **/
public interface SysGuideService {

    /**
     * 添加
     */
    int addSysGuide(SysGuide sg);

    /**
     * 删除
     */
    int delSysGuide(Map<String,Object> map);

    /**
     * 列表
     */
    List<SysGuide> sysGuideList(Map<String,Object> map);
}
