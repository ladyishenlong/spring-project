package com.ladyishenlong.springprojectgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//配置session存储后立刻刷新设置刷新模式为立刻刷新，否则可能获取不到session
//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringProjectGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectGatewayApplication.class, args);
    }


}
