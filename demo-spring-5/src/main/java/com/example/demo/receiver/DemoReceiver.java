package com.example.demo.receiver;

import java.util.concurrent.CountDownLatch;

import com.example.demo.service.DemoGreetingProcessingService;
import com.example.demo.service.GreetingProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoReceiver {


    private final GreetingProcessingService greetingProcessingService;

    public DemoReceiver(GreetingProcessingService greetingProcessingService) {
        this.greetingProcessingService = greetingProcessingService;
    }


    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        greetingProcessingService.processMessage(message);
    }

}