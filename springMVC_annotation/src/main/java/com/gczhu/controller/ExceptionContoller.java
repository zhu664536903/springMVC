package com.gczhu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionContoller  {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody()
    public String exp(Exception e){
        return e.getMessage();
    }
}
