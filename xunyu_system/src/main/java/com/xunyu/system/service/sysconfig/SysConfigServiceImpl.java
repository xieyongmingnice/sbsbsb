package com.xunyu.system.service.sysconfig;

import com.xunyu.system.dao.SysConfigDaoImpl;
import com.xunyu.system.pojo.sysconfig.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author dth
 * @date 2018/4/26 16:26
 **/
@Service
public class SysConfigServiceImpl implements SysConfigService{

    @Autowired
    private SysConfigDaoImpl sysConfigDaoImpl;

    @Override
    public int addSysConfig(SystemConfig sc) {
        int n = 0;
        n = sysConfigDaoImpl.addSysConfig(sc);
        return n;
    }

    @Override
    public int updateSysConfig(SystemConfig sc) {
        int n = 0;
        n = sysConfigDaoImpl.updateSysConfig(sc);
        return n;
    }

    @Override
    public SystemConfig getSysConfigDetail(Map<String, Object> map) {
        return sysConfigDaoImpl.getSysConfigDetail(map);
    }


}
