package com.ladyishenlong.springprojectthymeleaf.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {

    private Long id;
    private String userName;
    private int age;

    public UserModel(Long id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
