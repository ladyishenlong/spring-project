package com.ladyishenlong.springprojectthymeleaf.controller;

import com.ladyishenlong.springprojectthymeleaf.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 尝试使用Ajax
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello ajax";
    }

    @GetMapping("/goToAjax")
    public String goToAjax(){
        return "/ajax";
    }


    @GetMapping("/getAjax")
    @ResponseBody
    public String getAjax(@RequestParam("value")String value){
        return "传入的参数是："+value;
    }


    @PostMapping("/postAjax")
    @ResponseBody
    public ResponseEntity postAjax(@RequestBody UserModel userModel){
        return ResponseEntity.ok(userModel);
    }

}
