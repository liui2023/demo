package com.example.demo;

import com.example.demo.dto.Dto;
import com.example.demo.rabbitmq.BasicPublisher;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author LiuYi
 * @Date 2023/6/7  14:16
 * @Desc 又是充满希望的一天
 */

@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private BasicPublisher basicPublisher;

    // 测试 基本消息模型，消息内容为 字符串
    @Test
    public void testBasicMessageModel() {
        String msgStr = "kjhgfd";
        basicPublisher.sendMsg(msgStr, Dto.builder().build());
    }
}
