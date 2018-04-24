package com.xunyu.shiro.config;

import com.xunyu.config.redis.RedisUtil;
import com.xunyu.config.redis.SessionDao;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.filter.DelegatingFilterProxy;
import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置
 */

@Configuration
public class ShiroConfig {

    @Bean(name = "shiroEhcacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        LifecycleBeanPostProcessor lifecycleBeanPostProcessor = new LifecycleBeanPostProcessor();
        return lifecycleBeanPostProcessor;
    }

    /**
     * session 验证调度器
     * 设置每小时清除一次失效的session
     * @return
     */
    @Bean(name = "sessionValidationScheduler")
    public ExecutorServiceSessionValidationScheduler getExecutorServiceSessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler scheduler = new ExecutorServiceSessionValidationScheduler();
        scheduler.setInterval(100000);
        return scheduler;
    }

   /* @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于md5(md5(""));
        return hashedCredentialsMatcher;
    }*/

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(com.xunyu.shiro.config.MyRealm myRealm, DefaultWebSessionManager defaultWebSessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        //defaultWebSecurityManager.setCacheManager(getEhCacheManager());
        defaultWebSecurityManager.setSessionManager(defaultWebSessionManager);
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        return defaultWebSecurityManager;
    }

    @Bean(name = "rememberMeCookie")
    public SimpleCookie rememberMeCookie() {
        // 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // <!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     *
     * @return
     */
    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }


    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public com.xunyu.shiro.config.MyRealm myRealm() {
        com.xunyu.shiro.config.MyRealm myRealm = new com.xunyu.shiro.config.MyRealm();
        //开启本地缓存
        myRealm.setCacheManager(getEhCacheManager());
        //验证
        com.xunyu.shiro.config.CustomCredentialsMatcher cu = new com.xunyu.shiro.config.CustomCredentialsMatcher();
        myRealm.setCredentialsMatcher(cu);
        return myRealm;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(defaultWebSecurityManager);
        return aasa;
    }


    @Bean(name = "sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager(SessionDao sessionDao) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //定义的是全局的session会话超时时间
        sessionManager.setGlobalSessionTimeout(100000);
//      //删除所有无效的Session对象，此时的session被保存在了内存里面
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationInterval(100000);
        //定义要使用的无效的Session定时调度器
        sessionManager.setSessionValidationScheduler(getExecutorServiceSessionValidationScheduler());
        //需要让此session可以使用该定时调度器进行检测
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //设置SessionIdCookie 导致认证不成功，不从新设置新的cookie,从sessionManager获取sessionIdCookie
        //sessionManager.setSessionIdCookie(simpleIdCookie());
        //定义sessionIdCookie模版可以进行操作的启用
        //sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.getSessionIdCookie().setName("session-z-id");
        sessionManager.getSessionIdCookie().setPath("/");
        sessionManager.getSessionIdCookie().setMaxAge(60*60*24*7);
        //定义Session可以进行序列化的工具类
        sessionManager.setSessionDAO(sessionDao);
        Collection<SessionListener> c=new ArrayList<>();
        c.add(new com.xunyu.shiro.config.MyShiroSessionListener());
        sessionManager.setSessionListeners(c);

        return sessionManager;
    }



    @Bean(name = "filterRegistrationBean1")
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DelegatingFilterProxy(
                "shiroFilter"));
        filterRegistrationBean
                .addInitParameter("targetFilterLifecycle", "true");
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/");
        return filterRegistrationBean;
    }

/**
 * ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。
 * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
 */

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
        @Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, Filter> filters = new LinkedHashMap<>();
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/login");
        shiroFilterFactoryBean.setFilters(filters);
        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
        filterChainDefinitionManager.put("/logout", "anon");
        //filterChainDefinitionManager.put("/user/**", "authc,roles[ROLE_USER]");//用户为ROLE_USER 角色可以访问。由用户角色控制用户行为。
        //filterChainDefinitionManager.put("/api/**", "authc");
        filterChainDefinitionManager.put("/**", "anon");

        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/unauth");
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
        return shiroFilterFactoryBean;
    }


}
