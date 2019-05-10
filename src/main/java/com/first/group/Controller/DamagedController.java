package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.BuyerInformation;
import com.first.group.entity.Damaged;
import com.first.group.service.DamagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DamagedApi")
public class DamagedController {
    private DamagedService damagedService;
    @Autowired
    public DamagedController(DamagedService damagedService){
        this.damagedService = damagedService;
    }

    @PostMapping("/add")
    public Object addDamaged(@RequestBody Damaged  damaged) {
        Damaged good = damagedService.addDamaged(damaged);
        JSONObject jsonObject = new JSONObject();
        if(good!=null) {
            jsonObject.put("message", "残次商品信息添加成功");
            jsonObject.put("damaged",good);
        }else{
            jsonObject.put("message", "残次商品信息添加失败");
        }

        return jsonObject;
    }

    @GetMapping("/findOne/{storageId}&{productId}")
    public Object findById(@PathVariable String storageId,@PathVariable String productId) {
        Damaged damaged = new Damaged();
        damaged.setStorageid(storageId);
        damaged.setProductid(productId);
        Damaged good = damagedService.findOne(damaged);
        JSONObject jsonObject = new JSONObject();
        if (good == null) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        } else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("damaged", good);
            return jsonObject;
        }
    }

    @GetMapping("/findByStorage/{storageId}")
    public Object findByStorage(@PathVariable String storageId) {
        List<Damaged> damageds = damagedService.findByStorage(storageId);
        JSONObject jsonObject = new JSONObject();
        if(damageds == null||damageds.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("damageds",damageds);
            return jsonObject;
        }


    }

    @GetMapping("/findByProduct/{productId}")
    public Object findByProduct(@PathVariable String productId) {
        List<Damaged> damageds = damagedService.findByProduct(productId);
        JSONObject jsonObject = new JSONObject();
        if(damageds == null||damageds.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("damageds",damageds);
            return jsonObject;
        }


    }

    @GetMapping("/findAllDamaged")
    public Object findAllDamaged() {
        List<Damaged> damageds = damagedService.findAll();
        JSONObject jsonObject = new JSONObject();
        if(damageds == null||damageds.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("allDamaged",damageds);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{storageId}&{productId}")
    public Object deleteInformation(@PathVariable String storageId,@PathVariable String productId ){
        Damaged damaged = new Damaged();
        damaged.setStorageid(storageId);
        damaged.setProductid(productId);
        int result = damagedService.deleteDamaged(damaged);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object updateBuyer(@RequestBody Damaged damaged){
        int result = damagedService.updateDamaged(damaged);
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
