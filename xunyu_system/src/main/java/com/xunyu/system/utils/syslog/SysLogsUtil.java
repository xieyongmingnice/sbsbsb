package com.xunyu.system.utils.syslog;

import com.xunyu.model.user.User;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dth
 * @date 2018/5/4 9:25
 **/
public class SysLogsUtil {

    public int addSysLogs(LogService2 logService, User us, String operObj, String operType){
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable run = new Runnable() {//创建一个线程匿名内部类
            @Override
            public void run() {
                try {
                    com.xunyu.model.log.syslog.SysLogs sl = new com.xunyu.model.log.syslog.SysLogs();
                    sl.setOperName(us.getAccount());
                    sl.setOperIp("127.0.0.1");
                    sl.setOperObj(operObj);
                    sl.setOperType(operType);
                    sl.setOperTime(new Date());
                    logService.addSysLog(sl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        pool.submit(run);
        pool.shutdown();//执行完之后释放该线程
        return 1;
    }

    /**
     * 构造单例模式
     */
    private SysLogsUtil(){}

    private static class LazyHolder {
        private static final SysLogsUtil INSTANCE = new SysLogsUtil();
    }
    public static final SysLogsUtil getInstance() {
        return LazyHolder.INSTANCE;
    }
}
