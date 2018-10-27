package com.example.springbootemo.repo;

import com.example.springbootemo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepo extends JpaRepository<Girl,Integer> {
    public Girl findOneByAge(Integer age);
}
