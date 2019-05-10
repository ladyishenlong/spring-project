package com.ladyishenlong.springprojectmsql.service;

import com.ladyishenlong.springprojectmsql.jpa.StudentRepository;
import com.ladyishenlong.springprojectmsql.mybatis.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;


    /**
     * 开始事务只需要添加注解即可
     */
    @Transactional
    public void transactionalTest() {

    }


}
