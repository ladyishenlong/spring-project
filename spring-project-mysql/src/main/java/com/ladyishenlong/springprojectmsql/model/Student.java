package com.ladyishenlong.springprojectmsql.model;

import lombok.Data;
import reactor.core.publisher.MonoSink;

import javax.persistence.*;
import java.util.function.Consumer;

@Table(name="student")
@Entity
@Data
public class Student{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;
    private int age;


}
