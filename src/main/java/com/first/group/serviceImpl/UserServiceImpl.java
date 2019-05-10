package com.first.group.serviceImpl;

import com.first.group.dao.UserInformationMapper;
import com.first.group.entity.UserInformation;
import com.first.group.service.UserService;
import com.first.group.util.PassWordToHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        return userInformationMapper.findOne(information);
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
        return userInformationMapper.findAllUser();
    }

    @Override
    public UserInformation comparePassword(String userid,String inputPass) {
        UserInformation user = new UserInformation();
        user.setUserid(userid);
        user.setPassword(passWordToHash.passwordToHash(inputPass.trim()));
        logger.info(userid);
        logger.info(inputPass);
        logger.info(user.getPassword());
        UserInformation u = userInformationMapper.comparePassword(user);
        return u;
    }

//

}
