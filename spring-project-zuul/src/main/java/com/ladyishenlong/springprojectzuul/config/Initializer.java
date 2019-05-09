package com.ladyishenlong.springprojectzuul.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;

@Component
public class Initializer extends AbstractHttpSessionApplicationInitializer {
}
