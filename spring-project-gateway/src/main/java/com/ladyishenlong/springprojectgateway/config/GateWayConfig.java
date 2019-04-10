package com.ladyishenlong.springprojectgateway.config;

import com.ladyishenlong.springprojectgateway.filter.TestFilter;
import com.ladyishenlong.springprojectgateway.model.HelloModel;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关
 * 路由默认都是get请求
 */
@RestController
public class GateWayConfig {

    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return builder.routes()

                //普通get请求
                .route(r -> r.path("/hello")
                        .uri("http://localhost:10001/hello"))

                //参数名为value的get请求
                .route(r -> r.path("/hello2")
                        .and().query("value")
                        .uri("http://localhost:10001/hello2"))

                //post请求，传入body
                .route(r -> r.readBody(HelloModel.class, body -> {
                    return true;
                }).and().path("/hello3")
                        .uri("http://localhost:10001/hello3"))

                //todo 添加请求头
                .route(r -> r.path("/hello4")
                        .filters(f -> f.filter(new TestFilter())
                                .addRequestHeader("hello",
                                        "head_hello"))//增加请求头
                        .uri("http://localhost:10001/hello4"))
                .build();
    }


}
