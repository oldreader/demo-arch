package com.example.demo.service;

import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DemoGreetingProcessingService implements GreetingProcessingService {

    private static final String template = "Hello, %s!";

    private final GreetingRepository greetingRepository;

    public DemoGreetingProcessingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void processMessage(String message) {
        Greeting loaded = greetingRepository.findByName(message);
        if (Objects.isNull(loaded)) {
            greetingRepository.save(new Greeting(String.format(template, message), message));
        }
    }
}
