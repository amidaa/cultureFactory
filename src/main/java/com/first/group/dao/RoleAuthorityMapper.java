package com.first.group.dao;

import com.first.group.entity.RoleAuthority;

import java.util.List;

public interface RoleAuthorityMapper {
    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);
    RoleAuthority findOne(RoleAuthority roleAuthority);

    List<RoleAuthority> findByRole(int roleid);

}