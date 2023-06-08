package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiuYi
 * @Date 2023/6/5  16:36
 * @Desc 又是充满希望的一天
 */
@Service
public class TestService {

    private static final ThreadPoolExecutor executorService =
            new ThreadPoolExecutor(5, 50, 60L, TimeUnit.SECONDS,
                    new SynchronousQueue<>(), new ThreadFactory() {
                private AtomicInteger count = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("threadPool-" + count.addAndGet(1));
                    return thread;
                }
            });

    public void test(){
        System.out.println(executorService.getCorePoolSize());
        System.out.println(executorService.getPoolSize());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试线程什么时候被创建");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试线程什么时候被创建");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试线程什么时候被创建");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试线程什么时候被创建");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试线程什么时候被创建");
            }
        });
        System.out.println(executorService.getPoolSize());
    }
}
