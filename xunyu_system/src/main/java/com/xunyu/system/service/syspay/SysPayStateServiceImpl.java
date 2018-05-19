package com.xunyu.system.service.syspay;

import com.xunyu.system.dao.syspay.SysPayStateDaoImpl;
import com.xunyu.system.pojo.syspay.SysPayState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SysPayStateServiceImpl implements SysPayStateService {

    @Autowired
    private SysPayStateDaoImpl sysPayStateDao;

    @Override
    public int addSysPayState(SysPayState s) {
        return sysPayStateDao.addSysPayState(s);
    }

    @Override
    public int updateSysPayState(SysPayState s) {
        return sysPayStateDao.updateSysPayState(s);
    }

    @Override
    public SysPayState getSysPayStateDetail(Map<String, Object> map) {
        return sysPayStateDao.getSysPayStateDetail(map);
    }
}
