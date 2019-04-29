package com.ladyishenlong.springprojectmsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *  连接docker的mysql教程 https://www.cnblogs.com/yui66/p/9728732.html
 *
 *
 */
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringProjectMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectMySqlApplication.class, args);
    }

}
