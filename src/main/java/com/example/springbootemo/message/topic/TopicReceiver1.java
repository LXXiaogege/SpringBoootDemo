package com.example.springbootemo.message.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 10:54
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Topic.Message:"+message);
    }
}
