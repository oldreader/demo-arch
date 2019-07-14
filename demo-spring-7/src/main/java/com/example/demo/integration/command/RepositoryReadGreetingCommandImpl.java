package com.example.demo.integration.command;

import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.stereotype.Component;

@Component
public class RepositoryReadGreetingCommandImpl implements ReadGreetingCommand {

    private final GreetingRepository greetingRepository;

    public RepositoryReadGreetingCommandImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting request(String request) {
        return greetingRepository.findByName(request);
    }
}
