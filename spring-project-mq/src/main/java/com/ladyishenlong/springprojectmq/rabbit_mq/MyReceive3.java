package com.ladyishenlong.springprojectmq.rabbit_mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RabbitListener(queues = {"kinson2"})
public class MyReceive3 {
    @RabbitHandler
    public void receiver(String msg) {
        log.info("队列2---MyReceive3接收信息:" + msg);
    }
}
