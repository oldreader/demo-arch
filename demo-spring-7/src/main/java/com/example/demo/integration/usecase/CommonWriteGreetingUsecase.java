package com.example.demo.integration.usecase;

import com.example.demo.service.GreetingService;
import org.springframework.stereotype.Component;

@Component
public class CommonWriteGreetingUsecase implements WriteGreetingUsecase {

    private final GreetingService greetingService;

    public CommonWriteGreetingUsecase(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void request(String request) {
        greetingService.requestGreeting(request);
    }
}
