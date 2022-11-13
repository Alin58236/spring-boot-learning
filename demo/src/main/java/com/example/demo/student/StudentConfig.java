package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student Alin = new Student(

                    "Alin",

                    LocalDate.of(2001, AUGUST,2),
                    "alin58236@gmail.com"
            );
            Student Ana = new Student(
                    "Ana",

                    LocalDate.of(2004, JANUARY,23),
                    "anutoiua@gmail.com"
            );

            studentRepository.saveAll(List.of(Alin,Ana));//salveaza toate entry-urile noi de mai sus in repo care va fi transmis apoi lui PostgreSQL
        };
    }
}
