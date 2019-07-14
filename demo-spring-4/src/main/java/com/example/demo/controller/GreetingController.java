package com.example.demo.controller;

import com.example.demo.entity.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/requestGreeting")
    public String requestGreeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        greetingService.requestGreeting(name);
        return "Greeting requested for " + name;
    }

    @RequestMapping("/getGreeting")
    public Greeting getGreeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return greetingService.getGreeting(name);
    }

}