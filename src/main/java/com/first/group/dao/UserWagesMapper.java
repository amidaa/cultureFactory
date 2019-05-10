package com.first.group.dao;

import com.first.group.entity.UserWages;

public interface UserWagesMapper {
    int insert(UserWages record);

    int insertSelective(UserWages record);
}