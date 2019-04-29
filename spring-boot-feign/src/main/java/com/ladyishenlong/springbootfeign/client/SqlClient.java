package com.ladyishenlong.springbootfeign.client;

import com.ladyishenlong.springbootfeign.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("spring-project-mysql")//远程的服务名
public interface SqlClient {


    @GetMapping("/user/findByUsername")//远程的地址
    UserModel findByUsername(@RequestParam("username")String username);
}
