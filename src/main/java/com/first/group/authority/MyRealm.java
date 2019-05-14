package com.first.group.authority;

import com.first.group.entity.Authority;
import com.first.group.entity.RoleAuthority;
import com.first.group.entity.UserInformation;
import com.first.group.entity.UserRoles;
import com.first.group.service.RoleAuthorityService;
import com.first.group.service.UserRoleService;
import com.first.group.service.UserService;
import com.first.group.util.PassWordToHash;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authc.AuthenticationException;
import sun.applet.Main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
  private UserService userService;
    @Autowired
  private UserRoleService userRoleService;
    @Autowired
  private RoleAuthorityService roleAuthorityService;



    private static final transient Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
    * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("----------doGetAuthorizationInfo方法被调用----------");
        String username = (String) getAvailablePrincipal(principals);
        UserInformation u = new UserInformation();
        u.setUserid(username);

        //通过用户名从数据库获取权限字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserInformation userInformation = userService.findUser(u);
        UserRoles roles = userRoleService.findOne(u.getUserid());
        //角色
        if(roles!=null){
            Set<String> r = new HashSet<String>();
            r.add(roles.getName());
            log.info(roles.getName());
            info.setRoles(r);

            List<RoleAuthority> authoritys = roleAuthorityService.findByRole(roles.getRoleid());
            if(authoritys!=null&&!authoritys.isEmpty()){
                //权限
                Set<String> s = new HashSet<String>();
                for(RoleAuthority r_au:authoritys){
                    Authority au = r_au.getAuthority();
                    log.info(au.getName());
                    s.add(au.getName());
                }
                info.setStringPermissions(s);
            }
        }
        return info;
    }
    /**
     * 在这个方法中，进行身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (
            AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        log.info("username:"+username);
        //密码
        String password = new String((char[])token.getCredentials());
        PassWordToHash p = new PassWordToHash();
        String SHAPassword = p.passwordToHash(password.trim());
        log.info("password:"+password);
        //从数据库获取用户名密码进行匹配
        UserInformation userInformation = new UserInformation();
        userInformation.setUserid(username);
        UserInformation findUser = userService.findUser(userInformation);
        if(findUser!=null){
            log.info(findUser.getUserid());
            log.info(findUser.getPassword());
            String real_username = findUser.getUserid().trim();
            String real_password = findUser.getPassword().trim();
            if(!real_username.equals(username)){
                log.info(real_username+"hahha");
                throw new UnknownAccountException();
            }
            if(!real_password.equals(SHAPassword)){
                log.info(SHAPassword+"加密");
                log.info(real_password+"hahha");
                throw new IncorrectCredentialsException();
            }
        }else {
            log.info("用户不存在");
            return null;
        }


        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());
        log.info(aInfo.toString()+"权限");
        return aInfo;
    }

}
