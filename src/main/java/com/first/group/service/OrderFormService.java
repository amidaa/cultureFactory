package com.first.group.service;

import com.first.group.entity.OrderForm;

import java.util.List;

public interface OrderFormService {
    int addForm(OrderForm orderForm);//增加一条订单信息
    int delete(OrderForm orderForm);//删除一条订单信息
    int update(OrderForm orderForm);//更新一条订单信息
    OrderForm findForm(String id);//根据id号查找一条订单信息
    List<OrderForm> findAll();//查找所有的订单信息
}
