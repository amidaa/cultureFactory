package com.first.group.Controller;

import com.alibaba.fastjson.JSONObject;
import com.first.group.entity.Authority;
import com.first.group.entity.UserInformation;
import com.first.group.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AuthorityApi")
public class AuthorityController {

    private AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService){
        this.authorityService = authorityService;
    }


    @PostMapping("/add")
    public Object addUser(@RequestBody Authority authority) {
        Authority aty = authorityService.addAuthority(authority);
        JSONObject jsonObject = new JSONObject();
        if(aty==null) {
            jsonObject.put("message", "用户添加失败");
        }else{
            jsonObject.put("message", "用户添加成功");
            jsonObject.put("user",aty);
        }

        return jsonObject;
    }

    @GetMapping("/findById/{authorityId}")
    public Object findByUserId(@PathVariable int auyhorityId) {
        Authority authority = authorityService.findAuthority(auyhorityId);
        JSONObject jsonObject = new JSONObject();
        if(authority == null) {
            jsonObject.put("message", "该用户不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该用户存在");
            jsonObject.put("authority",authority);
            return jsonObject;
        }



    }

    @GetMapping("/findAllAuthority")
    public Object findAllAuthority() {
        List<Authority> authorities = authorityService.findAllAuthority();
        JSONObject jsonObject = new JSONObject();
        if(authorities== null||authorities.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("allAuthority",authorities);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{authorityId}")
    public Object deleteUser(@PathVariable int authorityId){
        int result = authorityService.deleteAuthority(authorityId);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }



}
