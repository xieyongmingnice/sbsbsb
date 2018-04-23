package com.xunyu.shiro.controller;

import com.commons.core.message.Result;
import com.xunyu.shiro.pojo.user.User;
import com.xunyu.shiro.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author dth
 * @date 2018/4/23 17:56
 **/
@RestController("/api/user")
public class UserInfoController {

    /**
     * 注入
     */
    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public Result<User> addUserData(User user, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result<User> res = new  Result<User>();
        int flag = 0;
        try{
            user.setIsabled(1);//显示状态
            user.setUserCreateTime(new Date());
            flag = userService.addUser(user);
            if(flag > 0){
               res.setCode("200");
               res.setMessage("success");
               res.setRes(user);
            }else{
                res.setCode("412");
                res.setMessage("系统正忙，请稍后再试");
                res.setRes(user);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("添加失败,请仔细检查提交的数据！");
            e.printStackTrace();
        }

        return res;
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public Result<User> updateUserData(HttpServletResponse response,User user){
        response.setHeader("Access-Control-Allow-Origin", "*");

        Result<User> res = new Result<User>();
        int flag = 0;
        try {
            flag = userService.updateUser(user);
            if(flag > 0){
                res.setCode("200");
                res.setMessage("success");
                res.setRes(user);
            }else{
                res.setCode("412");
                res.setMessage("系统正忙~，请稍后再试");
                res.setRes(user);
            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("修改失败,请仔细检查提交的数据！");
            e.printStackTrace();
            e.printStackTrace();
        }
        return res;
    }
}
