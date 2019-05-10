package com.first.group.serviceImpl;

import com.first.group.dao.ProductStorageMapper;
import com.first.group.entity.ProductStorage;
import com.first.group.service.ProductStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductStorageServiceImpl implements ProductStorageService {
    @Autowired
    ProductStorageMapper productStorageMapper;
    @Override
    public ProductStorage addStorage(ProductStorage productStorage) {
        int result = productStorageMapper.insert(productStorage);
        if(result==1){
            return productStorageMapper.findById(productStorage.getId());
        }
        return null;
    }

    @Override
    public int deleteStorage(int id) {
        return productStorageMapper.deleteStorage(id);
    }

    @Override
    public int updateStorage(ProductStorage productStorage) {
        return productStorageMapper.updateStorage(productStorage);
    }

    @Override
    public ProductStorage findById(int id) {
        return productStorageMapper.findById(id);
    }

    @Override
    public List<ProductStorage> findAll() {
        return productStorageMapper.findAll();
    }
}
