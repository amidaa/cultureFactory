package com.first.group.dao;

import com.first.group.entity.OrderForm;

import java.util.List;

public interface OrderFormMapper {
    int insert(OrderForm record);//添加一条订单信息

    int insertSelective(OrderForm record);
    int delete(OrderForm orderForm);//删除一条订单信息
    int update(OrderForm orderForm);//更新一条订单信息
    OrderForm findForm(String id);//根据id号查找一条订单信息
    List<OrderForm> findAll();//查找所有的订单信息
}