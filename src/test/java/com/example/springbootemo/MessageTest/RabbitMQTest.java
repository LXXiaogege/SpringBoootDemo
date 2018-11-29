package com.example.springbootemo.MessageTest;

import com.example.springbootemo.message.Sender;
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
    public void test(){
        sender.sendOne();
    }

}
