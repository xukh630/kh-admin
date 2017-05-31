package com.kh.admin.api.shiro.realm;


import com.kh.admin.common.utils.DateUtil;
import com.kh.admin.model.LpUser;
import com.kh.admin.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 项目：liquidator-platform-admin
 * 包名：com.fshows.liquidator.platform.admin.config.shiro.realm
 * 功能：
 * 时间：2016-08-19
 * 作者：呱牛
 */
public class SecurityRealm extends AuthorizingRealm {

    /*@Resource
    private UserServiceImpl userService;*/

    /**
     * 认证
     *
     * @param authToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        String username = (String) authToken.getPrincipal();

        /*LpUser user = userService.findOneByUsername(username);

        if (user == null || user.getStatus() == 0) {

            throw new UnknownAccountException();//没找到帐号
        } else if (user.getStatus() == 2) {

            Long timeOut = DateUtil.getNow() - user.getLockedTime();
            if (timeOut < 1800000L) {
                throw new LockedAccountException();//被锁定
            }
        }

        // 获得session对象
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("activityUser", user);

        return new SimpleAuthenticationInfo(
                username,
                user.getPassword(), //加密密码
//                new Md5Hash(user.getPassword(), user.getSalt()).toString(), //密码
                ByteSource.Util.bytes(user.getSalt()), //salt
                getName()  //realm name
        );*/

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo();

        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     *
     * @param principals
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(userService.findRoles(username));
//        authorizationInfo.setStringPermissions(userService.findPermissions(username));

        return authorizationInfo;
    }
}
