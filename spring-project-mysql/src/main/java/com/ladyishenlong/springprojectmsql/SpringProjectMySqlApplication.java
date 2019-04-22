package com.ladyishenlong.springprojectmsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *  连接docker的mysql教程 https://www.cnblogs.com/yui66/p/9728732.html
 *
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringProjectMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectMySqlApplication.class, args);
    }

}
