//package com.ladyishenlong.springprojectgateway.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Slf4j
//@Component
//public class UserService implements UserDetailsService {
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("登陆的用户名：" + username);
//
//        if(!"name".equals(username))throw new UsernameNotFoundException(username);
//
//        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("admin"));
//
//        return new User(username,"123",  AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
//
//
//}
