package com.ladyishenlong.springprojectzuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 09:21
 */
@RestController
public class MyZuulController {

    @GetMapping("/getSession")
    public String getSession(HttpSession httpSession){
        return "sessionId:"+httpSession.getId();
    }
}
