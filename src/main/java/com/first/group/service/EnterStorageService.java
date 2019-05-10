package com.first.group.service;

import com.first.group.entity.EnterStorage;

import java.util.List;

public interface EnterStorageService {
    int addProduct(EnterStorage enterStorage);//增加一条入库信息
    int delete(EnterStorage enterStorage);//删除一条入库信息
    int update(EnterStorage enterStorage);//更新一条入库信息
    EnterStorage findEnterProduct(int id);//根据id号查找一条入库信息
    List<EnterStorage> findAll();//查找所有的入库信息
}
