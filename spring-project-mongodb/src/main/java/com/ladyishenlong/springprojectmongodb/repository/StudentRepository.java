package com.ladyishenlong.springprojectmongodb.repository;

import com.ladyishenlong.springprojectmongodb.model.StudentModel;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentRepository extends MongoRepository<StudentModel, Integer> {





}
