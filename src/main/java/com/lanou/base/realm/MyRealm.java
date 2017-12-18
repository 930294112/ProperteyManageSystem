package com.lanou.base.realm;

import com.lanou.sys.role.bean.Role;
import com.lanou.sys.user.bean.User;
import com.lanou.sys.user.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.roles;

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
        String username = (String) principalCollection.getPrimaryPrincipal();

        //2.从数据库中获取该用户的所有角色和权限

        //============>模拟数据<===================
        User user =userMapper.findUserByName(username);
          Role role = user.getRole();

        List<String> roleList = new ArrayList<String>();
        roleList.add(role.getName());


        List<String> perList = new ArrayList<String>();
        perList.add("user:create");
        perList.add("user:query");


        //============>模拟结束<===================

        //3.将获取的角色和权限统一起来
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(perList);

        return info;

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
