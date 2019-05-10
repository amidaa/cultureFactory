package com.first.group.serviceImpl;

import com.first.group.dao.DamagedMapper;
import com.first.group.entity.Damaged;
import com.first.group.service.DamagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DamagedServiceImpl implements DamagedService {

    @Autowired
    DamagedMapper damagedMapper;
    @Override
    public Damaged addDamaged(Damaged damaged) {
        int result = damagedMapper.insert(damaged);
        if(result==1){
            return damagedMapper.findOne(damaged);
        }else{
            return null;
        }

    }

    @Override
    public int deleteDamaged(Damaged damaged) {
        return damagedMapper.delete(damaged);
    }

    @Override
    public Damaged findOne(Damaged damaged) {
        return damagedMapper.findOne(damaged);
    }

    @Override
    public List<Damaged> findByStorage(String storageId) {
        Damaged damaged = new Damaged();
        damaged.setStorageid(storageId);
        return damagedMapper.findByStorage(damaged);
    }

    @Override
    public List<Damaged> findByProduct(String productId) {
        Damaged damaged = new Damaged();
        damaged.setProductid(productId);
        return damagedMapper.findByProduct(damaged);
    }

    @Override
    public int updateDamaged(Damaged damaged) {
        return damagedMapper.update(damaged);
    }

    @Override
    public List<Damaged> findAll() {
        return damagedMapper.findAll();
    }
}
