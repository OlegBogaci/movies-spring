package com.example.movieapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewerName;
    private String comment;
    private Double rate;

    @ManyToOne
    @JoinColumn // default name = field + PK
    private Movie movie;

    public Review() {}

    public Review(String reviewerName, String comment, Double rate, Movie movie) {
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.rate = rate;
        this.movie = movie;
    }
}
