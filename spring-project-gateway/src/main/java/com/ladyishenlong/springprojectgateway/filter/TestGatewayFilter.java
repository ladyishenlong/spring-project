package com.ladyishenlong.springprojectgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器
 * 配置文件添加过滤器参考 https://www.jianshu.com/p/7112871e7fc7
 * 局部的过滤器执行顺序默认优先于全局过滤器
 * 参考：http://springcloud.cn/view/266
 */
@Slf4j
@Component
public class TestGatewayFilter implements GatewayFilter, Ordered {

    //用来统计某个或者某种路由的时长
    private static final String COUNT_START_TIME = "countStartTime";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("----进入TestGatewayFilter----");
        log.info("请求路径：{}",exchange.getRequest().getURI());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(COUNT_START_TIME);
            if (startTime != null) {
                Long duration = (System.currentTimeMillis() - startTime);
                log.info("{} 持续时间： {} 毫秒", exchange.getRequest().getURI(), duration);
            }
        }));    }




    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;//可以根据数字来确定优先顺序
    }


}
