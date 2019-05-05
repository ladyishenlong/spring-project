package com.ladyishenlong.springprojectthymeleaf;

import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String userName;
    private int age;

    public UserModel(Long id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
