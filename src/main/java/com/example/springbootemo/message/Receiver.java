package com.example.springbootemo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/29 18:21
 */
//创建消息消费者
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    private final static Logger logger=LoggerFactory.getLogger(Receiver.class);
    @RabbitHandler
    public void process(String hello){
        logger.info("Receiver:"+hello);
    }
}
