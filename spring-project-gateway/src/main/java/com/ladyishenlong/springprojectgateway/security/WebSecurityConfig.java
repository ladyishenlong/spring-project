package com.ladyishenlong.springprojectgateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity.authorizeExchange()
                .pathMatchers("/hello").hasRole("user")
//                .pathMatchers("/hello").permitAll()
                .pathMatchers("/swagger*//**").permitAll()
                .anyExchange()
                .authenticated()
                .and()
                .httpBasic()//配置http基本身份验证
                .and()
                .formLogin()//前往默认的登录页面
                .and()
//                .loginPage("/loginPage")//自定义登录页面
                .build();
    }


    //演示使用的
//    @Bean
    public MapReactiveUserDetailsService userDetailsService(){
        UserDetails userDetails= User.withDefaultPasswordEncoder()
                .username("name")
                .password("123")
                .roles("user")
                .build();
        return new MapReactiveUserDetailsService(userDetails);
    }





}
