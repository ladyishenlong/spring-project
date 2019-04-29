package com.ladyishenlong.springprojectmq;

import com.ladyishenlong.springprojectmq.rabbit_mq.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProjectMqApplicationTests {

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @Test
    public void contextLoads() {
    }


    @Test
    public void oneToOne(){
        rabbitMqSender.oneToOne();
    }

}
