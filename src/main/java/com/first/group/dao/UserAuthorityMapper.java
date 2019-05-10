package com.first.group.dao;

import com.first.group.entity.UserAuthority;

public interface UserAuthorityMapper {
    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);
    UserAuthority findOne(UserAuthority userAuthority);
}