package com.example.springbootemo.domain;

import javax.persistence.*;

//1. 实体类
@Entity
@Table(name="Girl")
public class Girl {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    public Girl() {
    }

    public Girl(String name,Integer age, String sex) {
        this.name=name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString(){
        return "Girl{" +
                "id="+id+
                ", name="+name+
                ", age="+age+
                ", sex="+sex+
                "}";
    }
}
