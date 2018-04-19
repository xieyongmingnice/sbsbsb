package com.xunyu.shiro.controller;

import com.commons.core.message.Result;
import com.xunyu.shiro.config.SessionDao;
import com.xunyu.shiro.pojo.UserInfo;
import com.xunyu.shiro.redis.RedisUtil;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @author dth
 * @date 2018/4/18 14:16
 **/
@RestController
public class UserController {

    @Autowired
    RedisUtil redisUtil;
    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.GET)
    public Map<String,Object> ajaxLogin(UserInfo userInfo, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getName(), userInfo.getPwd());
        try {
            subject.login(token);
            map.put("sessionId", subject.getSession().getId());
            map.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
            e.printStackTrace();
        } catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
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
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }

    /**
     * 根据sessionID获取用户信息
     */
    @RequestMapping("getUserBySessionId")
    public Result<UserInfo> getUserBySessionIdData(String sessionId){

        UserInfo userInfo = null;
        Result<UserInfo> res = new Result<UserInfo>();
        byte[] session = (byte[])redisUtil.get(sessionId);
        if(session != null) {
            Session se = new SessionDao().byteToSession(session);
            userInfo = (UserInfo) se.getAttribute("user");
            res.setMessage("success");
            res.setRes(userInfo);
            res.setCode("200");
        }else{
            res.setRes(null);
            res.setCode("403");
            res.setMessage("未获得用户信息，原因：session失效了");
        }
        return res;
    }

    @RequestMapping("distorySession")
    public String destorySessionData(String sessionId){
        //退出删除当前会话中的用户信息
        try {
            redisUtil.remove(sessionId);
            byte[] session = (byte[])redisUtil.get(sessionId);
            if(session != null) {
                Session se = new SessionDao().byteToSession(session);
                se.removeAttribute("user");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
