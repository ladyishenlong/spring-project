package com.ladyishenlong.springprojectmsql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;



@Data
public class UserModel {


    private String username;

    private String password;

    private String roles;
}
