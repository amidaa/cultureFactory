package com.first.group.serviceImpl;

import com.first.group.dao.AuthorityMapper;
import com.first.group.entity.Authority;
import com.first.group.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;
    @Override
    public Authority findAuthority(String authorityId) {
        Authority authority = new Authority();
        authority.setAuthorityid(authorityId);
        return authorityMapper.findOne(authority);
    }

    @Override
    public Authority addAuthority(Authority authority) {
        int result = authorityMapper.insert(authority);
        if(result==1){
            return authorityMapper.findOne(authority);
        }else {
            return null;
        }

    }

    @Override
    public int deleteAuthority(String authorityId) {
        Authority authority = new Authority();
        authority.setAuthorityid(authorityId);
        return authorityMapper.deleteAuthority(authority);
    }

    @Override
    public List<Authority> findAllAuthority() {
        return authorityMapper.findAll();
    }
}
