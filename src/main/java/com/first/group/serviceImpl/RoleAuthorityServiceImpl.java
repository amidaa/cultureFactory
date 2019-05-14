package com.first.group.serviceImpl;

import com.first.group.dao.RoleAuthorityMapper;
import com.first.group.entity.RoleAuthority;
import com.first.group.service.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
@Autowired
RoleAuthorityMapper roleAuthorityMapper;
    @Override
    public RoleAuthority findOne(int roleid) {
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setRoleid(roleid);
        return roleAuthorityMapper.findOne(roleAuthority);
    }

    @Override
    public List<RoleAuthority> findByRole(int roleid) {
        return roleAuthorityMapper.findByRole(roleid);
    }
}
