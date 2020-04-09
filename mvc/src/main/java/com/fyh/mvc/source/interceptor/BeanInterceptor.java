package com.fyh.mvc.source.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(value = 2)
public class BeanInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String breakFlag = request.getParameter("breakFlag");
        if (breakFlag != null && breakFlag.equals("true")) {
            response.setContentType("text/txt");
            System.out.println("BeanInterceptor break");
            response.getWriter().write("Break");
            return false;
        }
        System.out.println("BeanInterceptor preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("BeanInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("BeanInterceptor afterCompletion");
    }
}
