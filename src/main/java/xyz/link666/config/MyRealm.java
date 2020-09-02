package xyz.link666.config;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.link666.pojo.User;
import xyz.link666.user.service.UserService;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/9/2 18:05
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;


    /**授权
     * @param principals 角色
     * @return SimpleAuthorizationInfo类型 简单授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        info.addRole(user.getRole());
        System.out.println(user.getRole());
        return info;
    }

    /**
     * 认证
     * @param authenticationToken 默认
     * @return AuthenticationInfo 认证信息
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userService.selectUserByUsername(token.getUsername());
        if(user == null){
            return null;                //这里自动抛出UnknownAccountException异常，即认为用户名不正确
        }

        //密码认证由shiro去做
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
