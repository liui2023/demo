package com.example.demo.service;

import com.example.demo.dto.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * @Author LiuYi
 * @Date 2023/6/15  14:16
 * @Desc 又是充满希望的一天
 */
@Service
public class ThreadService {

    @Autowired
    private Executor myThread;

    public CompletableFuture<String> test() {
        // runTask() 你要异步运行的方法
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()
                -> runTask(), myThread);

        return completableFuture;

    }

    private <U> U runTask() {
        System.out.println("ceishi");
        return null;
    }
}
