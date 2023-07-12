package com.example.demo.test;

import java.util.concurrent.TimeUnit;

/**
 * @Author LiuYi
 * @Date 2023/7/12 13:52
 * @Desc 又是充满希望的一天
 */
public class TestDeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    // 写一个死锁
    public void deadLock0(){
        new Thread(() ->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + "获取lock1成功");
                try{
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取lock2锁");
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName() + "获取lock2成功");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() ->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + "获取lock2成功");
                try{
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取lock1锁");
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName() + "获取lock1成功");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        TestDeadLock d = new TestDeadLock();
        d.deadLock0();
    }
}
