package com.example.springbootemo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lvixn
 * @date 2018/11/29 18:14
 */

//创建消息生产者
@Component
public class Sender {

    private final static Logger logger=LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendOne(){
        //发送到hello的队列中
        String context="hello"+new Date();
        logger.info("Sender:"+context);
        this.amqpTemplate.convertAndSend("hello",context);
    }
}
