package com.first.group.dao;

import com.first.group.entity.BuyerInformation;

import java.util.List;

public interface BuyerInformationMapper {
    int insert(BuyerInformation record);//添加一项购买用户信息

    int insertSelective(BuyerInformation record);
    int delete(BuyerInformation buyerInformation);//删除某项购买用户信息
    int updateBuyerInformation(BuyerInformation buyerInformation);//修改某项购买用户信息
    BuyerInformation findOne(BuyerInformation buyerInformation);//查找某项购买用户信息
    List<BuyerInformation> findAll();//查找所有的购买用户信息
}