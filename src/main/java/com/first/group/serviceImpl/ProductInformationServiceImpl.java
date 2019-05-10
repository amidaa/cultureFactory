package com.first.group.serviceImpl;

import com.first.group.dao.ProductInformationMapper;
import com.first.group.entity.ProductInformation;
import com.first.group.service.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInformationServiceImpl implements ProductInformationService {
    @Autowired
    ProductInformationMapper productInformationMapper;
    @Override
    public ProductInformation addProduct(ProductInformation productInformation) {
        productInformationMapper.insert(productInformation);
        return productInformationMapper.findProduct(1);
    }

    @Override
    public int deleteProduct(ProductInformation productInformation) {

        return productInformationMapper.deleteProduct(productInformation);
    }

    @Override
    public int updateProduct(ProductInformation productInformation) {
        return productInformationMapper.insert(productInformation);
    }

    @Override
    public ProductInformation findProduct(int id) {
        return productInformationMapper.findProduct(id);
    }

    @Override
    public List<ProductInformation> findByProductId(String productId) {
        return productInformationMapper.findByProductId(productId);
    }

    @Override
    public List<ProductInformation> findByProductSize(String productsize) {
        return productInformationMapper.findByProductSize(productsize);
    }

    @Override
    public List<ProductInformation> findByProductPrice(String productprice) {
        return productInformationMapper.findByProductPrice(productprice);
    }

    @Override
    public List<ProductInformation> findAll() {
        return productInformationMapper.findAll();
    }
}
