package com.xunyu.provider.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultTypeEnum;
import com.xunyu.entity.User;
import com.xunyu.model.user.UserModel;
import com.xunyu.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/11 15:17
 **/
@RestController
@RequestMapping("/pro/")
public class UserController {
    /**
     * 注入service层
     */
    @Autowired
    private UserService userService;

    @RequestMapping(value = "listUser", method = RequestMethod.POST)
    public Result<List<User>> listUserData(@RequestBody UserModel userModel) {
        Result<List<User>> res = new Result<List<User>>();
        Map<String, Object> map = new HashMap<String, Object>();
        if (userModel != null) {
            map.put("startRow", userModel.getStartRows());
            map.put("endRow", userModel.getEndRows());
            try {
                List<User> list = userService.listUser(map);
                res.setCode("200");
                res.setMessage(ResultTypeEnum.SUCCESS.toString());
                res.setRes(list);
            } catch (Exception e) {
                res.setCode("500");
                res.setMessage(String.valueOf(ResultTypeEnum.SYS_ERR));
                e.printStackTrace();
            }
        }
        return res;
    }

}
