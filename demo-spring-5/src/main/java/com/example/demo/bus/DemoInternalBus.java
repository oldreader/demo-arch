package com.example.demo.bus;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoInternalBus implements InternalBus {

    static final String topicExchangeName = "spring-boot-exchange";

    private final RabbitTemplate rabbitTemplate;


    public DemoInternalBus(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void fireName(String name) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", name);
    }
}
