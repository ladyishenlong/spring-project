package com.ladyishenlong.springprojectgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TestFilter implements GlobalFilter, Ordered {

    private static final String TEST_HEADER= "hello";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("请求的路径："+exchange.getRequest().getURI());
//        ServerHttpResponse response = exchange.getResponse();
//        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        response.getHeaders().add(TEST_HEADER,"*");

        exchange.getRequest().getHeaders().set(TEST_HEADER,"*");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }
}
