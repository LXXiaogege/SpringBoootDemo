package com.example.springbootemo.message.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 10:55
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String messages){
    System.out.println("Topic.Messages:"+messages);
    }
}
