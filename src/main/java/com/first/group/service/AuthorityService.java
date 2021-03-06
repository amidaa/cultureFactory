package com.first.group.service;

import com.first.group.entity.Authority;

import java.util.List;

public interface AuthorityService {
    Authority findAuthority(int id);//查找某项权限
    Authority addAuthority(Authority authority);//添加权限
    int deleteAuthority(int id);//删除权限
    List<Authority> findAllAuthority();//查找所有的权限
}
