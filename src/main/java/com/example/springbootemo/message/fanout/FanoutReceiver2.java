package com.example.springbootemo.message.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 12:20
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver B  : " + message);
    }

}