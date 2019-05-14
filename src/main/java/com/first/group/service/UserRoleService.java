package com.first.group.service;

import com.first.group.entity.UserRoles;

public interface UserRoleService {
    UserRoles findOne(String userid);
}
