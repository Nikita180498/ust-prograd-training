package com.example.JPA.controller;

import com.example.JPA.entity.Student;
import com.example.JPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class JpaController {
  @Autowired
    private StudentService service;

//  @RequestMapping("/")
//    public String index(){
//      Student student = new Student("Nikita","2a",100.0f,21,"8989878767");
//      service.saveStudent(student);
//      return "Student saved";
//  }

    @RequestMapping("/create")
    public Student create(HttpServletRequest request){
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        Student student= new Student(name, "2A",87.90F, 23, contact);
        return  service.saveStudent(student);
    }



  @RequestMapping("/list")
    public List<Student> list(){
      return service.listAll();
  }
}
