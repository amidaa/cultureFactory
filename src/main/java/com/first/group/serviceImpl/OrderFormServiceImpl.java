package com.first.group.serviceImpl;

import com.first.group.dao.OrderFormMapper;
import com.first.group.entity.OrderForm;
import com.first.group.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Autowired
    OrderFormMapper orderFormMapper;
    @Override
    public int addForm(OrderForm orderForm) {
        return orderFormMapper.insert(orderForm);
    }

    @Override
    public int delete(OrderForm orderForm) {
        return orderFormMapper.delete(orderForm);
    }

    @Override
    public int update(OrderForm orderForm) {
        return orderFormMapper.update(orderForm);
    }

    @Override
    public OrderForm findForm(String id) {
        return orderFormMapper.findForm(id);
    }

    @Override
    public List<OrderForm> findAll() {
        return orderFormMapper.findAll();
    }
}
