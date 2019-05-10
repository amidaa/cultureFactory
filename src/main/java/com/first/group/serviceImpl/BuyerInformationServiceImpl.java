package com.first.group.serviceImpl;

import com.first.group.dao.BuyerInformationMapper;
import com.first.group.entity.BuyerInformation;
import com.first.group.service.BuyerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BuyerInformationServiceImpl implements BuyerInformationService {
    @Autowired
    BuyerInformationMapper buyerInformationMapper;
    @Override
    public int addBuyer(BuyerInformation buyerInformation) {
        return buyerInformationMapper.insert(buyerInformation);
    }

    @Override
    public int deleteBuyer(String buyerId) {
        BuyerInformation buyerInformation = new BuyerInformation();
        buyerInformation.setBuyerid(buyerId);
        return buyerInformationMapper.delete(buyerInformation);
    }

    @Override
    public int updateBuyer(BuyerInformation buyerInformation) {
        return buyerInformationMapper.updateBuyerInformation(buyerInformation);
    }

    @Override
    public BuyerInformation findBuyerInformation(String buyerId) {
        BuyerInformation buyerInformation = new BuyerInformation();
        buyerInformation.setBuyerid(buyerId);
        return buyerInformationMapper.findOne(buyerInformation);
    }

    @Override
    public List<BuyerInformation> findAll() {
        return buyerInformationMapper.findAll();
    }
}
