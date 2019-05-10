package com.first.group.service;

import com.first.group.entity.ProductStorage;

import java.util.List;

public interface ProductStorageService {
    ProductStorage addStorage(ProductStorage productStorage);//增加一条入库信息
    int deleteStorage(int id);//删除一条入库信息
    int updateStorage(ProductStorage productStorage);//修改入库信息
    ProductStorage findById(int id);//通过id号查找产品入库信息
    List<ProductStorage> findAll();//查找所有的产品入库信息

}
