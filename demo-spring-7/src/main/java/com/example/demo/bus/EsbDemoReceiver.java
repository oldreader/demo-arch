package com.example.demo.bus;

import org.springframework.stereotype.Component;

@Component
public class EsbDemoReceiver {

    private final MagicEsbBalancer magicEsbBalancer;

    public EsbDemoReceiver(MagicEsbBalancer magicEsbBalancer) {
        this.magicEsbBalancer = magicEsbBalancer;
    }

    public void receiveMessage(String message) {
        System.out.println("Received esb <" + message + ">");
        magicEsbBalancer.doSomethingWithThis(message);
    }

}