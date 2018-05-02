package com.xunyu.system.service.errcode;

import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.system.dao.errcode.ErrCodeDaoImpl;
import com.xunyu.system.pojo.errcode.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/2 16:14
 **/
@Service
public class ErrorCodeServiceImpl implements ErrorCodeService {
    @Autowired
    private ErrCodeDaoImpl errCodeDaoImpl;

    @Override
    public int addErrCodeConfig(ErrorCode ec) {
        return errCodeDaoImpl.addErrCodeConfig(ec);
    }

    @Override
    public int updateErrCodeConfig(ErrorCode ec) {
        return errCodeDaoImpl.updateErrCodeConfig(ec);
    }

    @Override
    public int delErrCodeConfig(String errIds) {
        int n = 0;
        Map<String,Object> map = new HashMap<String,Object>();

        if(StringUtils2.isNotEmpty(errIds)){
            String[] ids = errIds.split(",");
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
            n = errCodeDaoImpl.delErrCodeConfig(map);
        }
        return n;
    }

    @Override
    public ErrorCode getErrCodeConfigDetail(Map<String, Object> map) {
        return errCodeDaoImpl.getErrCodeConfigDetail(map);
    }

    @Override
    public int errCodeConfigCount(Map<String, Object> map) {
        return errCodeDaoImpl.errCodeConfigCount(map);
    }

    @Override
    public List<ErrorCode> errCodeConfigList(Map<String, Object> map) {
        return errCodeDaoImpl.errCodeConfigList(map);
    }
}
