package com.example.demo.bus;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoMagicEsbBalancer implements MagicEsbBalancer {

    private static final String topicExchangeName = "spring-boot-exchange-demo-7";

    private final RabbitTemplate rabbitTemplate;

    public DemoMagicEsbBalancer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void doSomethingWithThis(String message) {
        System.out.println("Sending message...");
        String resultMessage;
        if (checkAnton(message)) {
            resultMessage = enrichAnton(message);
        } else {
            resultMessage = message;
        }
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", resultMessage);
    }

    private String enrichAnton(String message) {
        return message + " Trofimchuk";
    }

    private boolean checkAnton(String message) {
        return "Anton".equals(message);
    }
}
