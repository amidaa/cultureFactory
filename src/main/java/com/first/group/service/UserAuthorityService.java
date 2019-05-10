package com.first.group.service;

import com.first.group.entity.UserAuthority;
import org.springframework.stereotype.Service;

public interface UserAuthorityService {
    UserAuthority findOne(String userid);
}
