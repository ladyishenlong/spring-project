package com.ladyishenlong.springprojectmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消息队列：kafka rabbitmq
 * <p>
 * docker部署rabbitmq参考：
 * https://www.jianshu.com/p/14ffe0f3db94;
 * https://www.cnblogs.com/veitch-623/p/7743620.html
 *
 *
 */
@SpringBootApplication
public class SpringProjectMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectMqApplication.class, args);
    }

}
