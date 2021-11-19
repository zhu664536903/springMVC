package com.gczhu.config;

import com.gczhu.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.gczhu.controller"})
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver vr(){
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setPrefix("/WEB-INF/html");
        irvr.setSuffix(".html");
        return irvr;
    }
    //配置默认的servlet处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    //添加拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new TestInterceptor());
        interceptorRegistration.addPathPatterns("/user/**");
        interceptorRegistration.excludePathPatterns("/static/**");
    }


}
