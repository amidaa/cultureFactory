package com.first.group.dao;

import com.first.group.entity.Damaged;

import java.util.List;

public interface DamagedMapper {
    int insert(Damaged record);//添加一条残次商品信息
    int delete(Damaged damaged);//删除一条残次商品信息
    Damaged findOne(Damaged damaged);//查找某条残次商品信息
    List<Damaged> findByStorage(Damaged damaged);//查找某个仓库的所有残次商品信息
    List<Damaged> findByProduct(Damaged damaged);//查找某项商品的残次信息
    int update(Damaged damaged);//更新残次商品信息
    List<Damaged> findAll();//
    int insertSelective(Damaged record);
}