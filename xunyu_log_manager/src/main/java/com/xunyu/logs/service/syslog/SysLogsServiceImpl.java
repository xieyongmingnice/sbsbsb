package com.xunyu.logs.service.syslog;

import com.xunyu.logs.dao.syslog.SysLogsDaoImpl;
import com.xunyu.model.log.syslog.SysLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable run = new Runnable() {//创建一个线程匿名内部类
            @Override
            public void run() {
                try {
                    sysLogsDaoImpl.addSysLog(sl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        pool.submit(run);
        pool.shutdown();//执行完之后释放该线程
        return n;
    }
}