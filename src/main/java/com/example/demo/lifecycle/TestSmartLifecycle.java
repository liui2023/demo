package com.example.demo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class TestSmartLifecycle implements ApplicationContextAware, SmartLifecycle {

    private volatile boolean running = false;
    @Override
    public void start() {
        System.out.println("TMyLifeCycle组件的运行了!");
        running = true;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        System.out.println("检查MyLifeCycle组件的运行状态：" + running);
        return running;
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
