package com.example.HelloUST;

import org.springframework.stereotype.Component;

@Component
public class StudentMarks {

    private String name;
    private int marks;

    public StudentMarks(){
        System.out.println("Student marks object created");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name= name;
    }

    public int getMarks(){
        return marks;
    }

    public void setMarks(){
        this.marks= marks;
    }

    public void display(){
        System.out.println("inside show");
    }

}
