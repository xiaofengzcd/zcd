package com.zcd.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author zcd
 * @description:
 * @create 2020/3/20 19:52
 */
@Configuration
public class ShiroConfig {
    @Bean
    //qualifier 合格者   通过这个标示，表明了哪个实现类才是我们所需要的
    // 这里我猜测大概就是可能有很多个安全管理器或者realm啥的,用这个@qualifier具体指定某个bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
         LinkedHashMap<String , String> filterMap = new LinkedHashMap<>();


        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联userRealm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
