package com.first.group.dao;

import com.first.group.entity.ProductStorage;
import com.first.group.entity.ProductStorageExample;
import java.util.List;

public interface ProductStorageMapper {
    int insert(ProductStorage record);

    int insertSelective(ProductStorage record);

    List<ProductStorage> selectByExample(ProductStorageExample example);

    int deleteStorage(int id);//删除一条入库信息
    int updateStorage(ProductStorage productStorage);//修改入库信息
    ProductStorage findById(int id);//通过id号查找产品入库信息
    List<ProductStorage> findAll();//查找所有的产品入库信息
}