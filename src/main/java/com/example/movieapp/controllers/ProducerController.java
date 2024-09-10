package com.example.movieapp.controllers;

import com.example.movieapp.entities.Producer;
import com.example.movieapp.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producers")
public class ProducerController {

    @Autowired
    ProducerRepository producerRepository;

    @GetMapping("")
    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Producer> createProducer(@RequestBody Producer producer) {
        return new ResponseEntity<>(producerRepository.save(producer), HttpStatus.CREATED);
    }
}
