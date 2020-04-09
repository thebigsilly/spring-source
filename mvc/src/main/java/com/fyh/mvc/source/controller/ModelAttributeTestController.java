package com.fyh.mvc.source.controller;

import com.fyh.mvc.source.dtd.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelAttributeTestController {
    @ModelAttribute
    public void init(Model model, Integer age, String name) {
        model.addAttribute(new Person(age, name));
    }
    @ModelAttribute
    @GetMapping("testModelAttribute")
    public String testModelAttribute(Person person) {
        return person.toString();
    }

}
