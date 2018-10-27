package com.example.springbootemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootemoApplication.class, args);
// 自定义SpringApplication
//        SpringApplication app=new SpringApplication(SpringbootemoApplication.class);
//        app.run(args);
    }
}
