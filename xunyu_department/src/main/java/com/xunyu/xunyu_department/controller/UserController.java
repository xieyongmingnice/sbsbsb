package com.xunyu.xunyu_department.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.xunyu.config.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author xym
 * @description
 * @date 2018/4/25 16:57
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RedisUtil redisUtil;

    private Result checkLogin(Result r, String sessionId){
        boolean flag = redisUtil.sessionStatus(sessionId);
        if (!flag) {
            r.setCode(ResultMessage.Code.NOT_FOUND);
            r.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return r;
    }

    private void catchExcpetion(Exception e,Result result){
        result.setCode(ResultMessage.Code.ERROR);
        result.setMessage(ResultMessage.Message.ERROR);
        logger.info("系统异常");
        e.printStackTrace();
    }

    private void operationSuccess(Result result){
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
    }

}
