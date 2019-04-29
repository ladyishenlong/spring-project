package com.ladyishenlong.springprojectmsql.mybatis;

import com.ladyishenlong.springprojectmsql.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();




}
