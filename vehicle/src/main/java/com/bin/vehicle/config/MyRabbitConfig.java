package com.bin.vehicle.config;
import com.bin.vehicle.listener.RabbitAckReceiver;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class MyRabbitConfig {
    public static int num = 1;

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private RabbitAckReceiver rabbitAckReceiver;//消息接收处理类

    @Value("${myrabbitmq.queue.receiver}")
    private String receiveQueue;
    @Value("${myrabbitmq.queue.errorlog}")
    private String errorQueue;

    /**
     * 使用JSON序列化机制, 进行消息转换
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

    /**
     * 定制RabbitmqTemplate
     * 一. 发送端确认: 保证发送的每条消息能够正确到达队列
     *      1.broker服务器收到消息的回调
     *          (1).spring.rabbitmq.publisher-confirms=true
     *          (2).设置确认回调
     *
     *      2.消息正确到达队列的回调
     *          spring.rabbitmq.publisher-returns=true
     *          spring.rabbitmq.template.mandatory=true
     *
     * 二. 接收端确认: 保证每条消息能够被正确消费;;;    默认是自动确认的, 只要消息被接收到, 不管有没有被正确消费, 服务端都会移除这条消息
     *      1.手动确认模式: 只要没有手动进行ack, 消息就不会被消费. basicAck(long deliveryTag, boolean multiple); //第二个参数，手动确认可以被批处理，
     *                                                              当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
     *                                                          basicNack(long deliveryTag, boolean multiple, boolean requeue)
     *                                                          void basicReject(long deliveryTag, boolean requeue) //不可批量拒绝
     */
    @PostConstruct  //MyRabbitConfig对象创建完成后, 执行这个方法
    public void initRabbitTemplate() {
        //设置消息抵达broker回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             *
             * @param correlationData   当前消息的唯一关联数据
             * @param ack   消息成功到达broker就为true
             * @param cause 失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("confirm...correlationData[" + correlationData + "]========ack["+ack+"]======cause[" + cause+"]");
            }
        });

        //设置消息到达队列回调
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            /**
             * 消息没有投递给指定的队列, 此回调方法才会触发回调
             */
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                String exchange = returnedMessage.getExchange();
                String routingKey = returnedMessage.getRoutingKey();
                String replyText = returnedMessage.getReplyText();
                int replyCode = returnedMessage.getReplyCode();
                Message message = returnedMessage.getMessage();

                log.info("message:[{}], replyCode:[{}] , replyText:[{}] ,exchange:[{}],routingKey:[{}]", message,replyCode,replyText,exchange,routingKey);
            }

        });
    }

    /**
     * 消息接收监听
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        container.setQueueNames(receiveQueue,errorQueue);  //用来接收汽车状态消息的队列, 和接收错误日志信息的队列
        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
        //  container.setQueueNames("TestDirectQueue","TestDirectQueue2","TestDirectQueue3");
        container.setMessageListener(rabbitAckReceiver);

        return container;
    }
}
