package com.example.demo.service;

import com.example.demo.entity.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GreetingService {

    Greeting greetByName(String name);

}