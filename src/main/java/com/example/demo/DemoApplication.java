package com.example.demo;

import com.example.demo.dto.UserDTO;
import com.example.demo.factory.BaseFactory;
import com.example.demo.test.TestA;
import com.example.demo.test.TestB;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

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

        SpringApplication.run(DemoApplication.class, args);
//        DemoApplication d = new DemoApplication();
//        d.deadLock0();
    }

}
