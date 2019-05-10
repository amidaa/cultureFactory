package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.BuyerInformation;
import com.first.group.entity.ExitStorage;
import com.first.group.service.BuyerInformationService;
import com.first.group.service.ExitStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ExitStorageApi")
public class ExitStorageController {
    private ExitStorageService exitStorageService;
    @Autowired
    public ExitStorageController(ExitStorageService exitStorageService){
        this.exitStorageService = exitStorageService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody ExitStorage exitStorage) {
        int result = exitStorageService.addProduct(exitStorage);
        JSONObject jsonObject = new JSONObject();
        if(result!=1) {
            jsonObject.put("message", "商品出库信息添加失败");
        }else{
            jsonObject.put("message", "商品出库信息添加成功");
        }

        return jsonObject;
    }

    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable int id) {
        ExitStorage exitStorage = exitStorageService.findEnterProduct(id);
        JSONObject jsonObject = new JSONObject();
        if(exitStorage == null) {
            jsonObject.put("message", "该商品出库信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该商品出库信息存在");
            jsonObject.put("buyerInformation",exitStorage);
            return jsonObject;
        }



    }

    @GetMapping("/findAllRecord")
    public Object findAllRecord() {
        List<ExitStorage> informations = exitStorageService.findAll();
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
    public Object deleteInformation(@PathVariable int id){
        ExitStorage exitStorage = new ExitStorage();
        exitStorage.setId(id);
        int result = exitStorageService.delete(exitStorage);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object update(@RequestBody ExitStorage exitStorage){
        int result = exitStorageService.update(exitStorage);
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
