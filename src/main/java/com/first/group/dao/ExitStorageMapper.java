package com.first.group.dao;

import com.first.group.entity.ExitStorage;

import java.util.List;

public interface ExitStorageMapper {
    int insert(ExitStorage record);//增加一条出库信息

    int insertSelective(ExitStorage record);
    int delete(ExitStorage exitStorage);//删除一条出库信息
    int update(ExitStorage exitStorage);//更新一条出库信息
    ExitStorage findExitProduct(int id);//根据id号查找一条出库信息
    List<ExitStorage> findAll();//查找所有的出库信息
}