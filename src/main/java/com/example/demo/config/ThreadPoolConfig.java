package com.example.demo.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiuYi
 * @Date 2023/6/5  14:45
 * @Desc 又是充满希望的一天
 */
public class ThreadPoolConfig {

    public ThreadPoolTaskExecutor executor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 线程池核心线程大小
        executor.setCorePoolSize(5);
        // 线程池 最大线程数
        executor.setMaxPoolSize(10);
        //多余的空闲线程存活时间
        executor.setKeepAliveSeconds(5);
        //队列的大小
        executor.setQueueCapacity(200);
        return executor;
    }
}
