package com.ladyishenlong.springprojectmsql.jpa;

import com.ladyishenlong.springprojectmsql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

     List<Student> findAll();



}
