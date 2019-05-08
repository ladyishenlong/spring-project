package com.ladyishenlong.springprojectgateway.security;

import com.ladyishenlong.springprojectgateway.client.SqlClient;
import com.ladyishenlong.springprojectgateway.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

/**
 * 根据用户名从数据库获取密码
 * 进行比对
 */
@Slf4j
@EnableWebFluxSecurity
public class WebReactiveUserDetailsService implements ReactiveUserDetailsService {

//    @Autowired
//    private UserService userService;//自定义的连接用户数据库服务

    @Autowired
    private SqlClient sqlClient;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        log.info("----登录用户名：{}----",username);

        //spring security提供的默认的加密方式
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        com.jokerchen.reactiveWeb.entity.User defUser = userService.findUserByUsername(username);

        //从数据库查询用户信息
        UserModel userModel = sqlClient.findByUsername(username);


        UserDetails user = User.withUsername(userModel.getUsername())
                .password(encoder.encode(userModel.getPassword()))
                .roles("user")
                .build();
        return Mono.just(user);

//        return Mono.just(User.withUsername("name")
//                .password(encoder.encode("123"))
//                .roles("user").build());
    }


}
