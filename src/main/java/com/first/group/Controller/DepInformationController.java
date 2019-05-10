package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.BuyerInformation;
import com.first.group.entity.DepInformation;
import com.first.group.service.BuyerInformationService;
import com.first.group.service.DepInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DepInformationApi")
public class DepInformationController {

    private DepInformationService depInformationService;
    @Autowired
    public DepInformationController(DepInformationService depInformationService){
        this.depInformationService = depInformationService;
    }


    @PostMapping("/add")
    public Object addDep(@RequestBody DepInformation depInformation) {
        int result = depInformationService.addDepInformation(depInformation);
        JSONObject jsonObject = new JSONObject();
        if(result!=1) {
            jsonObject.put("message", "部门信息添加失败");
        }else{
            jsonObject.put("message", "部门信息添加成功");
        }

        return jsonObject;
    }

    @GetMapping("/findByDepId/{depId}")
    public Object findById(@PathVariable String depId) {
        DepInformation depInformation = depInformationService.findOne(depId);
        JSONObject jsonObject = new JSONObject();
        if(depInformation == null) {
            jsonObject.put("message", "该部门信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该部门信息存在");
            jsonObject.put("depInformation",depInformation);
            return jsonObject;
        }



    }

    @GetMapping("/findAllDepInformation")
    public Object findAllDepInformation() {
        List<DepInformation> informations = depInformationService.findAll();
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

    @DeleteMapping("/delete/{depId}")
    public Object deleteInformation(@PathVariable String depId){
        int result = depInformationService.deleteDepInformation(depId);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object updateDep(@RequestBody DepInformation depInformationn){
        int result = depInformationService.updateDepInformation(depInformationn);
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
