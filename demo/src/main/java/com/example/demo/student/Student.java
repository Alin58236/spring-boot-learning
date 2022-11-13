package com.example.demo.student;

import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;

import javax.annotation.processing.Generated;
import javax.persistence.*; // make sure you always have this
import java.time.LocalDate;
import java.time.Period;

@Entity //for hibernate
@Table //for the table in our DB
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long id;
    private String name;
    @Transient //this field doesn't need to be a column -> it will be calculated so we will remove it from the constructors
    private Integer age;
    private LocalDate dob;
    private String email;

    public Student() {
    }

    public Student(String name, LocalDate dob, String email) {

        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }

}
