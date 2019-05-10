package com.first.group.dao;

import com.first.group.entity.UserDep;

public interface UserDepMapper {
    int insert(UserDep record);

    int insertSelective(UserDep record);
}