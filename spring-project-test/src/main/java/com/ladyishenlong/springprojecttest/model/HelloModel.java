package com.ladyishenlong.springprojecttest.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class HelloModel implements Serializable {
    private String name;
    private int age;

}
