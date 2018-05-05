package com.xunyu.config.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Autor dth
 * Description: 全局异常捕获
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 日志记录工具
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,String> handleGlobalException(HttpServletRequest req, Exception ex) {

        //打印堆栈日志到日志文件中
        Map<String,String> res = new HashMap<String,String>();
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ex.printStackTrace(new java.io.PrintWriter(buf, true));
        String  expMessage = buf.toString();
        try {
            res.put("code","500");
            res.put("message","系统异常");
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //记录到日志
        log.error("GlobalExceptionHandler,捕获异常:"+ ex.getMessage() + ";eString:" + expMessage);

        return res;
    }
}