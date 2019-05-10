package com.first.group.dao;

import com.first.group.entity.UserInformation;

import java.util.List;

public interface UserInformationMapper {
    int insert(UserInformation record);//添加用户信息
    int addUser(UserInformation userInformation);//添加用户
    UserInformation findOne(UserInformation information);//查找用户
    int insertSelective(UserInformation record);
    int deleteUser(UserInformation information);//删除用户
    int updateUser(UserInformation information);//更改用户信息
    List<UserInformation> findAllUser();//查找所有的员工
    UserInformation comparePassword(UserInformation user);//验证输入密码是否正确
}