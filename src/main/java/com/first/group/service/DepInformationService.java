package com.first.group.service;

import com.first.group.entity.DepInformation;

import java.util.List;

public interface DepInformationService {
    DepInformation findOne(String depid);//查找某个具体的部门信息
    List<DepInformation> findAll();//查找所有的部门信息
    int addDepInformation(DepInformation depInformation);//添加部门信息
    int deleteDepInformation(String depid);//删除部门信息
    int updateDepInformation(DepInformation depInformation);//更新部门信息
}
