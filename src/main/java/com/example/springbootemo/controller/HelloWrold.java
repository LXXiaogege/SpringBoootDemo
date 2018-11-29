package com.example.springbootemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWrold {
    private final static Logger logger=LoggerFactory.getLogger(GirlController.class);
    @GetMapping("/helloworld")
    public String  HeloWorld(){
        logger.info("Hello World Started!!!");
        return "HelloWorld!";
    }
}
