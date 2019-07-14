package com.example.demo.integration.command;

import com.example.demo.entity.Greeting;

public interface ReadGreetingCommand {
     Greeting request(String request);
}
