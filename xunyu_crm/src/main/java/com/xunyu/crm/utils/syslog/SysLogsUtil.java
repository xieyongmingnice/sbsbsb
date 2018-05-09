package com.xunyu.crm.utils.syslog;

import com.commons.core.util.IpAdrressUtil;
import com.xunyu.config.utils.ServicePortUtil;
import com.xunyu.crm.pojo.customer.CustomerTab;
import com.xunyu.crm.service.customer.CustomerService;
import com.xunyu.model.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dth
 * @date 2018/5/4 9:25
 **/
public class SysLogsUtil {

    /**
     *
     * @param logService
     * @param us  用户对象
     * @param operObj 操作对象
     * @param operType 操作类型
     * @param request
     * @param operText  操作说明
     * @param crmService
     * @param status   操作状态 1成功  2失败
     * @return
     */
    public int addSysLogs(LogService2 logService, User us, String operObj
            , String operType, HttpServletRequest request, String operText, CustomerService crmService, int status){
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable run = new Runnable() {//创建一个线程匿名内部类
            @Override
            public void run() {
                try {
                    CustomerTab ct = null;
                    com.xunyu.model.log.syslog.SysLogs sl = new com.xunyu.model.log.syslog.SysLogs();
                    sl.setOperName(us.getAccount());
                    if(us.getUserType() == 2){//表示客户（只有客户信息才有联系人这一项）
                        Map<String,Object> map = new HashMap<String,Object>();
                        map.put("customerAccount",us.getAccount());
                        ct = crmService.getCustomerTabDetail(map);
                    }
                    sl.setOperIp(IpAdrressUtil.getIpAdrress(request));
                    sl.setOperObj(operObj);
                    sl.setOperType(operType);
                    sl.setOperTime(new Date());
                    sl.setOperPort(ServicePortUtil.getPort());
                    sl.setOperStatus(status);
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
