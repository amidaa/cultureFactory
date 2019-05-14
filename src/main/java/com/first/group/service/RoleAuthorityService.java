package com.first.group.service;

import com.first.group.entity.RoleAuthority;

import java.util.List;

public interface RoleAuthorityService {
    RoleAuthority findOne(int role);
    List<RoleAuthority> findByRole(int roleid);
}
