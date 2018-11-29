package com.example.springbootemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvixn
 * @date 2018/11/29 18:00
 */
//用来配置队列、交换器、路由等高级信息
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue HelloQueue(){
        return new Queue("hello");
    }

}
