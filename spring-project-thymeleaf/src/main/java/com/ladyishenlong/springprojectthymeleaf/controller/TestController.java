package com.ladyishenlong.springprojectthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/thTest")
public class TestController {


    @GetMapping("/test")
    public String test(HttpServletRequest request, Model model){

        //获取请求头
        String testHead= request.getHeader("test");
        log.info("----得到自定义加入的请求头：{}----",testHead);
        model.addAttribute("test", testHead);

//        Principal principal = request.getUserPrincipal();
//        if(principal!=null){
//            log.info("----登陆的用户信息：{}----",principal.getName());
//        }




//        model.addAttribute("username", request.getHeader("username"));



        return "/test";//模板页面路径
    }



}
