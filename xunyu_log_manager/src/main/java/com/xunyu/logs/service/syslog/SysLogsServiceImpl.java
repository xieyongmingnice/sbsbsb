package com.xunyu.logs.service.syslog;

import com.commons.core.util.RandomUtils;
import com.commons.core.util.StringUtils2;
import com.xunyu.logs.dao.syslog.SysLogsDaoImpl;
import com.xunyu.model.log.syslog.SysLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/5/3 17:37
 **/
@Service
public class SysLogsServiceImpl implements SysLogsService {

    @Autowired
    private SysLogsDaoImpl sysLogsDaoImpl;

    /**
     * 增加系统日志
     * @param sl
     * @return
     */
    @Override
    public int addSysLog(SysLogs sl) {
        int n = 0;
        n = sysLogsDaoImpl.addSysLog(sl);
        return n;
    }

    @Override
    public int sysLogsCount(Map<String, Object> map) {
        return sysLogsDaoImpl.sysLogsCount(map);
    }

    @Override
    public List<SysLogs> sysLogsList(Map<String, Object> map) {
        return sysLogsDaoImpl.sysLogsList(map);
    }

    @Override
    public SysLogs getSysLogsDetail(Map<String, Object> map) {
        return sysLogsDaoImpl.getSysLogsDetail(map);
    }

    @Override
    public int delSysLogs(String ids) {
        int n = 0;
        if(StringUtils2.isNotEmpty(ids)){
            List<String> list = new ArrayList<String>();
            String[] idsStr = ids.split(",");

            for (int i = 0; i < idsStr.length; i++) {
                if(RandomUtils.isInteger(idsStr[i])){
                    list.add(idsStr[i]);
                }else{
                    continue;
                }
            }
            n = sysLogsDaoImpl.delSysLogs(list);
        }
        return n;
    }
}
