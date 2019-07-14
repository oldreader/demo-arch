package com.example.demo.repository;

import com.example.demo.entity.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    List<Greeting> findByContent(String content);

    Greeting findByName(String name);
}