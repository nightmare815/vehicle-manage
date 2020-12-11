package com.bin.vehicle.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMQConfig {

    @Bean
    public Queue messageQueue(){
        return new Queue("springbootApplication-vehicle-receiver",true,false,false,null);
    }

    @Bean
    public Queue errlogQueue(){
        return new Queue("springbootApplication-vehicle-errorlog",true,false,false,null);
    }

    @Bean
    public Exchange defaultExchange() {
        return new TopicExchange("amq.topic", true, false);
    }

    @Bean
    public Binding messageBinding() {
        return new Binding("springbootApplication-vehicle-receiver", Binding.DestinationType.QUEUE, "amq.topic", ".Car.Vehicle_pub", null);
    }

    @Bean
    public Binding errlogBinding() {
        return new Binding("springbootApplication-vehicle-errorlog", Binding.DestinationType.QUEUE, "amq.topic", "public.errlog", null);
    }
}
