package com.example.JPA.service;

import com.example.JPA.entity.Student;
import com.example.JPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return  repository.save(student);
    }
    public List<Student> listAll(){
        return repository.findAll();
    }
}
