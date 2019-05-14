package com.first.group.serviceImpl;

import com.first.group.dao.UserWagesMapper;
import com.first.group.entity.UserWages;
import com.first.group.service.UserWageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserWageServiceImpl implements UserWageService {
    @Autowired
    UserWagesMapper userWagesMapper;
    @Override
    public List<UserWages> addUserWages(List<UserWages> userWages) {
        int result = userWagesMapper.addUserWages(userWages);
        if(result==1){
            return userWagesMapper.findAll();
        }
        return null;
    }

    @Override
    public UserWages addSingle(UserWages userWages) {
        int result = userWagesMapper.addSingle(userWages);
        if(result==1){
            return userWagesMapper.finOne(userWages);
        }
        return null;
    }

    @Override
    public List<UserWages> findAll() {
        return userWagesMapper.findAll();
    }

    @Override
    public int delete(UserWages userWages) {
        return userWagesMapper.delete(userWages);
    }

    @Override
    public int update(UserWages userWages) {
        return userWagesMapper.update(userWages);
    }
}
