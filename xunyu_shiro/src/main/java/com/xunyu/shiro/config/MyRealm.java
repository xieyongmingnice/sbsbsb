package com.xunyu.shiro.config;

import com.commons.core.util.RandomUtils;
import com.xunyu.shiro.ehcache.MyCacheManager;
import com.xunyu.shiro.pojo.UserInfo;
import com.xunyu.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义权限验证
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /** 
     * 权限认证 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
        // TODO Auto-generated method stub  
        //获取登录用户的信息,在认证时存储的是ShiroUser 所以得到的就是ShiroUser  
        //在其他地方也可通过SecurityUtils.getSubject().getPrincipals()获取用户信息  
       // ShiroUser sysUser =  (ShiroUser) principals.getPrimaryPrincipal();
        //权限字符串  
        List<String> permissions=new ArrayList<>();
        //从数据库中获取对应权限字符串并存储permissions  
          
        //角色字符串  
        List<String> roles=new ArrayList<>();  
        //从数据库中获取对应角色字符串并存储roles  
          
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);  
        simpleAuthorizationInfo.addRoles(roles);//角色类型  
        return simpleAuthorizationInfo;  
    }  
  
    /** 
     * 登录验证 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
            AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        UsernamePasswordToken token2 = (UsernamePasswordToken) token;
        String username = String.valueOf(token2.getUsername());
        String pwd = String.valueOf(token2.getPassword());
        Map<String,Object> map = new HashMap<String,Object>();
        UserInfo userInfo = null;
        /**
         * 通过userName在缓存中查找一遍，否则直接查数据库
         */
        MyCacheManager<String,UserInfo> cache = new MyCacheManager<String,UserInfo>();
        userInfo = cache.get(username+pwd);
        if (userInfo == null) {
            //查询数据库
            map.put("userName",username);
            userInfo = userService.getUserInfo(map);
            //做缓存
            cache.put(username+pwd,userInfo);

        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getName(), //用户名
                userInfo.getPwd(), //密码
                ByteSource.Util.bytes(userInfo.getName()+RandomUtils.generateMixString(4)),//salt=username+salt
                this.getName()  //realm name
        );
        //把用户放到session中
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("user",userInfo);
        return authenticationInfo;
    }  
  
      
}  