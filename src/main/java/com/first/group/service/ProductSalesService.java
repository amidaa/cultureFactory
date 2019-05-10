package com.first.group.service;

import com.first.group.entity.ProductSales;

import java.util.List;

public interface ProductSalesService {
    ProductSales addProduct(ProductSales productSales);//插入一条产品销售信息
    int deleteProductSales(int id);//删除一条产品销售信息
    int updateProductSales(ProductSales productSales);//更新一条产品销售信息
    ProductSales findById(int id);//通过id号查找产品
    List<ProductSales> findAll();//查看所有的产品销售信息
}
