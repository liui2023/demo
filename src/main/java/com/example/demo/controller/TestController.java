package com.example.demo.controller;

import com.example.demo.dto.Dto;
import com.example.demo.dto.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.rabbitmq.BasicPublisher;
import com.example.demo.service.TestService;
import com.example.demo.test.TestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiuYi
 * @Date 2023/6/5  11:22
 * @Desc 又是充满希望的一天
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestB testB;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestService service;

    @GetMapping
    public void b(){
//        testMapper.insert(Test.builder().build());
//        testB.b();
//        service.test();
        String msgStr = "这是一串字符串消息";
        basicPublisher.sendMsg(msgStr, Dto.builder().build());
    }

    @Autowired
    private BasicPublisher basicPublisher;

    // 测试 基本消息模型，消息内容为 字符串
    public void testBasicMessageModel() {
        String msgStr = "~~~这是一串字符串消息~~~~";
        basicPublisher.sendMsg(msgStr, Dto.builder().build());
    }
}
