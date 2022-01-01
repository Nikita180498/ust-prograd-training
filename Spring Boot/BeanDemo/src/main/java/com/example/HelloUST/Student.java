package com.example.HelloUST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int rollNo;
    private String name;

    @Autowired
    private StudentMarks studentMarks;

    public Student(){
        System.out.println("Student object created");
    }

    public int getRollNo(){
        return this.rollNo;
    }

    public void setRollNo(int rollNo){
        this.rollNo= rollNo;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name= name;
    }

    public void show(){
        studentMarks.display();
    }


}
