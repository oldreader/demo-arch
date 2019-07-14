package com.example.demo.service;

import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DemoGreetingService implements GreetingService {

    private static final String template = "Hello, %s!";

    private final GreetingRepository greetingRepository;

    public DemoGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting greetByName(String name) {
        Greeting loaded = greetingRepository.findByName(name);
        if (Objects.isNull(loaded)) {
            return greetingRepository.save(new Greeting(String.format(template, name), name));
        }
        return loaded;
    }
}
