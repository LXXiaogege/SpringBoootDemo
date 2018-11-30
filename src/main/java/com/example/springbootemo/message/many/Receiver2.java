package com.example.springbootemo.message.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 9:18
 */
@Component
@RabbitListener(queues = "neo")
public class Receiver2 {

    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver 2: " + neo);
    }
}
