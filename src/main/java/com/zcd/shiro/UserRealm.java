package com.zcd.shiro;

import com.zcd.model.User;
import com.zcd.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zcd
 * @description:
 * @create 2020/3/20 22:41
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService iUserService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("认证");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("授权");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        final User user = iUserService.getUserByName(userToken.getUsername());

        if (user == null){
            return  null;
        }

        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
