package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.BuyerInformation;
import com.first.group.service.BuyerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BuyerInformationApi")
public class BuyerInformationController {
    private BuyerInformationService buyerInformationService;
    @Autowired
    public BuyerInformationController(BuyerInformationService buyerInformationService){
        this.buyerInformationService = buyerInformationService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody BuyerInformation buyerInformation) {
        int result = buyerInformationService.addBuyer(buyerInformation);
        JSONObject jsonObject = new JSONObject();
        if(result!=1) {
            jsonObject.put("message", "购买用户信息添加失败");
        }else{
            jsonObject.put("message", "购买用户信息添加成功");
        }

        return jsonObject;
    }

    @GetMapping("/findById/{buyerId}")
    public Object findById(@PathVariable String buyerId) {
       BuyerInformation buyerInformation = buyerInformationService.findBuyerInformation(buyerId);
        JSONObject jsonObject = new JSONObject();
        if(buyerInformation == null) {
            jsonObject.put("message", "该购买用户信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该购买用户信息存在");
            jsonObject.put("buyerInformation",buyerInformation);
            return jsonObject;
        }



    }

    @GetMapping("/findAllBuyerInformation")
    public Object findAllBuyerInformation() {
        List<BuyerInformation> informations = buyerInformationService.findAll();
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

    @DeleteMapping("/delete/{buyerId}")
    public Object deleteInformation(@PathVariable String buyerId){
        int result = buyerInformationService.deleteBuyer(buyerId);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object updateBuyer(@RequestBody BuyerInformation buyerInformation){
       int result = buyerInformationService.updateBuyer(buyerInformation);
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
