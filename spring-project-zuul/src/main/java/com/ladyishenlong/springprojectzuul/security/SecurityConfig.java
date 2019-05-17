package com.ladyishenlong.springprojectzuul.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.session.security.web.authentication.SpringSessionRememberMeServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
                .and().authorizeRequests()
//                .antMatchers("/hello/**").permitAll()
                .antMatchers("/registry").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
//                .loginPage("/sign_in")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/personal_center",true)
//                .failureUrl("/sign_in?error").permitAll()
//                .and().sessionManagement().invalidSessionUrl("/sign_in")
//                .and().rememberMe().tokenValiditySeconds(1209600)
//                .and().logout().logoutSuccessUrl("/sign_in").permitAll()
                .and().csrf().disable();
    }


//    @Bean
    public RememberMeServices rememberMeServices() {
        SpringSessionRememberMeServices rememberMeServices = new SpringSessionRememberMeServices();

        //设置1000秒后过期
        rememberMeServices.setValiditySeconds(1000);
        return rememberMeServices;
    }

}
