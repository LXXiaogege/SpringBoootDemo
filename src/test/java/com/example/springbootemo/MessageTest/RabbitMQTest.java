package com.example.springbootemo.MessageTest;

import com.example.springbootemo.domain.Girl;
import com.example.springbootemo.message.fanout.FanoutSender;
import com.example.springbootemo.message.many.Sender1;
import com.example.springbootemo.message.many.Sender2;
import com.example.springbootemo.message.object.ObjectSender;
import com.example.springbootemo.message.one.Sender;
import com.example.springbootemo.message.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lvixn
 * @date 2018/11/29 18:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private Sender sender;
    @Test
    public void oneToOne(){
        sender.sendOne();
    }

    @Autowired
    private Sender1 sender1;
    @Test
    public void oneToMany(){
        for (int i=0;i<100;i++){
            sender1.send(i);
        }
    }
    @Autowired
    private Sender2 sender2;
    @Test
    public void manyToMany(){
        for (int i=0;i<100;i++) {
            sender1.send(i);
            sender2.send(i);
        }
    }

    @Autowired
    private ObjectSender objectSender;
    @Test
    public void objectTest(){
        Girl girl=new Girl("cc",20,"woman");
        objectSender.send(girl);
    }

    @Autowired
    private TopicSender topicSender;
    @Test
    public void topicTest(){
        topicSender.send1();
    }

    @Autowired
    private FanoutSender fanoutSender;
    @Test
    public void fanoutTest(){
        fanoutSender.send();
    }
}
