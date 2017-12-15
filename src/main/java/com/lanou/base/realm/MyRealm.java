package com.lanou.base.realm;

import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/11.
 */
@Service
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserMapper userMapper;

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        
        return null;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        //将表单输入的密码进行加密
        String newPassword = new Md5Hash(password).toString();
        User userByName = userMapper.findUserByName(username);
        if (userByName == null) {
            throw new UnknownAccountException("用户不存在");
        } else if (!userByName.getPassword().equals(newPassword)) {
            throw new IncorrectCredentialsException("密码错误");
        } else {
            return new SimpleAuthenticationInfo(username, password, getName());
        }


    }
}
