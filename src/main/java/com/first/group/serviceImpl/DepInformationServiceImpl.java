package com.first.group.serviceImpl;

import com.first.group.dao.DepInformationMapper;
import com.first.group.entity.DepInformation;
import com.first.group.service.DepInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepInformationServiceImpl implements DepInformationService {
    @Autowired
    DepInformationMapper depInformationMapper;
    @Override
    public DepInformation findOne(String depid) {
        DepInformation depInformation = new DepInformation();
        depInformation.setDepid(depid);
        return depInformationMapper.findOne(depInformation);
    }

    @Override
    public List<DepInformation> findAll() {
        return depInformationMapper.findAll();
    }

    @Override
    public int addDepInformation(DepInformation depInformation) {
        return depInformationMapper.insert(depInformation);
    }

    @Override
    public int deleteDepInformation(String depid) {
        DepInformation depInformation = new DepInformation();
        depInformation.setDepid(depid);
        return depInformationMapper.delete(depInformation);
    }

    @Override
    public int updateDepInformation(DepInformation depInformation) {
        return depInformationMapper.update(depInformation);
    }
}
