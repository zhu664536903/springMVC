package com.gczhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//这个注解用来增强控制器，常用来处理控制器抛出的异常
@ControllerAdvice
public class ExceptionController {
    //这个注解用来定义处理具体异常的控制器
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handler(Exception e){
        return e.getMessage();
    }

}
