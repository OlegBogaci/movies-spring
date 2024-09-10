package com.example.movieapp.controllers;

import com.example.movieapp.dto.ReviewDTO;
import com.example.movieapp.entities.Movie;
import com.example.movieapp.entities.Review;
import com.example.movieapp.exceptions.ParentRecordNotFoundException;
import com.example.movieapp.repositories.MovieRepository;
import com.example.movieapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.movieapp.enums.ErrorCode.MOVIE_NOT_FOUND;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDTO) {
        Movie movie = movieRepository.findById(reviewDTO.getMovieId())
                .orElseThrow(() -> new ParentRecordNotFoundException(MOVIE_NOT_FOUND, "Movie with id: " + reviewDTO.getMovieId() + " has not been found"));

        Review review = new Review(reviewDTO.getReviewerName(), reviewDTO.getComment(), reviewDTO.getRate(), movie);

        return new ResponseEntity<>(reviewRepository.save(review), HttpStatus.CREATED);
    }
}
