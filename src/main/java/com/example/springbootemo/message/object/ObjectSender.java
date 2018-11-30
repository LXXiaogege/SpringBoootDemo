package com.example.springbootemo.message.object;

import com.example.springbootemo.domain.Girl;
import com.example.springbootemo.message.many.Sender1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lvixn
 * @date 2018/11/30 10:17
 */
@Component
public class ObjectSender {
    private final static Logger logger=LoggerFactory.getLogger(Sender1.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Girl girl) {
        System.out.println("Sender Object : " + girl.toString());
        this.rabbitTemplate.convertAndSend("object", girl);
    }
}
