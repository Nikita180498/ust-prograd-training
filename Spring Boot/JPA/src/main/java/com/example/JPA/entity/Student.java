package com.example.JPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String batch;
    private Float marks;
    @Column(nullable = false)
    private Integer age;
    @Column(name = "contact",nullable = false, unique = true, updatable = false)
    private String contact;

    public Student(){}

    public Student(String name, String batch, Float marks, Integer age, String contact){
        this.name=name;
        this.batch=batch;
        this.marks=marks;
        this.age=age;
        this.contact= String.valueOf(contact);
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getBatch(){
        return batch;
    }
    public void setBatch(String batch){
        this.batch=batch;
    }
    public Float getMarks(){
        return marks;
    }
    public void setMarks(Float marks){
        this.marks=marks;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age=age;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
