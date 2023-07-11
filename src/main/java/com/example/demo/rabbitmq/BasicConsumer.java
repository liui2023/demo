//package com.example.demo.rabbitmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * @Author LiuYi
// * @Date 2023/6/7  13:30
// * @Desc 又是充满希望的一天
// */
//@Component
//@Slf4j
//public class BasicConsumer {
//
//    /**
//     * 监听并消费队列中的消息
//     */
//    @RabbitListener(queues = "${mq.basic.info.queue.name}", containerFactory = "singleListenerContainer")
//    public void consumerMsg(@Payload byte[] msg) {
////        byte[] msg = message.getBody();
//        try {
//            String messageStr = new String(msg, "utf-8");
//            log.info("基本消息模型-消费者-监听并消费到的消息：{}", messageStr);
//
//        } catch (UnsupportedEncodingException e) {
//
//            log.error("基本消息模型-消费者-发生异常：", e.fillInStackTrace());
//        }
//    }
//
//
//}
//
