package com.ladyishenlong.springprojectnginx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 负载均衡 使用软件nginx 是两个同样的 接口 运行在不同的端口号上
 */
@SpringBootApplication
public class SpringProjectNginxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectNginxApplication.class, args);
    }

}
