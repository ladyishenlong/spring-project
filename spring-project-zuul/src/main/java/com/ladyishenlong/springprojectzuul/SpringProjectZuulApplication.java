package com.ladyishenlong.springprojectzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.SessionRepositoryFilter;

@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EnableRedisHttpSession
//启用zuul网关
@EnableZuulProxy
//注册过滤器
@ServletComponentScan("com.ladyishenlong.springprojectzuul.filter")
@EnableAsync
@EnableCaching
public class SpringProjectZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectZuulApplication.class, args);
    }


}
