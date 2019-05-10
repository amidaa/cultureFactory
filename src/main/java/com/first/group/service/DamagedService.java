package com.first.group.service;

import com.first.group.entity.Damaged;

import java.util.List;

public interface DamagedService {
    Damaged addDamaged(Damaged damaged);//添加残次商品信息
    int deleteDamaged(Damaged damaged);//删除残次商品信息
    Damaged findOne(Damaged damaged);//查找某项残次商品信息
    List<Damaged> findByStorage(String storageId);//查找某个库房的所有残次商品
    List<Damaged> findByProduct(String productId);//查找某个商品的所有残次信息
    List<Damaged> findAll();//查找所有的残次商品信息
    int updateDamaged(Damaged damaged);//更新残次商品信息


}
