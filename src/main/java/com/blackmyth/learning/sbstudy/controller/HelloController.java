package com.blackmyth.learning.sbstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value="/hello")
    public String hello() {
        System.out.println("Hello cucu!");
        return "Hello cucu!";
    }
}
