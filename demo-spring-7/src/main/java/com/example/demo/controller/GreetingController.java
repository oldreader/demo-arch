package com.example.demo.controller;

import com.example.demo.entity.Greeting;
import com.example.demo.integration.usecase.ReadGreetingUsecase;
import com.example.demo.integration.usecase.WriteGreetingUsecase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final ReadGreetingUsecase readGreetingUsecase;
    private final WriteGreetingUsecase writeGreetingUsecase;

    public GreetingController(ReadGreetingUsecase readGreetingUsecase, WriteGreetingUsecase writeGreetingUsecase) {
        this.readGreetingUsecase = readGreetingUsecase;
        this.writeGreetingUsecase = writeGreetingUsecase;
    }

    @RequestMapping("/requestGreeting")
    public String requestGreeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        writeGreetingUsecase.request(name);
        return "Greeting requested for " + name;
    }

    @RequestMapping("/getGreeting")
    public Greeting getGreeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return readGreetingUsecase.request(name);
    }

}