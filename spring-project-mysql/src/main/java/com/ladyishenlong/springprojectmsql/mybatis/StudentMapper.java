package com.ladyishenlong.springprojectmsql.mybatis;

import com.ladyishenlong.springprojectmsql.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();




}
