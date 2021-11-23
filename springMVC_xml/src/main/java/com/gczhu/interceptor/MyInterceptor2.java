package com.gczhu.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器2======》执行handler之前");
//        OutputStream outputStream = response.getOutputStream();
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter printWriter = new PrintWriter(outputStream);
//        printWriter.println("被拦截");
//        printWriter.flush();
//        printWriter.close();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器2======》执行handler之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器2======》视图解析后");
    }
}
