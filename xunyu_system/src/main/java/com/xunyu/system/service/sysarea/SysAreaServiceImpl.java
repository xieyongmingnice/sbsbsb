package com.xunyu.system.service.sysarea;

import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.system.dao.sysarea.SysAreaDaoImpl;
import com.xunyu.system.pojo.sysarea.SysArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/7 17:02
 **/
@Service
public class SysAreaServiceImpl implements SysAreaService{

    @Autowired
    private SysAreaDaoImpl sysAreaDaoImpl;

    @Override
    public int addSysAreaConfig(SysArea sa) {
        return sysAreaDaoImpl.addSysAreaConfig(sa);
    }

    @Override
    public int updateSysAreaConfig(SysArea sa) {
        return sysAreaDaoImpl.updateSysAreaConfig(sa);
    }

    @Override
    public SysArea getSysAreaConfig(Map<String, Object> map) {
        return sysAreaDaoImpl.getSysAreaConfig(map);
    }

    @Override
    public int sysAreaConfigCount(Map<String, Object> map) {
        return sysAreaDaoImpl.sysAreaConfigCount(map);
    }

    @Override
    public List<SysArea> sysAreaConfigList(Map<String, Object> map) {
        return sysAreaDaoImpl.sysAreaConfigList(map);
    }

    @Override
    public int delSysAreaConfig(String ids2) {
        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();

        if(StringUtils2.isNotEmpty(ids2)){
            String[] ids = ids2.split(",");
            String[] array = new String[ids.length];
            for (int i = 0; i < ids.length; i++) {
                if(RandomUtils.isInteger(ids[i])){
                    array[i] = ids[i];

                }else{
                    continue;
                }
            }
            map.put("isabled",0);
            map.put("array",array);
            n = sysAreaDaoImpl.delSysAreaConfig(map);
        }
        return n;
    }
}
