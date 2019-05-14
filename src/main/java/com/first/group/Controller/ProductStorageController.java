package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.ProductSales;
import com.first.group.entity.ProductStorage;
import com.first.group.service.ProductSalesService;
import com.first.group.service.ProductStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin//跨域请求
@RestController
@RequestMapping("/ProductStorageApi")

public class ProductStorageController {

    private ProductStorageService productStorageService;
    @Autowired
    public ProductStorageController(ProductStorageService productStorageService){
        this.productStorageService = productStorageService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody ProductStorage productStorage) {
        ProductStorage product = productStorageService.addStorage(productStorage);
        JSONObject jsonObject = new JSONObject();
        if(product==null) {
            jsonObject.put("message", "商品入库信息添加失败");
        }else{
            jsonObject.put("message", "商品入库信息添加成功");
            jsonObject.put("product",product);
        }

        return jsonObject;
    }

    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable int id) {
        ProductStorage product = productStorageService.findById(id);
        JSONObject jsonObject = new JSONObject();
        if(product == null) {
            jsonObject.put("message", "该入库信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该入库信息存在");
            jsonObject.put("productInformation",product);
            return jsonObject;
        }



    }


    @GetMapping("/findAll")
    public Object findAllInformation() {
        List<ProductStorage> products = productStorageService.findAll();
        JSONObject jsonObject = new JSONObject();
        if(products == null||products.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("informations",products);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{id}")
    public Object deleteInformation(@PathVariable int id){
        int result = productStorageService.deleteStorage(id);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object update(@RequestBody ProductStorage productStorage){
        int result = productStorageService.updateStorage(productStorage);
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
