package com.ladyishenlong.springprojectthymeleaf.schedul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Slf4j
@Component
public class SchedulerTask {


    /***
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
     * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次
     */
    @Scheduled(fixedDelay = 6000)
    public void task(){
        log.info("----定时任务输出：{}----","任务执行");
    }





}
