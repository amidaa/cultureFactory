package com.first.group.authority;

import com.first.group.util.PassWordToHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class Tutorial {
    private final static Logger logger = LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {
        logger.info("shiro");
        //1. 这里的SecurityManager是org.apache.shiro.mgt.SecurityManager，而不是java.lang.SecurityManager
        // 加载配置文件
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("src/main/resources/shiro.ini");

        //2.解析配置文件，并且返回一些SecurityManger实例
//        SecurityManager securityManager = factory.getInstance();
//
//        //3.设置SecurityManager到静态内存区，单例模式
//        SecurityUtils.setSecurityManager(securityManager);


        // 安全操作
        Subject currentUser = SecurityUtils.getSubject();


//        UsernamePasswordToken token = new UsernamePasswordToken("test@shiro.com","123456");
//        token.setRememberMe(true);//是否记住用户

        // 在应用的当前会话中设置属性
//        Session session =  currentUser.getSession();
//        session.setAttribute("key","value");

        //当前我们的用户是匿名的用户，我们尝试进行登录，
        if (!currentUser.isAuthenticated()){
            PassWordToHash passWordToHash = new PassWordToHash();
            UsernamePasswordToken token = new UsernamePasswordToken("10020",passWordToHash.passwordToHash("123456"));

            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);

            //尝试进行登录用户，如果登录失败了，我们进行一些处理

            try{
                currentUser.login(token);

                //当我们获登录用户之后
                logger.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");


                // 查看用户是否有指定的角色
                if ( currentUser.hasRole( "client" ) ) {
                    logger.info("Look is in your role" );
                } else {
                    logger.info( "....." );
                }

                // 查看用户是否有某个权限
                if ( currentUser.isPermitted( "look:desk" ) ) {
                    logger.info("You can look.  Use it wisely.");
                } else {
                    logger.info("Sorry, you can't look.");
                }

                if ( currentUser.isPermitted( "winnebago:drive:eagle5" ) ) {
                    logger.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'.  " +
                            "Here are the keys - have fun!");
                } else {
                    logger.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
                }

                //登出

                currentUser.logout();

            }
            catch ( UnknownAccountException uae ) {
                logger.info("account doesn't exit!");
            } catch ( IncorrectCredentialsException ice ) {
                logger.info("wrong password!");
                //密码不正确
            } catch ( LockedAccountException lae ) {
                logger.info("用户被锁定!");
                //用户被锁定了
            } catch ( AuthenticationException ae ) {
                logger.info("无法判断!");
                //无法判断的情形
            }

        }
    }
}
