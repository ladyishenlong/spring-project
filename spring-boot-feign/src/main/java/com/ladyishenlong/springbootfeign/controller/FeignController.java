package com.ladyishenlong.springbootfeign.controller;

import com.ladyishenlong.springbootfeign.client.HelloClient;
import com.ladyishenlong.springbootfeign.client.SqlClient;
import com.ladyishenlong.springbootfeign.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远程调用其他服务的接口
 */
@RestController
public class FeignController {

    @Autowired
    HelloClient helloClient;

    @Autowired
    SqlClient sqlClient;


    @GetMapping("/getHello")
    public String getHello() {
        return helloClient.hello();
    }


    @GetMapping("/getUser")
    public ResponseEntity getUser(@RequestParam("username") String username) {
        return ResponseEntity.ok(sqlClient.findByUsername(username));
    }


}
