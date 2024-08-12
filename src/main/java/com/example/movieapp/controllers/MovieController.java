package com.example.movieapp.controllers;

import com.example.movieapp.dto.MovieDTO;
import com.example.movieapp.entities.Movie;
import com.example.movieapp.entities.Producer;
import com.example.movieapp.exceptions.ParentRecordNotFoundException;
import com.example.movieapp.repositories.MovieRepository;
import com.example.movieapp.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.movieapp.enums.ErrorCode.PRODUCER_NOT_FOUND;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ProducerRepository producerRepository;

    @GetMapping("")
    public List<Movie> getAllProducers() {
        return movieRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDTO movieDTO) {
        Producer producer = producerRepository.findById(movieDTO.getProducerId())
                .orElseThrow(() -> new ParentRecordNotFoundException(PRODUCER_NOT_FOUND, "Producer with id: " + movieDTO.getProducerId() + " has not been found"));

        Movie movie = new Movie(movieDTO.getGenre(), movieDTO.getTitle(), movieDTO.getDescription(), movieDTO.getYear(), producer);

        return new ResponseEntity<>(movieRepository.save(movie), HttpStatus.CREATED);
    }
}
