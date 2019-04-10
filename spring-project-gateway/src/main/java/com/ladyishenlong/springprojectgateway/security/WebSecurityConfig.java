package com.ladyishenlong.springprojectgateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity.authorizeExchange()
//                .pathMatchers("/hello").permitAll()
                .anyExchange().authenticated()
                .and()
                .httpBasic().and()
                .formLogin().and()//默认的登录页面
//                .loginPage("/loginPage")//自定义登录页面
                .build();
    }

}
