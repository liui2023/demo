package com.example.demo;

import com.example.demo.service.TestService;
import com.example.demo.service.ThreadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private TestService service;
    @Test
    void contextLoads() {
        service.test();
    }

    @Autowired
    private ThreadService threadService;

    @Test
    void test(){
        System.out.println(threadService.test());
    }

}
