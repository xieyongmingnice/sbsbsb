package com.xunyu.shiro.config;

import com.commons.core.util.Base64Utils;
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
        String pwdAccount = Base64Utils.decoderX(String.valueOf(accountCredentials));
        String pwdUser = String.valueOf(token.getPassword());
        return equals(pwdUser,pwdAccount);


    }
}