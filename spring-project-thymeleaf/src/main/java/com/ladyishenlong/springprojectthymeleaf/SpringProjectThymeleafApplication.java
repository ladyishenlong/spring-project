package com.ladyishenlong.springprojectthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 参考文档 https://www.cnblogs.com/baiye195/p/9220515.html
 */
@EnableScheduling
@SpringBootApplication
public class SpringProjectThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectThymeleafApplication.class, args);
    }

}

