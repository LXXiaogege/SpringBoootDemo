package com.example.springbootemo.controller;

import com.example.springbootemo.domain.Girl;
import com.example.springbootemo.repo.GirlRepo;
import com.example.springbootemo.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
//@RequestMapping(value = "/girl")
public class GirlController {

    private final static Logger logger=LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepo girlRepo;

    @Autowired
    private GirlService girlService;

    //get方法，查找返回所有女孩
    @GetMapping(value = "/girls")
    public List<Girl> findAll(){
        logger.info("List<Girl>!");
        return girlRepo.findAll();
    }
    //post方法，查找并返回一个Girl
    @PostMapping(value = "/girls/{id}")
    public Girl findOne(@PathVariable("id") Integer id){
        return girlRepo.findById(id).get();
    }
    //增加一个Girl
    @PostMapping(value = "/girls")
    public void addOne(){
        Girl girl=new Girl(
                "新垣结衣酱",
                20,
                "nv"
        );
        girlRepo.save(girl);
    }
    //删除一个Girl
    @DeleteMapping(value = "/girls/{id}")
    public void deleteOne(@PathVariable("id") Integer id){
        girlRepo.deleteById(id);
    }
    //修改一个Girl
    //在Body的x.www.from中执行
    @PutMapping(value = "/girls/{id}")
    public Girl update(@PathVariable("id") Integer id,
                       @PathParam("name") String name,
                       @PathParam("age") Integer age,
                       @PathParam("sex") String sex){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(18);
        girl.setSex(sex);
        return girlRepo.save(girl);
    }

}
