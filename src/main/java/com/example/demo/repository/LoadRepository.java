package com.example.demo.repository;

// src/main/java/com/example/demo/repository/LoadRepository.java

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Load;

import java.util.List;

public interface LoadRepository extends CrudRepository<Load, Long> {
    List<Load> findByShipperId(String shipperId);
}
