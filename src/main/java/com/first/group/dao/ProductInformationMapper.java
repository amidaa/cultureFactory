package com.first.group.dao;

import com.first.group.entity.ProductInformation;

import java.util.List;

public interface ProductInformationMapper {
    int insert(ProductInformation record);//添加一条商品信息

    int insertSelective(ProductInformation record);
    int deleteProduct(ProductInformation productInformation);//删除一条商品信息
    int updateProduct(ProductInformation productInformation);//更新一条商品信息
    ProductInformation findProduct(int id);//查找具体某个商品信息
    List<ProductInformation> findByProductId(String productId);//根据商品名查
    List<ProductInformation> findByProductSize(String productsize);//根据商品型号查
    List<ProductInformation> findByProductPrice(String productprice);//根据商品价格查
    List<ProductInformation> findAll();//查找所有的商品信息
}