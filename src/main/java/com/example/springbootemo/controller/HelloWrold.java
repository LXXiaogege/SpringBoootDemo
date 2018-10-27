package com.example.springbootemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWrold {

    @GetMapping("/helloworld")
    public String  HeloWorld(){
        return "HelloWorld!";
    }
}
