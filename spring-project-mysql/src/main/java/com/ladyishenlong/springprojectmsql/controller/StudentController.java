package com.ladyishenlong.springprojectmsql.controller;

import com.ladyishenlong.springprojectmsql.jpa.StudentRepository;
import com.ladyishenlong.springprojectmsql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAllStudent")
    public Mono getAllStudent() {
        return Mono.just(studentRepository.findAll());
    }


}
