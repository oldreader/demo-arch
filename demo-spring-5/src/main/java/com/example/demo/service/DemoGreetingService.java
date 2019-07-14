package com.example.demo.service;

import com.example.demo.bus.InternalBus;
import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DemoGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;
    private final InternalBus internalBus;

    public DemoGreetingService(GreetingRepository greetingRepository, InternalBus internalBus) {
        this.greetingRepository = greetingRepository;
        this.internalBus = internalBus;
    }

    @Override
    public void requestGreeting(String name) {
        internalBus.fireName(name);
    }

    @Override
    public Greeting getGreeting(String name) {
        return greetingRepository.findByName(name);
    }
}
