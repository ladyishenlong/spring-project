package com.ladyishenlong.springprojectgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 这里可以进行添加请求头等操作
 * 局部过滤器，可以单独用于某次请求
 */
@Slf4j
@Component
public class HelloFilter implements GatewayFilter, Ordered {

    private static final String TEST_HEADER = "test";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("请求的路径：" + exchange.getRequest().getURI());
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        response.getHeaders().add(TEST_HEADER,"*");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }
}
