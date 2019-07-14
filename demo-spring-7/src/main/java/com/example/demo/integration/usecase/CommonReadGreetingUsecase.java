package com.example.demo.integration.usecase;

import com.example.demo.entity.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.stereotype.Component;

@Component
public class CommonReadGreetingUsecase implements ReadGreetingUsecase {

    private final GreetingService greetingService;

    public CommonReadGreetingUsecase(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public Greeting request(String request) {
        return greetingService.getGreeting(request);
    }
}
