package com.example.demo.student;

//this class serves as the business logic for managing students
//this service will talk to the Data Access Layer to retrieve info from the DB
//this class contains the logic

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.SimpleTimeZone;

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
        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());//stocam in variabila studentul nou.
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
            //Daca deja exista emailul -> eroare
        }
        else
        {
            studentRepository.save(student);
            //. Daca nu, il inseram in baza de date.
            System.out.println(student);
        }

    }

    public void deleteStudent(Long studentId) {

        Boolean b = studentRepository.existsById(studentId);
        if(!b){
            throw new IllegalStateException("The user with id: "+studentId+" doesn't exist!");
        }
        else
        {
            studentRepository.deleteById(studentId);
        }
    }

    //serves the info to the controller
    //needs routing logic (in Spring is called wiring, and it tells the controller to get the info from the service)

    @Transactional //when we have this annotation the method has a managed state
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId).orElseThrow( () -> new IllegalStateException("Student with id "+studentId+" does not exist!"));

        if(name!= null && name.length() >0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!= null && email.length() >0 && !Objects.equals(student.getEmail(),email)){
            Optional <Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already Taken");
            }
            else
            {
                student.setEmail(email);
            }
        }
    }
}
