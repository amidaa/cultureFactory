package com.first.group.dao;

import com.first.group.entity.UserWages;

import java.util.List;

public interface UserWagesMapper {
    int insert(UserWages record);

    int insertSelective(UserWages record);
    int addUserWages(List<UserWages> userWages);//添加多条工资记录
    int addSingle(UserWages userWages);//添加一条用户工资记录
    List<UserWages> findAll();//查找所有的工资信息
    UserWages finOne(UserWages userWages);//查找某条记录
    int delete(UserWages userWages);//删除一条工资信息
    int update(UserWages userWages);//更新一条工资信息
}