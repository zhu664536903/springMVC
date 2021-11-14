package com.gczhu.controller;

import com.alibaba.fastjson.JSON;
import com.gczhu.dto.DtoUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/user/")
public class UserController {

    //@ResponseBody
    @RequestMapping("test")
    public String test(@RequestParam("age") String s){
        System.out.println(s);
        return "index";
    }
    //restful
    @RequestMapping("restful/{a}")
    @ResponseBody
    public String restful(@PathVariable String a){
        return a;
    }
    //文件上传
    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("filename") MultipartFile file,HttpServletRequest request) throws IOException {
        //创建文件目录
        String path = request.getServletContext().getRealPath("/upload");
        File dir = new File(path);
        if(!dir.exists()) dir.mkdirs();
        //创建文件
        File filePath = new File(dir ,File.separator+file.getOriginalFilename());
        if (! filePath.exists()) filePath.createNewFile();

        System.out.println(file.getName());
        System.out.println(file.getSize());
        //保存文件，也可以自行保存
        file.transferTo(filePath);

        return "upload";
    }

    //重定向
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:http://www.baidu.com";
    }

    //接收json参数
    @RequestMapping(value = "/json")
    @ResponseBody
    public DtoUser json(@RequestBody DtoUser dtoUser){
        return dtoUser;
    }

    //消息转换器
    @RequestMapping("/msgConverter")
    @ResponseBody
    public DtoUser msg(){
        return new DtoUser("名字","22");

    }
}
