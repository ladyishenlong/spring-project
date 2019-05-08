package com.ladyishenlong.springprojectgateway.controller;

import com.ladyishenlong.springprojectgateway.filter.HelloFilter;
import com.ladyishenlong.springprojectgateway.filter.TestGatewayFilter;
import com.ladyishenlong.springprojectgateway.model.HelloModel;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关
 * 路由默认都是get请求
 *
 * todo 了解下文件上传下载
 *
 */
@RestController
public class HelloController {

    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return builder.routes()

                //普通get请求
                .route(r -> r.path("/hello").uri("http://localhost:10001/hello"))

                //参数名为value的get请求
                .route(r -> r.path("/hello2").and().query("value")
                        .uri("http://localhost:10001/hello2"))

                //post请求，传入body
                .route(r -> r.readBody(HelloModel.class, body -> true).and()
                        .path("/hello3")
                        .uri("http://localhost:10001/hello3"))

                //拥有请求头的请求
                .route(r -> r.path("/hello4")
                        .filters(f -> f.filter(new HelloFilter()).addRequestHeader("hello", "head_hello"))//额外增加请求头
                        .uri("http://localhost:10001/hello4"))


                //使用模板做测试
                .route(r -> r.path("/thTest/test")
                        .filters(f->f.filter(new TestGatewayFilter())
                                .addRequestHeader("test","this is test add request header"))
                        .uri("http://localhost:10007/thTest/test"))


                .build();
    }



}
