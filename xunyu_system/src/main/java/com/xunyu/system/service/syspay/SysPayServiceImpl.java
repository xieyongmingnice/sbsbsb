package com.xunyu.system.service.syspay;

import com.xunyu.system.dao.syspay.SysPayDaoImpl;
import com.xunyu.system.pojo.syspay.SysPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/27 11:22
 **/
@Service
public class SysPayServiceImpl implements SysPayService {

    @Autowired
    private SysPayDaoImpl sysPayDaoImpl;

    @Override
    public int addSysPay(SysPay sysPay) {
        return sysPayDaoImpl.addSysPay(sysPay);
    }

    @Override
    public int updateSysPay(SysPay syaPay) {
        return sysPayDaoImpl.updateSysPay(syaPay);
    }

    @Override
    public List<SysPay> getSysPayDetail(Map<String, Object> map) {
        return sysPayDaoImpl.getSysPayDetail(map);
    }
}
