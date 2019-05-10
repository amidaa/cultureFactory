package com.first.group.dao;

import com.first.group.entity.Authority;

import java.util.List;

public interface AuthorityMapper {
    int insert(Authority record);//添加权限

    int insertSelective(Authority record);
    Authority findOne(Authority authority);//查找某项权限
    List<Authority> findAll();//查找所有的权限
    int deleteAuthority(Authority authority);//删除某项权限
}