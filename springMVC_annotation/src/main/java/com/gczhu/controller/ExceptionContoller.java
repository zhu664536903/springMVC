package com.gczhu.controller;

import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionContoller  {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody()
    public String exp(Exception e, HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        return e.getMessage();
    }
}
