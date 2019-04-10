//package com.ladyishenlong.springprojectgateway.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//public class AuthenticationManagerConfig extends GlobalAuthenticationConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        //密码需要用来解密
////        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//
//        auth.userDetailsService(userService);
//
//    }
//}
