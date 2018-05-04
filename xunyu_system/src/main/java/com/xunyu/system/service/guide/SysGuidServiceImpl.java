package com.xunyu.system.service.guide;

import com.xunyu.system.dao.guide.SysGuideDaoImpl;
import com.xunyu.system.pojo.guide.SysGuide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/3 11:32
 **/
@Service
public class SysGuidServiceImpl implements SysGuideService {

    @Autowired
    private SysGuideDaoImpl sysGuideDaoImpl;

    @Override
    public int addSysGuide(SysGuide sg) {
        return sysGuideDaoImpl.addSysGuide(sg);
    }

    @Override
    public int delSysGuide(Map<String, Object> map) {
        return sysGuideDaoImpl.delSysGuide(map);
    }

    @Override
    public List<SysGuide> sysGuideList(Map<String, Object> map) {
        return sysGuideDaoImpl.sysGuideList(map);
    }
}
