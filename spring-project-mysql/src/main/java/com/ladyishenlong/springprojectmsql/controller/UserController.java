package com.ladyishenlong.springprojectmsql.controller;

import com.ladyishenlong.springprojectmsql.model.UserModel;
import com.ladyishenlong.springprojectmsql.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("/findByUsername")
    public UserModel findByUser(@RequestParam("username") String username) {
        UserModel userModel = userMapper.findByUsername(username);
        return userModel;
    }


}
