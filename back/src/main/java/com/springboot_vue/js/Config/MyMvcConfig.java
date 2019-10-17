package com.springboot_vue.js.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/img_res/**").addResourceLocations("file:G:/temp/");
        registry.addResourceHandler("/img_aft/**").addResourceLocations("file:G:/test/");

    }


}
