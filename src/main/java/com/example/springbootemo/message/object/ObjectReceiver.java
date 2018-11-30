package com.example.springbootemo.message.object;

import com.example.springbootemo.domain.Girl;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 10:18
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(Girl girl){
        System.out.println("Receiver object:"+girl);
    }
}
