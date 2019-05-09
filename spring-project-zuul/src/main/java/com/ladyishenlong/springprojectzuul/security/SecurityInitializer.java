package com.ladyishenlong.springprojectzuul.security;

import com.ladyishenlong.springprojectzuul.config.RedisSessionConfig;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class, RedisSessionConfig.class);
    }

}
