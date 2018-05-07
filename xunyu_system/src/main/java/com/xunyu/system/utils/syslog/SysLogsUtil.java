package com.xunyu.system.utils.syslog;

import com.commons.core.util.IpAdrressUtil;
import com.xunyu.model.crm.customer.CustomerModel;
import com.xunyu.model.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dth
 * @date 2018/5/4 9:25
 **/
public class SysLogsUtil {

    public int addSysLogs(LogService2 logService, User us, String operObj
            , String operType, HttpServletRequest request,String operText,CrmService crmService){
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable run = new Runnable() {//创建一个线程匿名内部类
            @Override
            public void run() {
                try {
                    CustomerModel ct = null;
                    com.xunyu.model.log.syslog.SysLogs sl = new com.xunyu.model.log.syslog.SysLogs();
                    sl.setOperName(us.getAccount());
                    if(us.getUserType() == 1){//表示客户（只有客户信息才有联系人这一项）
                        ct = crmService.getCusDetailFeign(us.getAccount());
                    }
                    sl.setOperIp(IpAdrressUtil.getIpAdrress(request));
                    sl.setOperObj(operObj);
                    sl.setOperType(operType);
                    sl.setOperTime(new Date());
                    sl.setOperPort("8005");
                    sl.setOperStatus(1);
                    if(ct != null) {
                        sl.setEnterContact(ct.getEnterContact());
                    }
                    sl.setOperText(operText);
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
