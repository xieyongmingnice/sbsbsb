package com.xunyu.operator.service.access;

import com.commons.core.util.JavaBeanMap;
import com.xunyu.operator.dao.access.OperAccessDaoImpl;
import com.xunyu.operator.pojo.access.OperAccessCoreConfig;
import com.xunyu.operator.pojo.access.OperAttributeConfig;
import com.xunyu.operator.pojo.access.OperExtendConfig;
import com.xunyu.operator.pojo.access.OperMarkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dth
 * @date 2018/6/11 11:50
 **/
@Service
public class OperAccessServiceImpl implements OperAccessService {
    private Logger log = LoggerFactory.getLogger(OperAccessServiceImpl.class);
    @Autowired
    private OperAccessDaoImpl operAccessDao;

    @Override
    public int saveOperAccess(OperAccessCoreConfig occ){
        int n = 0;
        n = operAccessDao.saveOperAccess(occ);
        ExecutorService ex = Executors.newCachedThreadPool();
        if(n > 0){
            try {
                Runnable ru = new Runnable() {
                    @Override
                    public void run() {
                        OperExtendConfig oec = occ.getOperExtendConfig();
                        if (oec != null) {
                            oec.setConfigId(occ.getConfigId());
                            operAccessDao.saveOperExtend(oec);
                        }
                        OperMarkConfig omc = occ.getOperMarkConfig();
                        if (omc != null) {
                            omc.setConfigId(occ.getConfigId());
                            operAccessDao.saveOperMark(omc);
                        }
                        OperAttributeConfig oac = occ.getOperAttributeConfig();
                        if(oac != null){
                            oac.setaConfigId(occ.getConfigId());
                            operAccessDao.saveAttribute(oac);
                        }
                    }
                };
                ex.submit(ru);
            }catch (Exception e){
                log.info(e.getMessage());
            }finally {
                ex.shutdown();
            }
        }
        return n;
    }

    @Override
    public int updateOperAccess(OperAccessCoreConfig occ) {
        int n = 0;
        n = operAccessDao.updateOperAccess(occ);
        ExecutorService ex = Executors.newCachedThreadPool();
        if(n > 0){
            try {
                Runnable ru = new Runnable() {
                    @Override
                    public void run() {
                        OperExtendConfig oec = occ.getOperExtendConfig();
                        if (oec != null) {
                            oec.setConfigId(occ.getConfigId());
                            operAccessDao.updateOperExtend(oec);
                        }
                        OperMarkConfig omc = occ.getOperMarkConfig();
                        if (omc != null) {
                            omc.setConfigId(occ.getConfigId());
                            operAccessDao.updateOperMark(omc);
                        }
                        OperAttributeConfig oac = occ.getOperAttributeConfig();
                        if(oac != null){
                            oac.setaConfigId(occ.getConfigId());
                            operAccessDao.updateAttribute(oac);
                        }
                    }
                };
                ex.submit(ru);
            }catch (Exception e){
                log.info(e.getMessage());
            }finally {
                ex.shutdown();
            }
        }
        return n;
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

    @Override
    public int delOperAccessCoreConfig(String ids,int isabled) {

        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> list =  JavaBeanMap.getListByIds(ids);
        if(list != null && list.size() > 0){
            map.put("isabled",isabled);
            map.put("list",list);
            n = operAccessDao.delOperAccessCoreConfig(map);
        }
        return n;
    }
}
