package com.fyh.mvc.source.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @GetMapping("/initBinderTest")
    public String initBinderTest(Date date) {
        return DateFormat.getDateInstance().format(date);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
