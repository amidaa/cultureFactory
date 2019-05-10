package com.first.group.serviceImpl;

import com.first.group.dao.EnterStorageMapper;
import com.first.group.entity.EnterStorage;
import com.first.group.service.EnterStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnterStorageServiceImpl implements EnterStorageService {
    @Autowired
    EnterStorageMapper enterStorageMapper;
    @Override
    public int addProduct(EnterStorage enterStorage) {
        return enterStorageMapper.insert(enterStorage);
    }

    @Override
    public int delete(EnterStorage enterStorage) {
        return enterStorageMapper.delete(enterStorage);
    }

    @Override
    public int update(EnterStorage enterStorage) {
        return enterStorageMapper.update(enterStorage);
    }

    @Override
    public EnterStorage findEnterProduct(int id) {
        return enterStorageMapper.findEnterProduct(id);
    }

    @Override
    public List<EnterStorage> findAll() {
        return enterStorageMapper.findAll();
    }
}
