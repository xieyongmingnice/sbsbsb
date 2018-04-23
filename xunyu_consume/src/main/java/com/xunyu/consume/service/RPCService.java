package com.xunyu.consume.service;

import com.commons.core.message.Result;
import com.xunyu.consume.pojo.User;
import com.xunyu.model.user.UserModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author dth
 * @date 2018/4/16 11:55
 **/
@FeignClient("xunyu-provider")  //指定服务
public interface RPCService {

    /**
     * 跨服务获取数据
     */
    //指定服务中的哪个方法
    @RequestMapping(value = "/pro/listUser", method = RequestMethod.POST, consumes = "application/json")
    Result<List<User>> listUserOther(@RequestBody UserModel userModel);


}
