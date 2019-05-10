package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.EnterStorage;
import com.first.group.service.EnterStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EnterStorageApi")
public class EnterStorageController {
    private EnterStorageService enterStorageService;
    @Autowired
    public EnterStorageController(EnterStorageService enterStorageService){
        this.enterStorageService = enterStorageService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody EnterStorage enterStorage) {
        int result = enterStorageService.addProduct(enterStorage);
        JSONObject jsonObject = new JSONObject();
        if(result!=1) {
            jsonObject.put("message", "商品入库信息添加失败");
        }else{
            jsonObject.put("message", "商品入库信息添加成功");
        }

        return jsonObject;
    }

    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable int id) {
        EnterStorage enterStorage =  enterStorageService.findEnterProduct(id);
        JSONObject jsonObject = new JSONObject();
        if(enterStorage == null) {
            jsonObject.put("message", "该入库信息信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该入库信息信息存在");
            jsonObject.put("enterStorageInformation",enterStorage);
            return jsonObject;
        }



    }

    @GetMapping("/findAllRecord")
    public Object findAllRecord() {
        List<EnterStorage> informations = enterStorageService.findAll();
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
        EnterStorage enterStorage = new EnterStorage();
        enterStorage.setId(id);
        int result = enterStorageService.delete(enterStorage);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object updateBuyer(@RequestBody EnterStorage enterStorage){
        int result = enterStorageService.update(enterStorage);
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
