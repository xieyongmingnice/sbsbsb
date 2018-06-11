package com.xunyu.operator.service.access;

import com.xunyu.operator.dao.access.OperAccessDaoImpl;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.access.OperExtendConfig;
import com.xunyu.operator.pojo.access.OperMarkConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/6/11 11:50
 **/
@Service
public class OperAccessServiceImpl implements OperAccessService {

    @Autowired
    private OperAccessDaoImpl operAccessDao;

    @Override
    public int saveOperAccess(OperAccessCoreConfig occ) {
        return operAccessDao.saveOperAccess(occ);
    }

    @Override
    public int saveOperExtend(OperExtendConfig oec) {
        return operAccessDao.saveOperExtend(oec);
    }

    @Override
    public int saveOperMark(OperMarkConfig omc) {
        return operAccessDao.saveOperMark(omc);
    }

    @Override
    public int updateOperAccess(OperAccessCoreConfig occ) {
        return operAccessDao.updateOperAccess(occ);
    }

    @Override
    public int updateOperExtend(OperExtendConfig oec) {
        return operAccessDao.updateOperExtend(oec);
    }

    @Override
    public int updateOperMark(OperMarkConfig omc) {
        return operAccessDao.updateOperMark(omc);
    }

    @Override
    public OperAccessCoreConfig getOperAccessCoreConfig(Map<String, Object> map) {
        return operAccessDao.getOperAccessCoreConfig(map);
    }

    @Override
    public int countOperAccessCoreConfig(Map<String, Object> map) {
        return operAccessDao.countOperAccessCoreConfig(map);
    }

    @Override
    public List<OperAccessCoreConfig> listOperAccessCoreConfig(Map<String, Object> map) {
        return operAccessDao.listOperAccessCoreConfig(map);
    }
}
