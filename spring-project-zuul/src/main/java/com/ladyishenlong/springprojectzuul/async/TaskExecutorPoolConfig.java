package com.ladyishenlong.springprojectzuul.async;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskExecutorPoolConfig {

    @Bean("asyncTaskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//线程池维护线程的最少数量
        executor.setMaxPoolSize(20); //线程池维护线程的最大数量
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(30); //线程池维护线程所允许的空闲时间,TimeUnit.SECONDS
        executor.setThreadNamePrefix("asyncTaskExecutor-");//线程池名的前缀
        // 线程池对拒绝任务的处理策略: CallerRunsPolicy策略，当线程池没有处理能力的时候
        // ，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }


}
