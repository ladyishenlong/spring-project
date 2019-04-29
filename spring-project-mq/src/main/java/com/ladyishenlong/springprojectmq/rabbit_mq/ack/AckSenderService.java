package com.ladyishenlong.springprojectmq.rabbit_mq.ack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 消息发送服务
 */
@Slf4j
@Service
public class AckSenderService implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        log.info("ack返回的信息" + message.toString() + "----" + i + "---"
                + s + "---" + s1 + "---" + s2);
    }

    /**
     * 发送消息
     */
    public void send(){
        final String content="当前时间："+ LocalDateTime.now(ZoneId.systemDefault());
        rabbitTemplate.setReturnCallback(this);//这是返回的回调

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if(b){
                    log.info("消息发送成功");
                }else {
                    log.info("消息发送失败："+s+correlationData.toString());
                }
            }
        });
        rabbitTemplate.convertAndSend("ackQueue",content);
    }

}
