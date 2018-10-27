package com.example.springbootemo.girlservicetest;

import com.example.springbootemo.domain.Girl;
import com.example.springbootemo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    private final static Logger logger=LoggerFactory.getLogger(GirlService.class);

    @Autowired
    private GirlService girlService;

    @Test
//    @Transactional
    public void test(){
        girlService.save();
        Girl girl=girlService.find(1);
        Assert.assertEquals((Integer) 18,girl.getAge());
        girlService.delete(1);
    }
}
