package com.first.group.serviceImpl;

import com.first.group.dao.UserRolesMapper;
import com.first.group.entity.UserRoles;
import com.first.group.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRolesMapper userRolesMapper;
    @Override
    public UserRoles findOne(String userid) {
        return userRolesMapper.findOne(userid);
    }
}
