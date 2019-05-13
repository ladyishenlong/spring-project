package com.ladyishenlong.springprojectmsql.controller;

import com.ladyishenlong.springprojectmsql.jpa.StudentRepository;
import com.ladyishenlong.springprojectmsql.model.Student;
import com.ladyishenlong.springprojectmsql.mybatis.StudentMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/getAllStudentByJpa")
    public Mono getAllStudentByJpa() {
        return Mono.just(studentRepository.findAll());
    }


    @GetMapping("/getAllStudentByMyBatis")
    public Mono getAllStudentByMyBatis() {
        return Mono.just(studentMapper.findAll());
    }

//    参数填入路径
//    @GetMapping("get/{username}/{password}")
//    public User get(@PathVariable("username") String username, @PathVariable("password") String password) {
//        return userMapper.get(username, password);
//    }



    /**
     * jpa分页查询
     */
    @GetMapping("/findPageByJpa")
    public Mono<Page<Student>> findByPage(Pageable pageable) {
//        Pageable pageable = new PageRequest(currentPage, pagesize,
//                Sort.Direction.DESC, "keywords");
      return Mono.just(studentRepository.findAll(pageable));//jpa分页查询
    }


}
