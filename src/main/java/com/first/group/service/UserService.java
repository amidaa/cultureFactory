package com.first.group.service;

import com.first.group.entity.UserInformation;

import java.util.List;

public interface UserService {
    UserInformation findUser(UserInformation userInformation);//查找用户
    int deleteUser(UserInformation information);//删除用户
    UserInformation addUser(UserInformation userInformation);//添加用户
    UserInformation updateUser(UserInformation userInformation);//修改用户个人信息
    List<UserInformation> findAllUser();//查找所有的员工
    UserInformation comparePassword(String userid,String inputPass);//验证输入密码是否正确
    UserInformation showWages(UserInformation userInformation);//显示员工工资信息


}
