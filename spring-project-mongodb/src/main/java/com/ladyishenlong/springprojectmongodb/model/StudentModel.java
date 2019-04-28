package com.ladyishenlong.springprojectmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class StudentModel implements Serializable {


    @Id
    private int id;
    private int age;
    private String name;

}
