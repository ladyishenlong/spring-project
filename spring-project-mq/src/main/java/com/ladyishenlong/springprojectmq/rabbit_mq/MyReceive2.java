package com.ladyishenlong.springprojectmq.rabbit_mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
@RabbitListener(queues = {"kinson"})
public class MyReceive2 {

    @RabbitHandler
    public void receiver(String msg) {
        log.info("队列1--MyReceive2接收信息:" + msg);
    }
}
