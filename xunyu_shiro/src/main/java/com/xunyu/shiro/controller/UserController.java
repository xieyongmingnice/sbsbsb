package com.xunyu.shiro.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultTypeEnum;
import com.commons.core.util.StringUtils2;
import com.xunyu.shiro.config.SessionDao;
import com.xunyu.shiro.pojo.user.User;
import com.xunyu.shiro.redis.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RestController("/")
public class UserController {

    @Autowired
    RedisUtil redisUtil;
    /**
     * 登录方法
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String,Object> ajaxLogin(User user, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> map = new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassWord());
        try {
            subject.login(token);
            map.put("sessionId", subject.getSession().getId());
            user = (User)subject.getSession().getAttribute("user");
            map.put("message", "登录成功");
            map.put("user",user);
        } catch (IncorrectCredentialsException e) {
            map.put("message", "密码错误");
            e.printStackTrace();
        } catch (LockedAccountException e) {
            map.put("message", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
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
        map.put("code", "413");
        map.put("msg", "未登录");
        return map;
    }

    /**
     * 根据sessionID获取用户信息
     */
    @RequestMapping(value = "getUserBySessionId",method = RequestMethod.POST)
    public Result<User> getUserBySessionIdData(String sessionId,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
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
        response.setHeader("Access-Control-Allow-Origin", "*");
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
}
