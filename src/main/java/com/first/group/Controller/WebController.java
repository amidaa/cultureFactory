package com.first.group.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class WebController {
        @RequestMapping({"/index"})
        public String index(){
            return"index";
        }

    @RequestMapping("/login")
    public String text(){
        return "login";
    }

}
