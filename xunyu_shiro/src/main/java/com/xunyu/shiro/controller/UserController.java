package com.xunyu.shiro.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultTypeEnum;
import com.commons.core.util.MD5Utils;
import com.commons.core.util.StringUtils2;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.config.redis.SessionDao;
import com.xunyu.model.user.User;
import com.xunyu.shiro.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/18 14:16
 **/
@RestController("/")
public class UserController {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserService userService;
    /**
     * 登录方法
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String,Object> ajaxLogin(com.xunyu.model.user.User user, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassWord());
        try {
            subject.login(token);
            map.put("sessionId", subject.getSession().getId());
            user = (User)subject.getSession().getAttribute("user");
            map.put("code","200");
            map.put("message", "登录成功");
            map.put("user",user);
        } catch (IncorrectCredentialsException e) {
            map.put("code","413");
            map.put("message", "密码错误");
            e.printStackTrace();
        } catch (LockedAccountException e) {
            map.put("code","412");
            map.put("message", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            map.put("code","404");
            map.put("message", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    public Map<String,Object> unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "404");
        map.put("message", "未登录");
        return map;
    }

    /**
     * 根据sessionID获取用户信息
     */
    @RequestMapping(value = "getUserBySessionId",method = RequestMethod.POST)
    public Result<User> getUserBySessionIdData(String sessionId,HttpServletResponse response){

        User user = null;
        Result<User> res = new Result<User>();
        if(StringUtils2.isNotEmpty(sessionId)) {
            byte[] session = (byte[]) redisUtil.get(sessionId);
            if (session != null) {
                Session se = new SessionDao().byteToSession(session);
                if(se != null) {
                    user = (User) se.getAttribute("user");
                    res.setMessage("success");
                    res.setRes(user);
                    res.setCode("200");
                }else{
                    res.setCode("403");
                    res.setMessage("未获得用户信息，原因：session失效了");
                    redisUtil.remove(sessionId);//删除失效的session
                }
            } else {
                res.setCode("403");
                res.setMessage("未获得用户信息，原因：session失效了");
                redisUtil.remove(sessionId);//删除失效的session
            }
        }else{
            res.setCode("413");
            res.setMessage("sessionId不能为空");
        }
        return res;
    }

    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public Result<String> destorySessionData(String sessionId,HttpServletResponse response){

        //退出删除当前会话中的用户信息
        Result<String> res = new Result<String>();

        try {
            redisUtil.remove(sessionId);
            byte[] session = (byte[])redisUtil.get(sessionId);
            if(session != null) {
                Session se = new SessionDao().byteToSession(session);
                se.removeAttribute("user");
            }
            res.setCode("200");
            res.setMessage(String.valueOf(ResultTypeEnum.SUCCESS));
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 添加用户信息
     */
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Result<User> addUserData(User user, HttpServletResponse response){

        Result<User> res = new  Result<User>();
        int flag = 0;
        boolean status = redisUtil.sessionStatus(user.getSessionId());
        Map<String,Object> map = new HashMap<String,Object>();
        if(!status){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
        if(StringUtils2.isNotEmpty(user.getAccount()) && StringUtils2.isNotEmpty(user.getPassWord())) {
            try {
                //先判断账号是否存在
                map.put("account",user.getAccount());
                User user2 = userService.getUserInfo(map);
                if(user2 == null) { //说明该账号不存在，可以添加
                    user.setIsabled(1);//显示状态
                    user.setUserCreateTime(new Date());
                    user.setPassWord(MD5Utils.getMD5(user.getPassWord()));
                    flag = userService.addUser(user);
                    if (flag > 0) {
                        res.setCode("200");
                        res.setMessage("success");
                        res.setRes(user);
                    } else {
                        res.setCode("412");
                        res.setMessage("系统正忙，请稍后再试");
                        res.setRes(user);
                    }
                }else{
                    res.setCode("413");
                    res.setMessage("该账号已存在");
                }
            } catch (Exception e) {
                res.setCode("500");
                res.setMessage("添加失败,请仔细检查提交的数据！");
                e.printStackTrace();
            }
        }else{
            res.setCode("413");
            res.setMessage("账号或密码不能为空");
            res.setRes(user);
        }

        return res;
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public Result<User> updateUserData(HttpServletResponse response,User user){


        Result<User> res = new Result<User>();
        int flag = 0;
        boolean status = redisUtil.sessionStatus(user.getSessionId());
        if(!status){
            res.setCode("404");
            res.setMessage("当前会话失效，请跳转到登录页");
            return res;
        }
            try {
                if(StringUtils2.isNotEmpty(user.getPassWord())){
                    user.setPassWord(MD5Utils.getMD5(user.getPassWord()));
                }
                flag = userService.updateUser(user);
                if (flag > 0) {
                    res.setCode("200");
                    res.setMessage("success");
                    res.setRes(user);
                } else {
                    res.setCode("412");
                    res.setMessage("系统正忙~，请稍后再试");
                    res.setRes(user);
                }
            } catch (Exception e) {
                res.setCode("500");
                res.setMessage("修改失败,请仔细检查提交的数据！");
                e.printStackTrace();
                e.printStackTrace();
            }

        return res;
    }

    /**
     * 查询用户详情接口
     */
    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    public Result<User> getUserInfoData(HttpServletResponse response,User user) {


        Result<User> res = new Result<User>();
        try{
            if (StringUtils2.isNotEmpty(user.getAccount())) {
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("account",user.getAccount());
                user = userService.getUserInfo(map);
                res.setCode("200");
                res.setMessage("success");
                res.setRes(user);

            }
        }catch (Exception e){
            res.setCode("500");
            res.setMessage("系统异常");
            e.printStackTrace();
        }
        return res;
    }

}
