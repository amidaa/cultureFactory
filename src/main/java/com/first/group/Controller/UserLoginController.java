package com.first.group.Controller;
import com.first.group.entity.UserAuthority;
import com.first.group.entity.UserInformation;
import com.first.group.service.UserAuthorityService;
import com.first.group.service.UserService;
import com.first.group.util.PassWordToHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

@RestController
@RequestMapping("/UserApi")
public class UserLoginController {

    private UserService userService;
    private UserAuthorityService userAuthorityService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public UserLoginController(UserService userService,UserAuthorityService userAuthorityService) {
        this.userService = userService;
        this.userAuthorityService=userAuthorityService;
    }
    @PostMapping("/login")
    public Object login(@RequestBody UserInformation userInformation) {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("登录trace");
        logger.debug("登录 debug");
        logger.info("登录info");
        logger.warn("登录warn");
        UserInformation user = userService.comparePassword(userInformation.getUserid(),userInformation.getPassword());
        JSONObject jsonObject = new JSONObject();
        if(user==null) {
            logger.error("登录error");
            jsonObject.put("message", "用户不存在");
        }else{
            jsonObject.put("message", "用户存在");
            jsonObject.put("user",user);
            logger.info("登录info");
        }

        return jsonObject;
    }

    @PostMapping("/add")
    public Object addUser(@RequestBody UserInformation userInformation) {
        PassWordToHash passWordToHash = new PassWordToHash();
        userInformation.setPassword(passWordToHash.passwordToHash(userInformation.getPassword()));
        UserInformation user = userService.addUser(userInformation);
        JSONObject jsonObject = new JSONObject();
        if(user==null) {
            jsonObject.put("message", "用户添加失败");
        }else{
            jsonObject.put("message", "用户添加成功");
            jsonObject.put("user",user);
        }

        return jsonObject;
    }

    @GetMapping("/findById/{userId}")
    public Object findByUserId(@PathVariable String userId) {
        UserInformation userInformation = new UserInformation();
        userInformation.setUserid(userId);
        UserInformation user = userService.findUser(userInformation);
        JSONObject jsonObject = new JSONObject();
        if(user == null) {
            jsonObject.put("message", "该用户不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该用户存在");
            jsonObject.put("user",user);
            return jsonObject;
        }



    }

    @GetMapping("/findAuthority/{userId}")
    public Object findAu(@PathVariable String userId) {
        UserAuthority authority = userAuthorityService.findOne(userId);
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

    @GetMapping("/findAllUser")
    public Object findAllUser() {
        List<UserInformation> users = userService.findAllUser();
        JSONObject jsonObject = new JSONObject();
        if(users == null||users.isEmpty()) {
            jsonObject.put("message", "查找失败");
            return jsonObject;
        }else {
            jsonObject.put("message", "查找成功");
            jsonObject.put("user",users);
            return jsonObject;
        }



    }

    @DeleteMapping("/delete/{userId}")
    public Object deleteUser(@PathVariable String userId){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserid(userId);
        int result = userService.deleteUser(userInformation);
        JSONObject jsonObject = new JSONObject();
        if(result!=0){

            jsonObject.put("result",1);
        }else {
            jsonObject.put("result",0);
        }
        return jsonObject;

    }

    @PutMapping("/update")
    public Object updateUser(@RequestBody UserInformation userInformation){
        UserInformation user = userService.updateUser(userInformation);
        JSONObject jsonObject = new JSONObject();
        if(user == null) {
            jsonObject.put("message", "该用户信息不存在");
            return jsonObject;
        }else {
            jsonObject.put("message", "该用户存在");
            jsonObject.put("user",user);
            return jsonObject;
        }

    }







}




