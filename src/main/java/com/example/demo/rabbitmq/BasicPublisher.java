//package com.example.demo.rabbitmq;
//
//import com.example.demo.dto.Dto;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mysql.cj.util.StringUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageBuilder;
//import org.springframework.amqp.core.MessageDeliveryMode;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Objects;
//
///**
// * @Author LiuYi
// * @Date 2023/6/7  13:28
// * @Desc 又是充满希望的一天
// */
//@Component
//@Slf4j
//public class BasicPublisher {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    Environment env;
//
//    // 发送字符串类型的消息
//    public void sendMsg(String messageStr, Dto dto) {
//        if (!StringUtils.isNullOrEmpty(messageStr)) {
//            try {
//                Jackson2JsonMessageConverter messageConverter= new Jackson2JsonMessageConverter();
//                messageConverter.setDefaultCharset("UTF-8");
//                rabbitTemplate.setMessageConverter(messageConverter);
//                rabbitTemplate.setExchange(env.getProperty("mq.basic.info.exchange.name"));
//                rabbitTemplate.setRoutingKey(Objects.requireNonNull(env.getProperty("mq.basic.info.routing.key.name")));
//
//                //将Java对象转换程json
//                ObjectMapper objectMapper = new ObjectMapper();
//                byte[] bytes = objectMapper.writeValueAsBytes(dto);
//
//                // 2创建队列、交换机、消息 设置持久化模式
//                // 设置消息的持久化模式
////                Message message = MessageBuilder.withBody(messageStr.getBytes("utf-8")).
////                        setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
//                Message message = MessageBuilder.withBody(bytes).
//                        setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
//
//                rabbitTemplate.convertAndSend(message.getBody());
//                log.info("基本消息模型-生产者-发送消息：{}", messageStr);
//
//            } catch (Exception e) {
//                log.error("基本消息模型-生产者-发送消息发生异常：{}", messageStr, e.fillInStackTrace());
//            }
//        }
//    }
//
//}
//
