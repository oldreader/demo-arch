package com.example.demo.integration.usecase;

import com.example.demo.entity.Greeting;

public interface ReadGreetingUsecase {
     Greeting request(String request);
}
