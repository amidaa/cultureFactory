package com.first.group.serviceImpl;

import com.first.group.dao.ExitStorageMapper;
import com.first.group.entity.ExitStorage;
import com.first.group.service.ExitStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExitStorageServiceImpl implements ExitStorageService {
    @Autowired
    ExitStorageMapper exitStorageMapper;
    @Override
    public int addProduct(ExitStorage exitStorage) {
        return exitStorageMapper.insert(exitStorage);
    }

    @Override
    public int delete(ExitStorage exitStorage) {
        return exitStorageMapper.delete(exitStorage);
    }

    @Override
    public int update(ExitStorage exitStorage) {
        return exitStorageMapper.update(exitStorage);
    }

    @Override
    public ExitStorage findEnterProduct(int id) {
        return exitStorageMapper.findExitProduct(id);
    }

    @Override
    public List<ExitStorage> findAll() {
        return exitStorageMapper.findAll();
    }
}
