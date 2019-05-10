package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.ProductInformation;
import com.first.group.service.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductInformationApi")
public class ProductInformationController {


    private ProductInformationService productInformationService;
    @Autowired
    public ProductInformationController(ProductInformationService productInformationService){
        this.productInformationService = productInformationService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody ProductInformation productInformation) {
        ProductInformation information = productInformationService.addProduct(productInformation);
        JSONObject jsonObject = new JSONObject();
        if(information==null) {
            jsonObject.put("message", "商品订单信息添加失败");
        }else{
            jsonObject.put("message", "商品订单信息添加成功");
            jsonObject.put("product",information);
        }

        return jsonObject;
    }

    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable int id) {
        ProductInformation information = productInformationService.findProduct(id);
        JSONObject jsonObject = new JSONObject();
        if(information == null) {
            jsonObject.put("message", "该商品信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该商品信息存在");
            jsonObject.put("productInformation",information);
            return jsonObject;
        }



    }

    @GetMapping("/findByProductId/{productId}")
    public Object findByProductId(@PathVariable String productId) {
      List<ProductInformation> information = productInformationService.findByProductId(productId);
        JSONObject jsonObject = new JSONObject();
        if(information == null) {
            jsonObject.put("message", "该商品信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该商品信息存在");
            jsonObject.put("productInformation",information);
            return jsonObject;
        }



    }


    @GetMapping("/findBySize/{size}")
    public Object findBySize(@PathVariable String size) {
        List<ProductInformation> information = productInformationService.findByProductSize(size);
        JSONObject jsonObject = new JSONObject();
        if(information == null) {
            jsonObject.put("message", "该商品信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该商品信息存在");
            jsonObject.put("productInformation",information);
            return jsonObject;
        }
    }

    @GetMapping("/findByPrise/{price}")
    public Object findByPrice(@PathVariable String price) {
        List<ProductInformation> information = productInformationService.findByProductPrice(price);
        JSONObject jsonObject = new JSONObject();
        if(information == null) {
            jsonObject.put("message", "该商品信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该商品信息存在");
            jsonObject.put("productInformation",information);
            return jsonObject;
        }



    }



    @GetMapping("/findAllInformation")
    public Object findAllInformation() {
        List<ProductInformation> informations = productInformationService.findAll();
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
        ProductInformation productInformation = new ProductInformation();
        productInformation.setId(id);
        int result = productInformationService.deleteProduct(productInformation);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object update(@RequestBody ProductInformation productInformation){
        int result = productInformationService.updateProduct(productInformation);
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
