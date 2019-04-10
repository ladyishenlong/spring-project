package com.ladyishenlong.springprojectgateway.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求格式
 * <p>
 * {
 * "name": "名字",
 * "age": 404
 * }
 */
@Data
public class HelloModel implements Serializable {
    private String name;
    private int age;
}


