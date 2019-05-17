package com.ladyishenlong.springprojecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@EnableRedisHttpSession
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringProjectTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectTestApplication.class, args);
    }

}
