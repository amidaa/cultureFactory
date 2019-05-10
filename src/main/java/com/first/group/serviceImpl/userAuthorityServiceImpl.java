package com.first.group.serviceImpl;

import com.first.group.dao.UserAuthorityMapper;
import com.first.group.entity.UserAuthority;
import com.first.group.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userAuthorityServiceImpl implements UserAuthorityService {
@Autowired
    UserAuthorityMapper userAuthorityMapper;
    @Override
    public UserAuthority findOne(String userid) {
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUserid(userid);
        return userAuthorityMapper.findOne(userAuthority);
    }
}
