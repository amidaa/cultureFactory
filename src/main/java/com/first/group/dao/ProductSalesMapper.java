package com.first.group.dao;

import com.first.group.entity.ProductSales;
import com.first.group.entity.ProductSalesExample;
import java.util.List;

public interface ProductSalesMapper {
    int insert(ProductSales record);//添加一条产品信息

    int insertSelective(ProductSales record);

    List<ProductSales> selectByExample(ProductSalesExample example);

    int delete(int id);//删除一条产品销售信息
    int update(ProductSales productSales);//更新一条产品销售信息
    ProductSales findById(int id);//通过id号查找产品
    List<ProductSales> findAll();//查看所有的产品销售信息
}