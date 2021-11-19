package com.gczhu.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContoller {
    @RequestMapping(value = "/user/getUser")
    @ResponseBody
    public String getOneUser(){
        return "ok";
    }
    @RequestMapping(value = "/user/exception",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public String exception(){
        return "测试乱码";
        //throw  new RuntimeException("运行时异常");
    }
}
