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

/**
 * 这个controller 主要是与 zuul 的网关进行交互
 */
@Slf4j
@Controller
@RequestMapping("/thTest")
public class TestController {



    @GetMapping("/test")
    public String test(HttpServletRequest request, Model model) {

        //获取请求头
        String testHead = request.getHeader("test");
        log.info("----得到自定义加入的请求头：{}----", testHead);
        model.addAttribute("test", testHead);

        String username = request.getHeader("username");
        log.info("----登录用户{}----", username);
        model.addAttribute("username", username);

        return "/test";//模板页面路径
    }


}
