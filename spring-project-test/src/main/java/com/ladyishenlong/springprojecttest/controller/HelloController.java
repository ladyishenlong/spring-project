package com.ladyishenlong.springprojecttest.controller;

import com.ladyishenlong.springprojecttest.model.HelloModel;
import feign.Body;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }


    @GetMapping("/hello2")
    public String hello2(@RequestParam("value")String value){
        return "获得了参数："+value;
    }


    @PostMapping("/hello3")
    public HelloModel hello3(@RequestBody HelloModel helloModel){
        return helloModel;
    }


    @GetMapping("/hello4")
    public String hello4(HttpServletRequest request){
        return "请求头为："+request.getHeader("test");
    }

}
