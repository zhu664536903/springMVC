package com.gczhu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * web工程的初始化类，用来代替web.xml
 */
public class WebInit  extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * spring配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * mvc配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    /**
       指定前端控制器的映射路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        filter.setForceResponseEncoding(true);
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("characterEncodingFilter", filter);
        /**
         * dispatcherTypes分发类型，如果为null默认为Request
         * isMatchAfter定义过滤器的优先级，为false代表最先执行，为true则按定义顺序执行
         * 也可以实现getServletFilters方法，但是无法自定义映射，默认为dispatcher
         */
        dynamic.addMappingForUrlPatterns(null,false,"/*");
    }

    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }
}
