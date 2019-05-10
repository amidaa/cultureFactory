package com.first.group.dao;

import com.first.group.entity.EnterStorage;

import java.util.List;

public interface EnterStorageMapper {
    int insert(EnterStorage record);//插入一条入库信息

    int insertSelective(EnterStorage record);
    int delete(EnterStorage enterStorage);//删除一条入库信息
    int update(EnterStorage enterStorage);//更新一条入库信息
    EnterStorage findEnterProduct(int id);//根据id号查找一条入库信息
    List<EnterStorage> findAll();//查找所有的入库信息
}