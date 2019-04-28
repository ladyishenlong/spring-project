package com.ladyishenlong.springprojectmongodb.controller;

import com.ladyishenlong.springprojectmongodb.model.StudentModel;
import com.ladyishenlong.springprojectmongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *   配置参考 https://www.jianshu.com/p/3a8c1904e807
 *
 *   使用mongodb来储存数据
 */
@RestController
public class MongoController {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/setMongo")
    public void setMongo(){
        StudentModel studentModel=new StudentModel();
        studentModel.setId(10);
        studentModel.setAge(10);
        studentModel.setName("阿尔托莉雅");
        studentRepository.save(studentModel);
    }


    @GetMapping("/getMongo")
    public List<StudentModel> getMongo(){
        return studentRepository.findAll();
    }

}
