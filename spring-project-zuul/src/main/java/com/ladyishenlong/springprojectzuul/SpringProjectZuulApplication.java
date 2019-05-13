package com.ladyishenlong.springprojectzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication

//启用zuul网关
@EnableZuulProxy

//注册过滤器
@ServletComponentScan("com.ladyishenlong.springprojectzuul.filter")
@EnableAsync

public class SpringProjectZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectZuulApplication.class, args);
    }

}
