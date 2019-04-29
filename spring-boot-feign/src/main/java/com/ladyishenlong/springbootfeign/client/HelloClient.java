package com.ladyishenlong.springbootfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("spring-project-test")//远程的服务名
public interface HelloClient {

    @GetMapping("/hello")//远程的地址
    String hello();



}
