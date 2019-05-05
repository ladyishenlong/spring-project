package com.ladyishenlong.springprojectthymeleaf.controller;

import com.ladyishenlong.springprojectthymeleaf.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller //不能写RestController
public class UserController {

    @GetMapping(value = "/getUserInfo")
    public String getUserInfo(Model model) {
        UserModel user = new UserModel(100L, "admin", 18);
        UserModel user2 = new UserModel(101L, "李四", 19);
        UserModel user3 = new UserModel(102L, "张三", 20);
        UserModel user4 = new UserModel(103L, "王五", 21);
        List<UserModel> list = new ArrayList<>();
        list.add(user2);
        list.add(user3);
        list.add(user4);
        model.addAttribute("user", "使用者");
        model.addAttribute("list", list);
        return "/user";//返回html的路径
    }
}
