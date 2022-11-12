package com.example.demo.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//this class will serve as the API for students
@RestController
@RequestMapping(path="api/v1/student") //ca sa primeasca request-uri pe URI-ul specificat
public class StudentController {

    @GetMapping // annotation for the app to be served as a rest method
    public List<Student> Hello(){
        return List.of(new Student(1L,"Alin",21, LocalDate.of(2001, Month.AUGUST,2),"alin58236@gmail.com"));
    }

}
