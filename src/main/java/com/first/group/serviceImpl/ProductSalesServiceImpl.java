package com.first.group.serviceImpl;

import com.first.group.dao.ProductSalesMapper;
import com.first.group.entity.ProductSales;
import com.first.group.service.ProductSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSalesServiceImpl implements ProductSalesService {
    @Autowired
    ProductSalesMapper productSalesMapper;
    @Override
    public ProductSales addProduct(ProductSales productSales) {
        int result = productSalesMapper.insert(productSales);
        if(result==1){
            return productSalesMapper.findById(productSales.getId());
        }
        return null;
    }

    @Override
    public int deleteProductSales(int id) {
        return productSalesMapper.delete(id);
    }

    @Override
    public int updateProductSales(ProductSales productSales) {
        return productSalesMapper.update(productSales);
    }

    @Override
    public ProductSales findById(int id) {
        return productSalesMapper.findById(id);
    }

    @Override
    public List<ProductSales> findAll() {
        return productSalesMapper.findAll();
    }
}
