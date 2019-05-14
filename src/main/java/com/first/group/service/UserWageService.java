package com.first.group.service;

import com.first.group.entity.UserWages;

import java.util.List;

public interface UserWageService {
    List<UserWages> addUserWages(List<UserWages> userWages);//添加多条工资记录
    UserWages addSingle(UserWages userWages);//添加一条用户工资记录
    List<UserWages> findAll();//查找所有的工资信息
    int delete(UserWages userWages);//删除一条工资信息
    int update(UserWages userWages);//更新一条工资信息
}
