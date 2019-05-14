package com.first.group.dao;

import com.first.group.entity.UserRoles;

public interface UserRolesMapper {
    UserRoles findOne(String userid);
}
