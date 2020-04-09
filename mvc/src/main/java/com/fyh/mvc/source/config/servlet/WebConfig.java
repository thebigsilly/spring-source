package com.fyh.mvc.source.config.servlet;

import com.fyh.mvc.source.interceptor.InterceptorAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ImportResource(value = "classpath:spring-servlet.xml")
@EnableWebMvc
@ComponentScan(value = "com.fyh.mvc.source.controller", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorAnnotation());
    }
}
