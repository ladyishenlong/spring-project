package com.ladyishenlong.springprojectzuul.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 添加    @Async("asyncTaskExecutor") 注解就可以变为异步任务
 * 其中asyncTaskExecutor 是线程池的名字
 */
@Slf4j
@Component
public class SyncTask {


    @Async("asyncTaskExecutor")
    public Future<String> doTaskA() throws InterruptedException {
        log.info("开始任务A");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("结束任务A，耗时：" + (end - start) + "ms");
        return new AsyncResult("TaskA DONE");
    }

    @Async("asyncTaskExecutor")
    public Future<String> doTaskB() throws InterruptedException {
        log.info("开始任务B");
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        log.info("结束任务B，耗时：" + (end - start) + "ms");
        return new AsyncResult("TaskA DONE");
    }

    @Async("asyncTaskExecutor")
    public Future<String> doTaskC() throws InterruptedException {
        log.info("开始任务C");
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        log.info("结束任务C，耗时：" + (end - start) + "ms");
        return new AsyncResult("TaskA DONE");
    }


}
