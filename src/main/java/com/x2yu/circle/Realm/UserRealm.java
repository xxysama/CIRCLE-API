package com.x2yu.circle.Realm;

import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.service.ISecUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: x2yu
 * @Date: 2020/2/9 17:20
 * @Describe：Shiro用户认证以及授权类
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    ISecUserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权方法");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // simpleAuthorizationInfo.addStringPermission("user:add");

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证方法");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //链接查询数据库用户
//        SecUser user = userServic


        //密码认证
        return new SimpleAuthenticationInfo("",'0',"");
    }
}
