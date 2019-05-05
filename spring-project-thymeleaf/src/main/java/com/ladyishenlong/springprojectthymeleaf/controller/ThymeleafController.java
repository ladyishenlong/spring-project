package com.ladyishenlong.springprojectthymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller //这里用RestController会导致无法返回页面
@RequestMapping(value="/th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name","haozz");
        return "/index";
    }
}
