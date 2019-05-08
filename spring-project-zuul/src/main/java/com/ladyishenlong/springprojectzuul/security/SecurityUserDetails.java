package com.ladyishenlong.springprojectzuul.security;

import com.ladyishenlong.springprojectzuul.client.SqlClient;
import com.ladyishenlong.springprojectzuul.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 验证用户登录信息
 */
@Slf4j
@Component
public class SecurityUserDetails implements UserDetailsService {

    /**
     * 调用远程接口
     * 从数据库获取用户数据
     */
    @Autowired
    private SqlClient sqlClient;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("----请求登录用户：{}----", username);

        //不加密密码会报错
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserModel userModel = sqlClient.findByUsername(username);

        if (userModel == null) throw new UsernameNotFoundException(username);

        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(userModel.getRoles()));

        return new User(userModel.getUsername(),
                encoder.encode(userModel.getPassword()),
                authorities);
    }


}
