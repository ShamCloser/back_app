package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/7
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/").setViewName("success");
    }
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("login.html").setViewName("login");
                registry.addViewController("login").setViewName("login");
//                registry.addViewController("/").setViewName("login");
                registry.addViewController("main.html").setViewName("index");
//                registry.addViewController("empList.html").setViewName("empList");
//                registry.addViewController("empAdd.html").setViewName("empAdd");
            }
        };
        return adapter;
    }
}
