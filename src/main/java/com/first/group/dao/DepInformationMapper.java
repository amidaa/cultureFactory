package com.first.group.dao;

import com.first.group.entity.DepInformation;

import java.util.List;

public interface DepInformationMapper {
    int insert(DepInformation record);//添加一个部门信息

    int insertSelective(DepInformation record);
    int delete(DepInformation depInformation);//删除一个部门信息
    int update(DepInformation depInformation);//更新部门信息
    DepInformation findOne(DepInformation depInformation);//查看部门信息
    List<DepInformation> findAll();//查看所有的部门信息
}