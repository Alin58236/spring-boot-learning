package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//this class will serve as the API for students (routes info)
@RestController
@RequestMapping(path="api/v1/student") //ca sa primeasca request-uri pe URI-ul specificat
public class StudentController {

    private final StudentService studentService;//its not going to work because below we didnt reference it as "new StudentService()".
    //we will solve this problem by using @ and dependency injection

    @Autowired //this will instantiate the arguments. We must also tell Spring that this StudentService is a class that must be instantiated, so it will be a @Bean -> $see StudentService class$
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }


    @GetMapping // annotation for the app to be served as a rest method
    public List<Student> getStudents(){
        return studentService.getStudents(); // -->>
    }

    //controllerul apeleaza logica din service pentru a routa info catre browser.
    //logica e acum in serviciu.

    //flow-ul logic de date este: StudentController apeleaza getStudents() din StudentService -> StudentService ia info din DB si returneaza in controller -> controller-ul fucntioneaza ca un API si da info mai departe in browser.
}
