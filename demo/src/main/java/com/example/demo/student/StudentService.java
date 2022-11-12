package com.example.demo.student;

//this class serves as the business logic for managing students
//this service will talk to the Data Access Layer to retrieve info from the DB
//this class contains the logic

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service //identical with @Bean or @Component but more specific
public class StudentService {

    public List<Student> getStudents(){
        return List.of(new Student(1L,"Alin",21,LocalDate.of(2001,Month.AUGUST,2),"alin58236@gmail.com"));
    }

    //serves the info to the controller
    //needs routing logic (in Spring is called wiring, and it tells the controller to get the info from the service)
}
