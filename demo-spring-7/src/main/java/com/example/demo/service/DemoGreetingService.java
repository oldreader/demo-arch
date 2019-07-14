package com.example.demo.service;

import com.example.demo.bus.InternalBus;
import com.example.demo.entity.Greeting;
import com.example.demo.integration.command.ReadGreetingCommand;
import com.example.demo.integration.command.WriteGreetingCommand;
import com.example.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DemoGreetingService implements GreetingService {

    private final ReadGreetingCommand greetingRepository;
    private final WriteGreetingCommand writeGreetingCommand;

    public DemoGreetingService(ReadGreetingCommand greetingRepository, WriteGreetingCommand writeGreetingCommand) {
        this.greetingRepository = greetingRepository;
        this.writeGreetingCommand = writeGreetingCommand;
    }

    @Override
    public void requestGreeting(String name) {
        writeGreetingCommand.request(name);
    }

    @Override
    public Greeting getGreeting(String name) {
        return greetingRepository.request(name);
    }
}
