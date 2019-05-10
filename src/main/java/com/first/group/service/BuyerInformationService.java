package com.first.group.service;

import com.first.group.entity.BuyerInformation;

import java.util.List;

public interface BuyerInformationService {
    int addBuyer(BuyerInformation buyerInformation);//添加购买用户信息
    int deleteBuyer(String buyerId);//删除购买用户信息
    int updateBuyer(BuyerInformation buyerInformation);//更新购买用户信息
    BuyerInformation findBuyerInformation(String buyerId);//查找某个具体的用户购买信息
    List<BuyerInformation> findAll();//查找所有的用户购买信息
}
