package com.ladyishenlong.springprojectmq.rabbit_mq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单条消息发送给单个队列，该队列只有一个消费者
 */
@RestController
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/oneToOne")
    public void oneToOne() {
        amqpTemplate.convertAndSend("kinson", "这是我发送的消息");
    }

    /**
     * 一对多模式
     * <p>
     * 1.即一个生产者对多个消费者，该模式下可以是一个生产者将消息投递到一个队列，该队列对应多个消费者
     * ，此时每条消息只会被消费一次，多个消费者循环处理。
     * <p>
     * 2.另外也可以是一个生产者将消息投递到多个队列里，此时消息是被复制处理。
     */
    @GetMapping("/oneToMore1")
    public void oneToMore1() {
        //多条消息给同一个队列，消费者有多个，每个消息被消费一次，多个消费者循环处理
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("kinson", "这是我发送的消息"+i);
        }
    }

    @GetMapping("/oneToMore2")
    public void oneToMore2() {
        //同一个生产者发送给多个消费者，同样的消息两边都会处理
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("kinson", "这是我发送的消息"+i);
            amqpTemplate.convertAndSend("kinson2", "这是我发送的消息"+i);
        }
    }

}
