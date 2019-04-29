package com.ladyishenlong.springprojectmq.rabbit_mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * 消费者
 * 监听队列
 * 用来接收信息
 */
@Slf4j
@Configuration
@RabbitListener(queues = {"kinson"})
public class MyReceive1 {

    @RabbitHandler
    public void receiver(String msg) {
        log.info("队列1--MyReceive1接收信息:" + msg);
    }

}
