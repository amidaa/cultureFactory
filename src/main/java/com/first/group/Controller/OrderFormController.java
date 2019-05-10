package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.ExitStorage;
import com.first.group.entity.OrderForm;
import com.first.group.service.ExitStorageService;
import com.first.group.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderFormApi")
public class OrderFormController {
    private OrderFormService orderFormService;
    @Autowired
    public OrderFormController(OrderFormService orderFormService){
        this.orderFormService = orderFormService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody OrderForm orderForm) {
        int result = orderFormService.addForm(orderForm);
        JSONObject jsonObject = new JSONObject();
        if(result!=1) {
            jsonObject.put("message", "商品订单信息添加失败");
        }else{
            jsonObject.put("message", "商品订单信息添加成功");
        }

        return jsonObject;
    }

    @GetMapping("/findById/{formId}")
    public Object findById(@PathVariable String formId) {
        OrderForm form = orderFormService.findForm(formId);
        JSONObject jsonObject = new JSONObject();
        if(form == null) {
            jsonObject.put("message", "该商品订单信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该商品订单信息存在");
            jsonObject.put("buyerInformation",form);
            return jsonObject;
        }



    }

    @GetMapping("/findAllRecord")
    public Object findAllRecord() {
        List<OrderForm> informations = orderFormService.findAll();
        JSONObject jsonObject = new JSONObject();
        if(informations == null||informations.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("informations",informations);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{id}")
    public Object deleteInformation(@PathVariable String id){
        OrderForm orderForm = new OrderForm();
        orderForm.setOrderid(id);
        int result = orderFormService.delete(orderForm);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object update(@RequestBody OrderForm orderForm){
        int result = orderFormService.update(orderForm);
        JSONObject jsonObject = new JSONObject();
        if(result != 1) {
            jsonObject.put("message", "信息更新失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "信息更新成功");
            return jsonObject;
        }

    }

}
