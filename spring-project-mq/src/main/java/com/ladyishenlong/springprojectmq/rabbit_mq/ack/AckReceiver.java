package com.ladyishenlong.springprojectmq.rabbit_mq.ack;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * ack消息的消费者
 */
@Slf4j
@Component
@RabbitListener(queues = {"ackQueue"})
public class AckReceiver {

    @RabbitHandler
    public void process(String sendMsg, Channel channel, Message message) {

        log.info("AckReceiver  : 收到发送消息 " + sendMsg + ",收到消息时间"
                + LocalDateTime.now(ZoneId.systemDefault()));

        try {
            //告诉服务器收到这条消息已经被当前消费者消费了，可以在队列安全删除，这样后面就不会再重发了，
            //否则消息服务器以为这条消息没处理掉，后续还会再发
            //在队列上出之后，除非重启服务，再次发送会报错

            //第二个参数是消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("process success");
        } catch (Exception e) {
            log.info("process fail");
            e.printStackTrace();
        }

    }


}
