package com.example.demo.student;

//this class serves as the business logic for managing students
//this service will talk to the Data Access Layer to retrieve info from the DB
//this class contains the logic

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service //identical with @Bean or @Component but more specific
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }//serviciul va folosi acum interfata (legatura cu BD)

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }//folosim findAll pentru ca intoarce o lista

    public void addNewStudent(Student student) {
        System.out.println(student);
    }

    //serves the info to the controller
    //needs routing logic (in Spring is called wiring, and it tells the controller to get the info from the service)
}
