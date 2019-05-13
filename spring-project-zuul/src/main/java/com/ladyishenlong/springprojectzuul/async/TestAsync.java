package com.ladyishenlong.springprojectzuul.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

@Slf4j
public class TestAsync {

    @Autowired
    private SyncTask syncTask;


    public void test() throws InterruptedException {
        log.info("开始测试AsyncTask");
        long start = System.currentTimeMillis();

        Future<String> r1 = syncTask.doTaskA();
        Future<String> r2 = syncTask.doTaskB();
        Future<String> r3 = syncTask.doTaskC();


        while (true) {
            // 三个任务都调用完成，退出循环等待
            if (r1.isDone() && r2.isDone() && r3.isDone()) {
                break;
            }
            Thread.sleep(100);
        }

        long end = System.currentTimeMillis();
        log.info("结束测试AsyncTask，耗时：" + (end - start) + "ms");
    }


}
