package com.commons.core.exception;

import com.commons.core.message.Result;
import org.slf4j.Logger;

public class ExceptionCatch {

    public static void exceptionCatch(Result res, Logger log, Exception e){
        res.setCode("500");
        res.setMessage("系统异常");
        log.info(e.getMessage());
    }
}
