package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.ProductInformation;
import com.first.group.entity.ProductSales;
import com.first.group.service.ProductInformationService;
import com.first.group.service.ProductSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductSalesApi")
public class ProductSalesController {

    private ProductSalesService productSalesService;
    @Autowired
    public ProductSalesController(ProductSalesService productSalesService){
        this.productSalesService = productSalesService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody ProductSales productSales) {
        ProductSales product = productSalesService.addProduct(productSales);
        JSONObject jsonObject = new JSONObject();
        if(product==null) {
            jsonObject.put("message", "商品销售信息添加失败");
        }else{
            jsonObject.put("message", "商品销售信息添加成功");
            jsonObject.put("product",product);
        }

        return jsonObject;
    }

    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable int id) {
        ProductSales product = productSalesService.findById(id);
        JSONObject jsonObject = new JSONObject();
        if(product == null) {
            jsonObject.put("message", "该销售信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该销售信息存在");
            jsonObject.put("productInformation",product);
            return jsonObject;
        }



    }


    @GetMapping("/findAll")
    public Object findAllInformation() {
        List<ProductSales> productSales = productSalesService.findAll();
        JSONObject jsonObject = new JSONObject();
        if(productSales == null||productSales.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("informations",productSales);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{id}")
    public Object deleteInformation(@PathVariable int id){
        int result = productSalesService.deleteProductSales(id);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object update(@RequestBody ProductSales productSales){
        int result = productSalesService.updateProductSales(productSales);
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
