package com.xunyu.shiro.config;

import com.commons.core.util.MD5Utils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义编解码
 * Description: 告诉shiro如何验证加密密码，通过SimpleCredentialsMatcher或HashedCredentialsMatcher 
 * @Author: dth
 * @Create Date: 2018-4-18
 */
  
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Object accountCredentials = getCredentials(info);
        String userName = String.valueOf(token.getUsername());
        String pwdType = String.valueOf(token.getPassword());// 判断一下密码是否是用户输入的，还是JCIS传过来的
        if (pwdType.length() == 32) {
            return equals(pwdType, accountCredentials); //密码长度=32位，说明是md5加密过，是从xx传进来的 32位加密。
        }
        String pwdUser = MD5Utils.getMD5(String.valueOf(token.getPassword()));
        return equals(pwdUser, accountCredentials);


    }
}