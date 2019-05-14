package com.first.group.serviceImpl;

import com.first.group.dao.UserInformationMapper;
import com.first.group.entity.UserInformation;
import com.first.group.service.UserService;
import com.first.group.util.PassWordToHash;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInformationMapper userInformationMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
private PassWordToHash passWordToHash = new PassWordToHash();
    @Override
    public UserInformation findUser(UserInformation information) {
        UserInformation userInformation = userInformationMapper.findOne(information);
        userInformation.setWorkyear("2年");
        return userInformation;
    }

    @Override
    public int deleteUser(UserInformation information) {

        return userInformationMapper.deleteUser(information);
    }

    @Override
    public UserInformation addUser(UserInformation userInformation) {
        Date date = new Date();
        userInformation.setHiredate(date);
        int result = userInformationMapper.insert(userInformation);
        if (result == 1) {
            return userInformationMapper.findOne(userInformation);
        } else {
            return null;
        }

    }

    @Override
    public UserInformation updateUser(UserInformation userInformation) {

        int result = userInformationMapper.updateUser(userInformation);
        if (result == 1) {
            return userInformationMapper.findOne(userInformation);
        } else {
            return null;
        }
    }

    @Override
    public List<UserInformation> findAllUser() {
        List<UserInformation> userInformation = userInformationMapper.findAllUser();
        for(UserInformation u:userInformation){
            String startStr = u.getHiredate().toString();
            String startYear = startStr.substring(startStr.length()-4);
            String nowStr = new Date().toString();
            String nowYear = nowStr.substring(nowStr.length()-4);
            logger.info(nowStr);
            logger.error(nowYear);

            int hireYear = Integer.parseInt(nowYear)-Integer.parseInt(startYear);
            logger.info(hireYear+"");
            u.setWorkyear(hireYear+"");
        }
        return userInformation;
    }

    @Override
    public UserInformation comparePassword(String userid,String inputPass) {
        UserInformation user = new UserInformation();
        user.setUserid(userid);
        user.setPassword(passWordToHash.passwordToHash(inputPass.trim()));
        logger.info(userid);
        logger.info(inputPass);
        UserInformation u = userInformationMapper.comparePassword(user);
        u.setWorkyear("2年");
        return u;
    }

    @Override
    public UserInformation showWages(UserInformation userInformation) {
        return userInformationMapper.showWages(userInformation);
    }
    //登录
    public void doLogin(String userid,String password)throws Exception{
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token =
                    new UsernamePasswordToken(userid, password);
            token.setRememberMe(true);//是否记住用户
            try {
                currentUser.login(token);//执行登录
            } catch (UnknownAccountException uae) {
                throw new Exception("账户不存在");
            } catch (IncorrectCredentialsException ice) {
                throw new Exception("密码不正确");
            } catch (LockedAccountException lae) {
                throw new Exception("用户被锁定了 ");
            } catch (AuthenticationException ae) {
                ae.printStackTrace();
                throw new Exception("未知错误");
            }
        }

    }

//

}
