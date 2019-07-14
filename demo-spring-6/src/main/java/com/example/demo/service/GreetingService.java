package com.example.demo.service;

import com.example.demo.entity.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GreetingService {

    void requestGreeting(String name);

    Greeting getGreeting(String name);

}