package com.ladyishenlong.springprojectredis.controller;

import com.ladyishenlong.springprojectredis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参考 https://www.cnblogs.com/garfieldcgf/p/6510762.html
 *
 * redis 存储数据 key-value的形式
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping("/helloRedis")
    public String helloRedis() {
        return "hello redis";
    }

    @GetMapping("/setRedis")
    public void setRedis() {
        redisService.setValue("key", "hello redis");
    }

    @GetMapping("/getRedis")
    public String getRedis() {
        return "从redis获得key的值是：" + redisService.getValue("key");
    }


}
