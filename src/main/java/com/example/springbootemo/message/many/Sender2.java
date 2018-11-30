package com.example.springbootemo.message.many;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 9:16
 */
@Component
public class Sender2 {
    private final static Logger logger=LoggerFactory.getLogger(Sender1.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot neo queue"+" ****** "+i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("neo", context);
    }
}
