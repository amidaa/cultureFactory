package com.first.group.service;

import com.first.group.entity.ExitStorage;

import java.util.List;

public interface ExitStorageService {
    int addProduct(ExitStorage exitStorage);//增加一条出库信息
    int delete(ExitStorage exitStorage);//删除一条出库信息
    int update(ExitStorage exitStorage);//更新一条出库信息
   ExitStorage findEnterProduct(int id);//根据id号查找一条出库信息
    List<ExitStorage> findAll();//查找所有的出库信息
}
