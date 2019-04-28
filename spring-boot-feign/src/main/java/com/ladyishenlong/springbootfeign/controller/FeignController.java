package com.ladyishenlong.springbootfeign.controller;

import com.ladyishenlong.springbootfeign.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远程调用其他服务的接口
 */
@RestController
public class FeignController {

    @Autowired
    HelloClient helloClient;


    @GetMapping("/getHello")
    public String getHello(){
        return helloClient.hello();
    }


}
