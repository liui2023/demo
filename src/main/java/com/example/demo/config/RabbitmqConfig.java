package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

/**
 * @Author LiuYi
 * @Date 2023/6/7  13:25
 * @Desc 又是充满希望的一天
 * 参考 ：https://www.cnblogs.com/coder-zyc/p/14916736.html
 */
@Configuration
@Slf4j
public class RabbitmqConfig {

    // Spring-Boot的依赖注入功能
    // 注入连接工厂：Spring-Boot的依赖注入：启动时，RabbitProperties会自动读取RabbitMQ的配置信息。
    // 若配置参数命名符合其规范，会注入到spring的bean容器中，创建生成连接工厂
    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    Environment env;

    // 注入连接工厂：编写代码，读取application.properties配置文件中的MQ的配置参数，生成连接工厂
   /* @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory(
            @Value("${spring.rabbitmq.host}") String host,
            @Value("${spring.rabbitmq.port}") int port,
            @Value("${spring.rabbitmq.username}") String username,
            @Value("${spring.rabbitmq.password}") String password,
            @Value("${spring.rabbitmq.virtual-host}") String virtualHost) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setPort(port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost(virtualHost);

        return cachingConnectionFactory;
    }*/

    /**
     * 构建RabbitMQ发送消息的操作组件实例
     * 生产者的发送确认机制
     */
    @Bean(name = "rabbitMQTemplate")
    public RabbitTemplate rabbitTemplate() {
        // 生产者确认消息是否发送过去了
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.SIMPLE);

        // 生产者发送消息后，返回反馈消息
        connectionFactory.setPublisherReturns(true);

        // 构建rabbitTemlate操作模板
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);

        // 生产者发送消息后，如果发送成功，则打印“消息发送成功”的日志信息
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
            }
        });

        // 生产者发送消息后，若发送失败，则输出“消息发送失败”的日志信息
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",
                        returnedMessage.getExchange(),returnedMessage.getRoutingKey(),returnedMessage.getReplyCode(),
                        returnedMessage.getReplyText(),returnedMessage.getMessage());

            }
        });

        return rabbitTemplate;
    }

    /**
     * 设置单个消费者
     * 消费者的Ack确认机制为AUTO
     */
    @Bean(name = "singleListenerContainer")
    public SimpleRabbitListenerContainerFactory listenerContainerFactory() {
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);

        Jackson2JsonMessageConverter  messageConverter= new Jackson2JsonMessageConverter();
        messageConverter.setDefaultCharset("UTF-8");
        containerFactory.setMessageConverter(messageConverter);

        // 设置消费者的个数
        containerFactory.setConcurrentConsumers(1);
        // 设置消费者的最大值
        containerFactory.setMaxConcurrentConsumers(1);
        // 设置消费者每次拉取的消息数量，即消费者一次拉取几条消息
        containerFactory.setPrefetchCount(1);

        // 设置确认消息模型为自动确认消费AUTO，目的是防止消息丢失和消息被重复消费
        containerFactory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return containerFactory;
    }

    /**
     * 创建direct消息模型：队列、交换机、路由
     */
    // 1.1、创建队列
    @Bean(name = "basicQueue")
    public Queue basicQueue() {
        return new Queue(Objects.requireNonNull(env.getProperty("mq.basic.info.queue.name")), true);
    }

    // 1.2、创建交换机
    @Bean
    public DirectExchange basicExchange() {
        return new DirectExchange(env.getProperty("mq.basic.info.exchange.name"), true, false);
    }

    // 1.3、创建绑定关系
    @Bean
    public Binding basicBinding() {
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with(env.getProperty("mq.basic.info.routing.key.name"));
    }





}





























