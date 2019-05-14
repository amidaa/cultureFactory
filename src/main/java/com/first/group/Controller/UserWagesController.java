package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.ProductSales;
import com.first.group.entity.UserWages;
import com.first.group.service.UserWageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/UserWagesApi")
public class UserWagesController {

    private UserWageService userWageService;
    @Autowired
    UserWagesController(UserWageService userWageService){
        this.userWageService = userWageService;
    }

    @PostMapping("/addlist")
    public Object addUser(@RequestBody List<UserWages> wages) {
        List<UserWages> userWages = userWageService.addUserWages(wages);
        JSONObject jsonObject = new JSONObject();
        if(userWages==null) {
            jsonObject.put("message", "用户工资信息添加失败");
        }else{
            jsonObject.put("message", "用户工资信息添加成功");
            jsonObject.put("wages",userWages);
        }

        return jsonObject;
    }

    @PostMapping("/add")
    public Object addUser(@RequestBody UserWages userWages) {
       UserWages wages = userWageService.addSingle(userWages);
        JSONObject jsonObject = new JSONObject();
        if(wages==null) {
            jsonObject.put("message", "商品销售信息添加失败");
        }else{
            jsonObject.put("message", "商品销售信息添加成功");
            jsonObject.put("product",wages);
        }

        return jsonObject;
    }


    @GetMapping("/findAll")
    public Object findAllWageInformation() {
        List<UserWages> wages = userWageService.findAll();
        JSONObject jsonObject = new JSONObject();
        if(wages == null||wages.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("wages",wages);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{id}")
    public Object deleteWage(@PathVariable int id){
        UserWages userWages = new UserWages();
        userWages.setWageid(id);
        int result = userWageService.delete(userWages);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object update(@RequestBody UserWages userWages){
        int result =userWageService.update(userWages);
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
