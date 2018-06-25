package com.xunyu.sink;

import org.apache.flume.*;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义flume策略，把获取到日志写到指定的文件中
 * 打包后放到flume的解压目录中的lib下即可
 */
public class MySinks extends AbstractSink implements Configurable {  
    private static final Logger logger = LoggerFactory.getLogger(MySinks.class);  
    private static final String PROP_KEY_ROOTPATH = "fileName";  
    private String fileName;  
   
    @Override  
    public void configure(Context context) {  
        fileName = context.getString(PROP_KEY_ROOTPATH);  
    }  
   
    @Override  
    public Status process() throws EventDeliveryException {  
        Channel ch = getChannel();  
        //get the transaction  
        Transaction txn = ch.getTransaction();
        FileOutputStream fos = null;
        BufferedOutputStream buff = null;
        Event event =null;  
        //begin the transaction  
        txn.begin();  
        while(true){  
            event = ch.take();  
            if (event!=null) {  
                break;  
            }  
        }
        try {
            logger.debug("Get event.");
            String body = new String(event.getBody());
            StringBuffer res = new StringBuffer();
            String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            res.append(currTime).append("#").append(body).append("\r\n");
            File file = new File(fileName);
            try {
                fos = new FileOutputStream(file, true);
                buff = new BufferedOutputStream(fos,1024);
                String res2 = new String(res.toString().getBytes(),"utf-8");
                buff.write(res2.getBytes());
                buff.flush();
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  catch (IOException e) {
                e.printStackTrace();
            }
            txn.commit();  
            return Status.READY;  
        } catch (Throwable th) {  
            txn.rollback();  
   
            if (th instanceof Error) {  
                throw (Error) th;  
            } else {  
                throw new EventDeliveryException(th);  
            }  
        } finally {
            if(buff != null) {
                try {
                    buff.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            if(fos != null) {
                try {
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(txn != null){
                try{
                    txn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
             }
            }

        }  
    }  
} 