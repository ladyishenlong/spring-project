package com.ladyishenlong.springprojectmq.rabbit_mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 配置队列
 *
 * 消息队列，订阅消息队列，被动接受传过来的信息
 *
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue kinsonQueue(){
        return new Queue("kinson");
    }

    @Bean
    public Queue kinsonQueue2(){
        return new Queue("kinson2");
    }

}
