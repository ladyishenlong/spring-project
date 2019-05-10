package com.ladyishenlong.springprojectthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/js")
public class JSController {

    @GetMapping("goToJs")
    public String goToJs() {
        return "/js";
    }

    @GetMapping("/getAjaxData")
    @ResponseBody
    public String getAjaxData(@RequestParam("value")String value){
        return value;
    }

}
