package com.example.springbootemo.service;

import com.example.springbootemo.domain.Girl;
import com.example.springbootemo.repo.GirlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GirlService{
    @Autowired
    private GirlRepo girlRepo;
//add一个girl
    public void save(){
        Girl girl=new Girl(
                "xiaowang",
                18,
                "nan"
        );
        girlRepo.save(girl);
    }
//通过id delete一个girl
    public void delete(Integer id){
        girlRepo.deleteById(id);
    }
//通过id find一个girl
    public Girl find(Integer id){
    return girlRepo.findById(id).get();
    }

}
